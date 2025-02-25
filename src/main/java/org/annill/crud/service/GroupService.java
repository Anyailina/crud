package org.annill.crud.service;

import org.annill.crud.dto.GroupDto;

import java.util.Optional;

public interface GroupService {
    Optional<GroupDto> getById(Long id);

    Optional<GroupDto> getByNumber(String name);

    void addStudent(GroupDto groupDto);
}
