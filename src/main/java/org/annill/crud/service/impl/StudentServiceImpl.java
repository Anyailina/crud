package org.annill.crud.service.impl;

import lombok.RequiredArgsConstructor;
import org.annill.crud.dto.StudentDto;
import org.annill.crud.entity.Student;
import org.annill.crud.exception.EntityExistsException;
import org.annill.crud.mapper.StudentMapper;
import org.annill.crud.repository.StudentRepository;
import org.annill.crud.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public Optional<StudentDto> getByName(String name) {
        return studentRepository.findByName(name)
                .map(studentMapper::toDto);
    }

    public void addStudent(StudentDto studentDto) {
        Student newStudent = studentMapper.toEntity(studentDto);
        if (getByName(newStudent.getName()).isEmpty())
            studentRepository.save(newStudent);
        else
            throw new EntityExistsException();

    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
