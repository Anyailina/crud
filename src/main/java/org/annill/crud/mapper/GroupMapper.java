package org.annill.crud.mapper;

import org.annill.crud.dto.GroupDto;
import org.annill.crud.entity.Group;
import org.mapstruct.Mapper;

@Mapper
public interface GroupMapper {
    GroupDto toDto(Group group);

    Group toEntity(GroupDto groupDto);
}
