package com.lundegaard.demo.repositories;

import com.lundegaard.demo.entities.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long> {
}