package org.annill.crud.service;

import lombok.AllArgsConstructor;
import org.annill.crud.converter.GroupConverter;
import org.annill.crud.dto.GroupDto;
import org.annill.crud.dto.StudentDto;
import org.annill.crud.entity.Group;
import org.annill.crud.entity.Student;
import org.annill.crud.exception.EntityExistsException;
import org.annill.crud.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class GroupService {
    private GroupRepository groupRepository;
    private GroupConverter groupConverter;


    public Optional<GroupDto> getById(Long id) {
        return groupRepository.findById(id)
                .map(groupConverter::convert);
    }

    public Optional<GroupDto> getByNumber(String name) {
        return groupRepository.findByNumber(name)
                .map(groupConverter::convert);
    }

    public void addStudent(GroupDto groupDto) {
        Group newGroup = groupConverter.convert(groupDto);
        if (getByNumber(newGroup.getNumber()).isEmpty())
            groupRepository.save(newGroup);
        else
            throw new EntityExistsException();

    }

}
