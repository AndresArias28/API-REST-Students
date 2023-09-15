package com.santox.crudDEmo.Infrastructure;

import com.santox.crudDEmo.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
