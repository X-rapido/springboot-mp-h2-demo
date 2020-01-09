package com.helijia.quickstart.common.config;


import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
 *
 * doc：https://mp.baomidou.com/guide/generator.html
 */
public class MybatisCodeGenerator {

    private static String db_driver = "com.mysql.cj.jdbc.Driver";
    private static String db_url = "jdbc:mysql://localhost:3306/demo?useUnicode=true&useSSL=false&allowPublicKeyRetrieval=true";
    private static String db_username = "tingfeng";
    private static String db_password = "tingfeng";

    private static String author = "tingfeng";

    private static String base_package = "com.helijia.quickstart.module";
    private static String super_entity_class = "com.xxx.BaseEntity";
    private static String super_controller_class = "com.xxx.BaseController";
    private static String super_mapper_class = "com.xxx.BaseMapper";
    private static String super_service_class = "com.xxx.BaseService";
    private static String super_service_impl_class =  "com.xxx.BaseServiceImpl";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setOpen(false);
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setAuthor(author);
        mpg.setGlobalConfig(gc);

        // 2、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(db_url);
        dsc.setDriverName(db_driver);
        dsc.setUsername(db_username);
        dsc.setPassword(db_password);
        mpg.setDataSource(dsc);

        // 3、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent(base_package);
        mpg.setPackageInfo(pc);

        // 4、自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
//        String templatePath = "/templates/mapper.xml.vm";

        // 5、自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 6、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);          // 表名生成策略（下划线转驼峰命名）
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);    // 列名生成策略
        strategy.setRestControllerStyle(true);                          // 生成 @RestController 控制器
        strategy.setControllerMappingHyphenStyle(true);                 // 驼峰转连字符
        strategy.setEntityLombokModel(true);                            // 使用 lombok 模式, 默认 false
        strategy.setSkipView(true);                                     // 跳过视图
        strategy.setEntitySerialVersionUID(false);                      // 关闭序列化
        strategy.setCapitalMode(false);                                 // 是否大写命名
//        strategy.setSuperEntityClass(super_entity_class);                     // 公共父类
//        strategy.setSuperEntityColumns("id");                                 // 公共父类字段，单个
//        strategy.setSuperEntityColumns(new String[] { "test_id", "age" });    // 公共父类字段，多个
//        strategy.setSuperMapperClass(super_mapper_class);                     // 公共 mapper 父类
//        strategy.setSuperControllerClass(super_controller_class);             // 公共 controller 父类
//        strategy.setSuperServiceClass(super_service_class);                   // 公共 service 父类
//        strategy.setSuperServiceImplClass(super_service_impl_class);          // 公共 service 实现类父类
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setTablePrefix(pc.getModuleName() + "_");                      // 此处可以修改为您的表前缀
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());                  // freemarker 模板引擎

        // 7、执行生成
        mpg.execute();
    }

}
