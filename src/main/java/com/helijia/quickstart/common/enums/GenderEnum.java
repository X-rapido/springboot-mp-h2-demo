package com.helijia.quickstart.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 性别枚举
 */
@Getter
public enum GenderEnum {

    MALE(0, "男士"),
    FEMALE(1, "女士");

    @EnumValue
    private final int code;
    private final String descp;

    GenderEnum(int code, String descp) {
        this.code = code;
        this.descp = descp;
    }

}
