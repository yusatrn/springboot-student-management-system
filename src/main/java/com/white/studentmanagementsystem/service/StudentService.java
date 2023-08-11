package com.white.studentmanagementsystem.service;

import com.white.studentmanagementsystem.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    void createStudent(StudentDto student);
}
