package org.annill.crud.service.impl;

import lombok.RequiredArgsConstructor;
import org.annill.crud.dto.GroupDto;
import org.annill.crud.entity.Group;
import org.annill.crud.exception.EntityExistsException;
import org.annill.crud.mapper.GroupMapper;
import org.annill.crud.repository.GroupRepository;
import org.annill.crud.service.GroupService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;


    public Optional<GroupDto> getById(Long id) {
        return groupRepository.findById(id)
                .map(groupMapper::toDto);
    }

    public Optional<GroupDto> getByNumber(String name) {
        return groupRepository.findByNumber(name)
                .map(groupMapper::toDto);
    }

    public void addStudent(GroupDto groupDto) {
        Group newGroup = groupMapper.toEntity(groupDto);
        if (getByNumber(newGroup.getNumber()).isEmpty())
            groupRepository.save(newGroup);
        else
            throw new EntityExistsException();

    }

}
