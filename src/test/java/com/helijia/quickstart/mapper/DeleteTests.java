package com.helijia.quickstart.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.helijia.quickstart.module.student.entity.Student;
import com.helijia.quickstart.module.student.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class DeleteTests {

    @Autowired
    protected StudentMapper mapper;

    /**
     * 根据 entity 条件，删除记录
     * <p>
     * int delete(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
     */
    @Test
    public void delete() {
        Assert.isTrue(mapper.delete(new QueryWrapper<Student>().eq("name", "听风")) > 0, "删除失败");
    }

    /**
     * 根据 ID 删除
     * <p>
     * int deleteById(Serializable id);
     */
    @Test
    public void deleteById() {
        Assert.isTrue(mapper.deleteById(1) > 0, "删除失败");
    }

    /**
     * 删除（根据ID 批量删除）
     * <p>
     * int deleteBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
     */
    @Test
    public void deleteBatchIds() {
        Assert.isTrue(mapper.deleteBatchIds(Arrays.asList(1, 2, 3, 4)) > 0, "删除失败");
    }

    /**
     * 根据 columnMap 条件，删除记录
     * <p>
     * int deleteByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
     */
    @Test
    public void deleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "TingFeng");
        map.put("age", "25");

        Assert.isTrue(mapper.deleteByMap(map) > 0, "删除失败");
    }
}
