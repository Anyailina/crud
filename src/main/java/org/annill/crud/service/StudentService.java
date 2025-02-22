package org.annill.crud.service;

import lombok.AllArgsConstructor;
import org.annill.crud.converter.StudentConverter;
import org.annill.crud.dto.StudentDto;
import org.annill.crud.entity.Student;
import org.annill.crud.exception.EntityExistsException;
import org.annill.crud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentService {
    private StudentRepository studentRepository;
    private StudentConverter studentConverter;

    public Optional<StudentDto> getByName(String name) {
        return studentRepository.findByName(name)
                .map(studentConverter::convert);
    }

    public void addStudent(StudentDto studentDto) {
        Student newStudent = studentConverter.convert(studentDto);
        if (getByName(newStudent.getName()).isEmpty())
            studentRepository.save(newStudent);
        else
            throw new EntityExistsException();

    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

}
