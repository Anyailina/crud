package org.annill.crud.controller;

import lombok.AllArgsConstructor;
import org.annill.crud.dto.GroupDto;
import org.annill.crud.exception.EntityNotFoundException;
import org.annill.crud.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@AllArgsConstructor
@RestController
@RequestMapping("/group")
public class GroupController {
    private GroupService groupService;

    @GetMapping
    public GroupDto getByName(@RequestParam String name) {
        Optional<GroupDto> optionalGroupDto = groupService.getByNumber(name);
        if (optionalGroupDto.isPresent())
            return optionalGroupDto.get();
        else
            throw new EntityNotFoundException();
    }

    @PostMapping
    public  void addStudent(@RequestBody GroupDto groupDto){
        groupService.addStudent(groupDto);
    }
}
