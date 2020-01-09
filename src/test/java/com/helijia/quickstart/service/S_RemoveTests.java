package com.helijia.quickstart.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.helijia.quickstart.module.student.entity.Student;
import com.helijia.quickstart.module.student.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class S_RemoveTests {

    @Autowired
    protected StudentService service;

    /**
     * 根据 ID 删除
     * <p>
     * boolean removeById(Serializable id);
     */
    @Test
    public void removeById() {
        Assert.isTrue(service.removeById(6), "删除失败");
    }

    /**
     * 删除（根据ID 批量删除）
     * <p>
     * boolean removeByIds(Collection<? extends Serializable> idList);
     */
    @Test
    public void removeByIds() {
        Assert.isTrue(service.removeByIds(Arrays.asList(1, 2, 3, 4)), "删除失败");
    }

    /**
     * 根据 entity 条件，删除记录
     * <p>
     * boolean remove(Wrapper<T> queryWrapper);
     */
    @Test
    public void remove() {
        Assert.isTrue(service.remove(new QueryWrapper<Student>().eq("name", "听风")), "删除失败");
    }

    /**
     * 根据 columnMap 条件，删除记录
     * <p>
     * boolean removeByMap(Map<String, Object> columnMap);
     */
    @Test
    public void removeByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "TingFeng");
        map.put("age", "25");

        Assert.isTrue(service.removeByMap(map), "删除失败");
    }


}
