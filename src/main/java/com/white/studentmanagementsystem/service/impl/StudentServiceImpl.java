package com.white.studentmanagementsystem.service.impl;

import com.white.studentmanagementsystem.dto.StudentDto;
import com.white.studentmanagementsystem.entity.Student;
import com.white.studentmanagementsystem.mapper.StudentMapper;
import com.white.studentmanagementsystem.repository.StudentRepository;
import com.white.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream()
                .map(StudentMapper::mapToStudentDto)
                .toList();
        return studentDtos;
    }

    @Override
    public void createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);
    }
}
