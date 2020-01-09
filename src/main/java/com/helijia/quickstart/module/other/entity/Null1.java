package com.helijia.quickstart.module.other.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Null1 {

    private Long id;
    private String name;

    @TableLogic(delval = "null", value = "1")
    private Integer deleted;
}