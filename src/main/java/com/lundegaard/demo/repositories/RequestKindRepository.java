package com.lundegaard.demo.repositories;

import com.lundegaard.demo.entities.RequestKind;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestKindRepository extends CrudRepository<RequestKind, Long> {

}