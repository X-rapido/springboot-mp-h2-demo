package com.helijia.quickstart.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.helijia.quickstart.module.student.entity.Student;
import com.helijia.quickstart.module.student.service.StudentService;
import com.helijia.quickstart.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class S_SelectTests {

    @Autowired
    protected StudentService service;

    /**
     * 根据 id 查询
     * <p>
     * T getById(Serializable id);
     */
    @Test
    public void getById() {
        System.out.println(service.getById(1));
    }

    /**
     * 根据 Wrapper，查询一条记录，查询多个会出异常，追加 last("limit 1")
     * <p>
     * default T getOne(Wrapper<T> queryWrapper);
     * <p>
     * 有多个 result 是否抛出异常
     * <p>
     * T getOne(Wrapper<T> queryWrapper, boolean throwEx);
     */
    @Test
    public void getOne() {
        // 单个对象，常规方式
        Student stu_1 = service.getOne(new QueryWrapper<Student>().ge("id", 2).last("limit 1"));
        System.out.println("stu_1：" + stu_1.toString());

        // 单个对象，lambda表达式方式
        Student stu_2 = service.getOne(new QueryWrapper<Student>().lambda().ge(Student::getId, 2), false);
        System.out.println("stu_2：" + stu_2.toString());
    }

    /**
     * 查询（根据ID 批量查询）
     * <p>
     * Collection<T> listByIds(Collection<? extends Serializable> idList);
     */
    @Test
    public void listByIds() {
        Collection<Student> students = service.listByIds(Arrays.asList(3, 4, 5));
        students.forEach(System.out::println);
    }

    /**
     * 查询列表
     * <p>
     * List<T> list(Wrapper<T> queryWrapper);
     */
    @Test
    public void list() {
        Collection<Student> students = service.list(new QueryWrapper<Student>().lt("age", 25));
        students.forEach(System.out::println);
    }

    /**
     * 查询（根据 columnMap 条件）
     * <p>
     * Collection<T> listByMap(Map<String, Object> columnMap);
     */
    @Test
    public void listByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "TingFeng");
        map.put("age", "25");

        Collection<Student> students = service.listByMap(map);
        students.forEach(System.out::println);
    }

    /**
     * 根据 Wrapper 条件，查询总记录数
     * <p>
     * int count(Wrapper<T> queryWrapper);
     */
    @Test
    public void count() {
        // 小于 25 岁总数
        Integer count = service.count(new QueryWrapper<Student>().lambda().lt(Student::getAge, 25));
        System.out.println("count：" + count);
    }

    /**
     * 根据 Wrapper 条件，查询全部记录
     * <p>
     * List<Object> listObjs(Wrapper<T> queryWrapper);
     */
    @Test
    public void listObjs() {
        // 小于25
        List<Object> objs = service.listObjs(new QueryWrapper<Student>().lambda().lt(Student::getAge, 25));
        System.out.println("Objs：" + JsonUtil.obj2String(objs));
    }

    /**
     * 根据 Wrapper 条件，查询全部记录
     * <p>
     * List<Map<String, Object>> listMaps(Wrapper<T> queryWrapper);
     */
    @Test
    public void listMaps() {
        // 小于25
        List<Map<String, Object>> list = service.listMaps(new QueryWrapper<Student>().lambda().lt(Student::getAge, 25));
        System.out.println("listMaps：" + JsonUtil.obj2String(list));
    }

    /**
     * 根据 Wrapper，查询一条记录
     * <p>
     * getObj(Wrapper<T> queryWrapper, Function<? super Object, V> mapper);
     */
    @Test
    public void getObj() {
        Object obj = service.getObj(new QueryWrapper<Student>().lambda().lt(Student::getAge, 25), x->x);
        System.out.println("Obj：" + obj);
    }

    /**
     * 分页查询
     * <p>
     * IPage<T> page(IPage<T> page, Wrapper<T> queryWrapper);
     */
    @Test
    public void page() {
        // 年龄大于等于18
        IPage<Student> selectPage = service.page(new Page<>(1, 3), new QueryWrapper<Student>().ge("age", 18));
        System.out.println(JsonUtil.obj2String(selectPage));
    }

    /**
     * 分页查询
     * <p>
     * IPage<Map<String, Object>> pageMaps(IPage<T> page, Wrapper<T> queryWrapper);
     */
    @Test
    public void pageMaps() {
        // 年龄大于等于23
        IPage<Map<String, Object>> mapsPage = service.pageMaps(new Page<>(1, 3), new QueryWrapper<Student>().ge("age", 23));
        System.out.println(JsonUtil.obj2String(mapsPage));
    }


}
