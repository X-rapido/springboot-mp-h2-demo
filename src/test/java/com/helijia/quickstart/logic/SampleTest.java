package com.helijia.quickstart.logic;

import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class SampleTest {

    @Resource
    private com.helijia.quickstart.module.other.entity.mapper.Null1Mapper null1Mapper;
    @Resource
    private com.helijia.quickstart.module.other.entity.mapper.Null2Mapper null2Mapper;


}
