package com.helijia.quickstart.mapper;

import com.helijia.quickstart.module.student.entity.Student;
import com.helijia.quickstart.module.student.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Date;

@SpringBootTest
public class InsertTests {

    @Autowired
    protected StudentMapper mapper;

    /**
     * 插入一条记录
     * <p>
     * int insert(T entity);
     */
    @Test
    public void insert() {
        Student stu = new Student();
        stu.setId(10);
        stu.setAge(21);
        stu.setName("苹果");
        stu.setEmail("apple@qq.com");
        stu.setCreateTime(new Date());

        Assert.isTrue(mapper.insert(stu) > 0, "插入失败");
    }

}
