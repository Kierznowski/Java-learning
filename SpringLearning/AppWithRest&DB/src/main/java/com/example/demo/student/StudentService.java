package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(new Student(
                1L,
                "John",
                "john.kowalsky@gmail.com",
                24,
                LocalDate.of(1999, 12, 10) ));
    }
}
