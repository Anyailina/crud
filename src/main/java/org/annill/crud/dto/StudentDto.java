package org.annill.crud.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Date;

@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private Date dateOfEnrollment;
    private GroupDto groupDto;
}
