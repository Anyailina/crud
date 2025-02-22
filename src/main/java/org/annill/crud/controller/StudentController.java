package org.annill.crud.controller;

import lombok.AllArgsConstructor;
import org.annill.crud.dto.StudentDto;
import org.annill.crud.exception.EntityNotFoundException;
import org.annill.crud.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;


    @GetMapping
    public StudentDto getByName(@RequestParam String name) {
        Optional<StudentDto> optionalStudent = studentService.getByName(name);
        if (optionalStudent.isPresent())
            return optionalStudent.get();
        else
            throw new EntityNotFoundException();
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        studentService.deleteById(id);
    }

    @PostMapping
    public  void addStudent(@RequestBody StudentDto studentDto){
        studentService.addStudent(studentDto);
    }
}
