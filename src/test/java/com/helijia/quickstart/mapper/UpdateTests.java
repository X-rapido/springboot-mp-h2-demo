package com.helijia.quickstart.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.helijia.quickstart.module.student.entity.Student;
import com.helijia.quickstart.module.student.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class UpdateTests {

    @Autowired
    protected StudentMapper mapper;

    /**
     * 根据 ID 修改
     * <p>
     * int updateById(@Param(Constants.ENTITY) T entity);
     */
    @Test
    public void updateById() {
        Assert.isTrue(mapper.updateById(new Student().setId(1).setEmail("abc@sina.com")) > 0, "更新失败");
    }

    /**
     * 根据 whereEntity 条件，更新记录
     * <p>
     * int update(@Param(Constants.ENTITY) T entity, @Param(Constants.WRAPPER) Wrapper<T> updateWrapper);
     */
    @Test
    public void update() {
        Assert.isTrue(mapper.update(new Student().setName("听风").setAge(20),
                new UpdateWrapper<Student>().eq("id", 3)) > 0, "更新失败");
    }

}
