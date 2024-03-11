package com.saber.springcruddemo.repositories.query;

import com.saber.springcruddemo.model.query.Person;

import java.util.Optional;

public interface PersonQueryRepository {
    Optional<Person> findById(Integer id);
    Optional<Person> findByNationalCode(String nationalCode);
}
