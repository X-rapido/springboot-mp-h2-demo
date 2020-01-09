package com.helijia.quickstart.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.helijia.quickstart.module.student.entity.Student;
import com.helijia.quickstart.module.student.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class S_UpdateTests {

    @Autowired
    protected StudentService service;

    /**
     * 根据 ID 选择修改
     * <p>
     * boolean updateById(T entity);
     */
    @Test
    public void updateById() {
        Assert.isTrue(service.updateById(new Student().setId(1).setEmail("abc@sina.com")), "修改失败");
    }

    /**
     * 根据 whereEntity 条件，更新记录
     * <p>
     * boolean update(T entity, Wrapper<T> updateWrapper);
     */
    @Test
    public void update() {
        Assert.isTrue(service.update(new Student().setName("TingFeng"),
                new UpdateWrapper<Student>().lambda()
                        .set(Student::getAge, 3)
                        .eq(Student::getId, 2)),"修改失败");
    }

    /**
     * 根据ID 批量更新
     * <p>
     * default boolean updateBatchById(Collection<T> entityList)
     * <p>
     * boolean updateBatchById(Collection<T> entityList, int batchSize)
     */
    @Test
    public void updateBatchById() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(5, "Angela", 25, "angela@qq.com", new Date(), 0));
        list.add(new Student(6, "Alice", 22, "alice@qq.com", new Date(), 0));

        Assert.isTrue(service.updateBatchById(list), "修改失败");
    }


}
