package org.annill.crud;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.annill.crud.controller.StudentController;
import org.annill.crud.dto.GroupDto;
import org.annill.crud.dto.StudentDto;
import org.annill.crud.service.GroupService;
import org.annill.crud.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import org.testcontainers.shaded.com.github.dockerjava.core.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class StudentControllerTest extends AbstractTestContainer {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addStudent() throws Exception {
        GroupDto groupDto = new GroupDto(1L, "iero");
        StudentDto studentDto = new StudentDto().setId(1L).setName("fjksl").setGroupDto(groupDto);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(studentDto);


        MvcResult mvcResult = mockMvc.perform(post("/students")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON.getMediaType()))
                .andExpect(status().isOk())
                .andReturn();


        byte[] newStudentDto = mvcResult.getResponse().getContentAsByteArray();

        StudentDto returnedStudentDto = objectMapper.readValue(newStudentDto, StudentDto.class);

        Assertions.assertEquals(studentDto, returnedStudentDto);
    }
}