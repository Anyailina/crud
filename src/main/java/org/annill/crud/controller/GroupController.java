package org.annill.crud.controller;

import lombok.RequiredArgsConstructor;
import org.annill.crud.dto.GroupDto;
import org.annill.crud.service.impl.GroupServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupServiceImpl groupService;

    @GetMapping
    public ResponseEntity<GroupDto> getByName(@RequestParam String name) {
        return ResponseEntity.of(groupService.getByNumber(name));
    }

    @PostMapping
    public  void addStudent(@RequestBody GroupDto groupDto){
        groupService.addStudent(groupDto);
    }
}
