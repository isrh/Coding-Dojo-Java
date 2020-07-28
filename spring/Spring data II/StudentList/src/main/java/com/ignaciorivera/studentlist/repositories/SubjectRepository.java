package com.ignaciorivera.studentlist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ignaciorivera.studentlist.models.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long>{

	List<Subject> findAll();
}
