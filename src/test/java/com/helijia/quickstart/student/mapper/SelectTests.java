package com.helijia.quickstart.student.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.helijia.quickstart.module.student.entity.Student;
import com.helijia.quickstart.module.student.mapper.StudentMapper;
import com.helijia.quickstart.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class SelectTests {

    @Autowired
    protected StudentMapper mapper;

    /**
     * 查询所有
     * 
     * List<T> selectList(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
     */
    @Test
    public void selectList() {
        List<Student> students = mapper.selectList(new QueryWrapper<>());
        students.forEach(System.out::println);
    }

    /**
     * 根据 ID 查询
     * 
     * T selectById(Serializable id);
     */
    @Test
    public void selectById() {
        Student stu = mapper.selectById(1);
        System.out.println("stu：" + stu.toString());
    }

    /**
     * 根据 entity 条件，查询一条记录
     * 
     * T selectOne(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
     */
    @Test
    public void selectOne() {
        // 单个对象，常规方式
        Student stu_1 = mapper.selectOne(new QueryWrapper<Student>().ge("id", 2));
        System.out.println("stu_1：" + stu_1.toString());

        // 单个对象，lambda表达式方式
        Student stu_2 = mapper.selectOne(new QueryWrapper<Student>().lambda().ge(Student::getId, 2));
        System.out.println("stu_2：" + stu_2.toString());
    }

    /**
     * 根据id列表，批量查询
     * 
     * List<T> selectBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
     */
    @Test
    public void selectBatchIds() {
        List<Student> students = mapper.selectBatchIds(Arrays.asList("3", "4,", "5"));
        students.forEach(System.out::println);
    }

    /**
     * 查询（根据 columnMap 条件）
     * 
     * List<T> selectByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
     */
    @Test
    public void selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "TingFeng");
        map.put("age", "25");

        List<Student> students = mapper.selectByMap(map);
        students.forEach(System.out::println);

    }

    /**
     * 查询总数
     * 
     * Integer selectCount(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
     */
    @Test
    public void selectCount() {
        // 小于 25 岁总数
        Integer count = mapper.selectCount(new QueryWrapper<Student>().lambda().lt(Student::getAge, 25));
        System.out.println("count：" + count);
    }

    /**
     * 根据 Wrapper 条件，查询全部记录，只返回第一个字段的值
     * 
     * List<Object> selectObjs(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
     */
    @Test
    public void selectObjs() {
        List<Object> objs = mapper.selectObjs(new QueryWrapper<Student>().lambda().lt(Student::getAge, 25));
        System.out.println("Objs：" + objs.toString());
    }

    /**
     * 分页查询
     * 
     * IPage<T> selectPage(IPage<T> page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
     * 
     * IPage<Map<String, Object>> selectMapsPage(IPage<T> page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
     */
    @Test
    public void selectPage() {
        // 年龄大于等于18
        IPage<Student> selectPage = mapper.selectPage(new Page<>(1, 3), new QueryWrapper<Student>().ge("age", 18));
        System.out.println(JsonUtil.obj2String(selectPage));

        // 年龄大于等于23
        IPage<Map<String, Object>> mapsPage = mapper.selectMapsPage(new Page<>(1,3), new QueryWrapper<Student>().ge("age", 23));
        System.out.println(JsonUtil.obj2String(mapsPage));
    }
}
