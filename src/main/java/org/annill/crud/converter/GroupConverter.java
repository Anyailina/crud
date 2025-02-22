package org.annill.crud.converter;

import org.annill.crud.dto.GroupDto;
import org.annill.crud.entity.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupConverter {

    public GroupDto convert(Group group) {
        return new GroupDto()
                .setId(group.getId())
                .setNumber(group.getNumber());
    }

    public Group convert(GroupDto groupDto) {
        return new Group()
                .setId(groupDto.getId())
                .setNumber(groupDto.getNumber());
    }
}
