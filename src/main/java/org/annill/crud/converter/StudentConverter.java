package org.annill.crud.converter;

import lombok.AllArgsConstructor;
import org.annill.crud.dto.StudentDto;
import org.annill.crud.entity.Student;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StudentConverter {
    private GroupConverter groupConverter;

    public StudentDto convert(Student student){
        return new StudentDto()
                .setId(student.getId())
                .setName(student.getName())
                .setDateOfEnrollment(student.getDateOfEnrollment())
                .setGroupDto(groupConverter.convert(student.getGroup()));
    }

    public Student convert(StudentDto studentDto){
        return new Student()
                .setId(studentDto.getId())
                .setName(studentDto.getName())
                .setDateOfEnrollment(studentDto.getDateOfEnrollment())
                .setGroup(groupConverter.convert(studentDto.getGroupDto()));
    }
}
