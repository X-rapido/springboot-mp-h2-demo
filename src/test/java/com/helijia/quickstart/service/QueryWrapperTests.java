package com.helijia.quickstart.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.helijia.quickstart.module.student.entity.Student;
import com.helijia.quickstart.module.student.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class QueryWrapperTests {

    @Autowired
    protected StudentService service;

    /**
     * 全部等于
     */
    @Test
    public void allEq() {
        Map<String, Object> map = new HashMap<>();
        map.put("age", 18);
        map.put("email", null);

        Collection<Student> stuList_1 = service.list(new QueryWrapper<Student>().allEq(map));
        stuList_1.forEach(System.out::println);

        Collection<Student> stuList_2 = service.list(new QueryWrapper<Student>().allEq(map, false));
        stuList_2.forEach(System.out::println);
    }

    /**
     * 基础操作
     */
    @Test
    public void basicExpression() {
        // 等于
        Collection<Student> stu_1 = service.list(new QueryWrapper<Student>().eq("age", 18));
        stu_1.forEach(System.out::println);

        // 不等于
        Collection<Student> stu_2 = service.list(new QueryWrapper<Student>().ne("age", 18));
        stu_2.forEach(System.out::println);

        // 大于
        Collection<Student> stu_3 = service.list(new QueryWrapper<Student>().gt("age", 18));
        stu_3.forEach(System.out::println);

        // 大于等于
        Collection<Student> stu_4 = service.list(new QueryWrapper<Student>().ge("age", 18));
        stu_4.forEach(System.out::println);

        // 小于
        Collection<Student> stu_5 = service.list(new QueryWrapper<Student>().lt("age", 18));
        stu_5.forEach(System.out::println);

        // 小于等于
        Collection<Student> stu_6 = service.list(new QueryWrapper<Student>().le("age", 18));
        stu_6.forEach(System.out::println);
    }

    /**
     * 两者之间
     */
    @Test
    public void betweenAbout() {
        // BETWEEN 值1 AND 值2
        Collection<Student> stu_1 = service.list(new QueryWrapper<Student>().between("age", 18, 23));
        stu_1.forEach(System.out::println);

        // Not BETWEEN 值1 AND 值2
        Collection<Student> stu_2 = service.list(new QueryWrapper<Student>().notBetween("age", 18, 23));
        stu_2.forEach(System.out::println);
    }

    /**
     * 模糊查询
     */
    @Test
    public void likeAbout() {
        // LIKE '%值%'
        Collection<Student> stu_1 = service.list(new QueryWrapper<Student>().like("name", "T"));
        stu_1.forEach(System.out::println);

        // NOT LIKE '%值%'
        Collection<Student> stu_2 = service.list(new QueryWrapper<Student>().notLike("name", "T"));
        stu_2.forEach(System.out::println);

        // LIKE '%值'
        Collection<Student> stu_3 = service.list(new QueryWrapper<Student>().likeLeft("name", "T"));
        stu_3.forEach(System.out::println);

        // LIKE '值%'
        Collection<Student> stu_4 = service.list(new QueryWrapper<Student>().likeRight("name", "T"));
        stu_4.forEach(System.out::println);
    }

    /**
     * Null 操作
     */
    @Test
    public void nullAbout() {
        // 字段 IS NULL
        Collection<Student> stu_1 = service.list(new QueryWrapper<Student>().isNull("name"));
        stu_1.forEach(System.out::println);

        // 字段 IS NOT NULL
        Collection<Student> stu_2 = service.list(new QueryWrapper<Student>().isNotNull("name"));
        stu_2.forEach(System.out::println);
    }


    /**
     * In 操作
     */
    @Test
    public void in() {
        // IN (v0, v1, ...)
        Collection<Student> stu_1 = service.list(new QueryWrapper<Student>().in("id", 1, 2, 3));
        stu_1.forEach(System.out::println);

        Collection<Student> stu_1_2 = service.list(new QueryWrapper<Student>().in("id", Arrays.asList(1, 2, 3)));
        stu_1_2.forEach(System.out::println);

        // NOT IN (v0, v1, ...)
        Collection<Student> stu_2 = service.list(new QueryWrapper<Student>().notIn("id", 2, 3));
        stu_2.forEach(System.out::println);
    }

    /**
     * inSql 操作
     */
    @Test
    public void inSqlAbout() {
        Collection<Student> stu_1 = service.list(new QueryWrapper<Student>().inSql("id", "1,2,3"));
        stu_1.forEach(System.out::println);

        Collection<Student> stu_2 = service.list(new QueryWrapper<Student>().inSql("id", "select id from student where id < 5"));
        stu_2.forEach(System.out::println);

        Collection<Student> stu_3 = service.list(new QueryWrapper<Student>().notInSql("id", "1,2,3"));
        stu_3.forEach(System.out::println);

        Collection<Student> stu_4 = service.list(new QueryWrapper<Student>().notInSql("id", "select id from student where id < 5"));
        stu_4.forEach(System.out::println);
    }

    /**
     * 分组操作
     */
    @Test
    public void groupBy() {
        Collection<Student> stu_1 = service.list(new QueryWrapper<Student>().groupBy("id", "name"));
        stu_1.forEach(System.out::println);
    }

    /**
     * 排序操作
     */
    @Test
    public void orderByAbout() {
        Collection<Student> stu_1 = service.list(new QueryWrapper<Student>().orderByAsc("id", "name"));
        stu_1.forEach(System.out::println);

        Collection<Student> stu_2 = service.list(new QueryWrapper<Student>().orderByDesc("id", "name"));
        stu_2.forEach(System.out::println);
    }

    /**
     * Having 操作
     */
    @Test
    public void Having() {
        // age 重复项
        Collection<Student> stu_1 = service.list(new QueryWrapper<Student>().groupBy("age").having("count(age) > 1"));
        stu_1.forEach(System.out::println);
    }

    /**
     * Or 操作
     */
    @Test
    public void or() {
        Collection<Student> stu_1 = service.list(new QueryWrapper<Student>().eq("name", "Tingfeng").or().eq("name", "Anna"));
        stu_1.forEach(System.out::println);

        // OR 嵌套
        Collection<Student> stu_2 = service.list(new QueryWrapper<Student>().eq("name", "Tingfeng").or(i -> i.eq("name", "Angela")));
        stu_2.forEach(System.out::println);
    }

    /**
     * And 操作
     */
    @Test
    public void and() {
        Collection<Student> stu_1 = service.list(new QueryWrapper<Student>().eq("name", "Tingfeng").and(i -> i.eq("age", "25")));
        stu_1.forEach(System.out::println);
    }

    /**
     * Apply 操作，拼接 sql，该方法可用于数据库函数 动态入参的
     */
    @Test
    public void apply() {
        Collection<Student> stu_1 = service.list(new QueryWrapper<Student>().apply("date_format(create_time,'%Y-%m-%d') = '2018-10-28'"));
        stu_1.forEach(System.out::println);

        Collection<Student> stu_2 = service.list(new QueryWrapper<Student>().apply("date_format(create_time,'%Y-%m-%d') = {0}", "2018-10-28"));
        stu_2.forEach(System.out::println);
    }

    /**
     * 无视优化规则直接拼接到 sql 的最后
     */
    @Test
    public void last() {
        Collection<Student> stu_1 = service.list(new QueryWrapper<Student>().last("limit 3"));
        stu_1.forEach(System.out::println);
    }

    /**
     * EXISTS ( sql语句 )
     */
    @Test
    public void existsAbout() {
        // 拼接 EXISTS ( sql语句 )
        Collection<Student> stu_1 = service.list(new QueryWrapper<Student>().exists("select id from student where age > 20"));
        stu_1.forEach(System.out::println);

        // 拼接 NOT EXISTS ( sql语句 )
        Collection<Student> stu_2 = service.list(new QueryWrapper<Student>().notExists("select id from student where age > 20"));
        stu_2.forEach(System.out::println);
    }

    /**
     * 正常嵌套 不带 AND 或者 OR
     */
    @Test
    public void nested() {
        Collection<Student> stu_1 = service.list(new QueryWrapper<Student>().nested(i -> i.eq("name", "TingFeng").ne("age", "18")));
        stu_1.forEach(System.out::println);

    }

    /**
     * select 相关
     */
    @Test
    public void selectAbout() {
        // 查询特定字段
        Collection<Student> stu_1 = service.list(new QueryWrapper<Student>().select("id", "name", "age"));
        stu_1.forEach(System.out::println);
    }

}
