package com.example.course.controller;

import com.example.course.dto.request.StudentRequest;
import com.example.course.dto.response.CourseResponse;
import com.example.course.dto.response.StudentResponse;
import com.example.course.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody StudentRequest studentRequest) {
        service.createStudent(studentRequest);
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @PatchMapping("/register")
    public void registerToCourse(@RequestParam Long studentId,
                                 @RequestParam Long courseId) {
        service.registerToCourse(studentId, courseId);
    }

    @GetMapping("/{id}/courses")
    public List<CourseResponse> registeredCourses(@PathVariable Long id) {
        return service.registeredCourses(id);
    }

    @PutMapping("/{id}")
    public void updateStudentName(@PathVariable Long id, @RequestParam String name) {
        service.updateStudentName(id, name);
    }

    @DeleteMapping("/deactivate/{id}")
    public void deactivate(@PathVariable Long id) {
        service.deactivate(id);
    }

    @DeleteMapping("/deactivate/{id}")
    public void activate(@PathVariable Long id){service.activate(id);}
}