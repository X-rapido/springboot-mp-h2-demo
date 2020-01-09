package com.helijia.quickstart.module.student.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.helijia.quickstart.module.student.entity.Student;
import com.helijia.quickstart.module.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hlj/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/list")
    public Object list() {
        List<Student> students = service.list(new QueryWrapper<>());
        return students;
    }
}
