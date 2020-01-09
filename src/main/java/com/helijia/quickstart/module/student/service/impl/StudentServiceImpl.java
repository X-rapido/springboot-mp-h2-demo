package com.helijia.quickstart.module.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.helijia.quickstart.module.student.entity.Student;
import com.helijia.quickstart.module.student.mapper.StudentMapper;
import com.helijia.quickstart.module.student.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
