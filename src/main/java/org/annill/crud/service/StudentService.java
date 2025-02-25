package org.annill.crud.service;

import org.annill.crud.dto.StudentDto;

import java.util.Optional;

public interface StudentService {
    Optional<StudentDto> getByName(String name);

    void addStudent(StudentDto studentDto);

    void deleteById(Long id);
}
