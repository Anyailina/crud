package org.annill.crud.mapper;

import org.annill.crud.dto.GroupDto;
import org.annill.crud.dto.StudentDto;
import org.annill.crud.entity.Group;
import org.annill.crud.entity.Student;
import org.mapstruct.Mapper;

@Mapper(uses = GroupMapper.class)
public interface StudentMapper {
    StudentDto toDto(Student student);

    Student toEntity(StudentDto studentDto);
}
