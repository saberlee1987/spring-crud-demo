package com.saber.springcruddemo.repositories.command;

import com.saber.springcruddemo.model.command.PersonCommand;

public interface PersonCommandRepository {

    Integer save(PersonCommand personCommand);
    void update(PersonCommand personCommand);
    void deletePersonById(Long id);
}