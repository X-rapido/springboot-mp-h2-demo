package com.helijia.quickstart.module.other.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class Null2 {

    private Long id;
    private String name;

    @TableLogic(delval = "now()", value = "null")
    private LocalDateTime delTime;

}