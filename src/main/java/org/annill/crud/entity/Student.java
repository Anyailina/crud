package org.annill.crud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "students")
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "date_of_enrollment" )
    private Date dateOfEnrollment;
    @CreationTimestamp
    @Column(name = "create_at")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

}
