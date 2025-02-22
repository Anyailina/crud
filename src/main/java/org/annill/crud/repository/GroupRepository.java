package org.annill.crud.repository;

import org.annill.crud.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository  extends JpaRepository<Group,Long> {
    Optional<Group> findByNumber(String number);
}
