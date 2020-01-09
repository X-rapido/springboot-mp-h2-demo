package com.helijia.quickstart.student.service;

import com.helijia.quickstart.module.student.entity.Student;
import com.helijia.quickstart.module.student.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class S_SaveTests {

    @Autowired
    protected StudentService service;

    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * boolean save(T entity);
     */
    @Test
    public void save() {
        Assert.isTrue(service.save(new Student().setName("Hello").setAge(18)),"保存失败");
    }

    /**
     * 插入（批量），该方法不适合 Oracle
     *
     * default boolean saveBatch(Collection<T> entityList)
     *
     * boolean saveBatch(Collection<T> entityList, int batchSize);
     */
    @Test
    public void saveBatch() {
        List<Student> list = new ArrayList<>();
        list.add(new Student().setName("A").setAge(18));
        list.add(new Student().setName("B").setAge(18));
        list.add(new Student().setName("C").setAge(18));
        list.add(new Student().setName("D").setAge(18));

        Assert.isTrue(service.saveBatch(list));
    }

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * boolean saveOrUpdate(T entity);
     */
    @Test
    public void saveOrUpdate() {
        Assert.isTrue(service.saveOrUpdate(new Student().setId(1).setName("听风")),"保存失败");
    }

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * boolean saveOrUpdateBatch(Collection<T> entityList);
     */
    @Test
    public void saveOrUpdateBatch() {
        List<Student> list = new ArrayList<>();
        list.add(new Student().setName("A").setAge(18));
        list.add(new Student().setName("B").setAge(18));
        list.add(new Student().setName("C").setAge(18));
        list.add(new Student().setName("D").setAge(18));

        Assert.isTrue(service.saveOrUpdateBatch(list),"保存失败");
    }

}
