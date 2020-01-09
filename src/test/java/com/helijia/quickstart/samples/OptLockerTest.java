package com.helijia.quickstart.samples;

import com.helijia.quickstart.module.student.entity.Student;
import com.helijia.quickstart.module.student.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

/**
 * 乐观锁测试
 */
@SpringBootTest
public class OptLockerTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testUpdateByIdSucc() {
        Student stu = new Student()
                .setName("樱花")
                .setAge(18)
                .setEmail("yinghua@hlj.com")
                .setVersion(1);

        studentService.save(stu);

        Integer id = stu.getId();

        Student stu2 = new Student()
                .setId(id)
                .setName("莺花")
                .setAge(20)
                .setEmail("yinghua@hlj.com")
                .setVersion(1);

        Assert.isTrue(studentService.updateById(stu2), "更新失败");
        Assert.isTrue(stu2.getVersion() == 2, "更新失败");
    }

    @Test
    public void testUpdateByIdFail() {
        Student stu = new Student()
                .setName("樱花")
                .setAge(18)
                .setEmail("yinghua@hlj.com")
                .setVersion(1);

        studentService.save(stu);

        Integer id = stu.getId();

        Student stu2 = new Student()
                .setId(id)
                .setName("莺花")
                .setAge(20)
                .setEmail("yinghua@hlj.com")
                .setVersion(2);

        Assert.isTrue(studentService.updateById(stu2), "更新失败");
    }

    @Test
    public void testUpdateByIdSuccWithNoVersion() {
        Student stu = new Student()
                .setName("樱花")
                .setAge(18)
                .setEmail("yinghua@hlj.com")
                .setVersion(1);

        studentService.save(stu);

        Integer id = stu.getId();

        Student stu2 = new Student()
                .setId(id)
                .setName("莺花")
                .setAge(20)
                .setEmail("yinghua@hlj.com");

        Assert.isTrue(studentService.updateById(stu2), "应该更新成功，因为没有传入任何版本");

        Student updated = studentService.getById(id);
        Assert.isTrue(updated.getVersion() == 1, "版本没有变化");
        System.out.println(updated.toString());
    }


}
