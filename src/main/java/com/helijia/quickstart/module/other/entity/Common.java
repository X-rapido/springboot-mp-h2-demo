package com.helijia.quickstart.module.other.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Common {

    private Long id;

    private String name;

    @TableLogic
    private Integer deleted;
}