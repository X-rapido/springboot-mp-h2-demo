package com.helijia.quickstart.module.student.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.helijia.quickstart.common.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 学生表
 *
 * @author 听风
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    /**
     * 主键ID
     */
    @TableId
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 枚举： 0：男， 1：女
     */
    private GenderEnum gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 添加日期
     */
    private Date createTime;

    /**
     * 乐观锁配置
     */
    @Version
    private Integer version;

    /**
     * 逻辑删除标识
     */
    @JsonIgnore
    @TableLogic
    private Integer isDelete;


}