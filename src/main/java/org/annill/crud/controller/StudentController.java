package org.annill.crud.controller;

import lombok.RequiredArgsConstructor;
import org.annill.crud.dto.StudentDto;
import org.annill.crud.service.impl.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/students")
@RequiredArgsConstructor
@RestController
public class StudentController {
    private final StudentServiceImpl studentServiceImpl;


    @GetMapping
    public ResponseEntity<StudentDto> getByName(@RequestParam String name) {
        return ResponseEntity.of(studentServiceImpl.getByName(name));
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        studentServiceImpl.deleteById(id);
    }

    @PostMapping
    public void addStudent(@RequestBody StudentDto studentDto) {
        studentServiceImpl.addStudent(studentDto);
    }
}
