package com.saber.springcruddemo.repositories.command.impl;

import com.querydsl.sql.SQLQueryFactory;
import com.saber.springcruddemo.model.command.PersonCommand;
import com.saber.springcruddemo.model.command.QPersons;
import com.saber.springcruddemo.repositories.command.PersonCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QDSLPersonCommandRepository implements PersonCommandRepository {

    @Value("${spring.datasource.hikari.schema}")
    private String schema;

    private final SQLQueryFactory sqlQueryFactory;
    private final QPersons qPersons = new QPersons("qPerson",schema);
//
//    private final Map<Long,PersonCommand> personDatabase = new ConcurrentHashMap<>();
//    private volatile Long id = 0L;
    @Override
    public Integer save(PersonCommand personCommand) {
        return sqlQueryFactory.insert(qPersons)
                .populate(personCommand)
                .executeWithKey(qPersons.id);
    }

    @Override
    public void update(PersonCommand personCommand) {

    }

//    private synchronized  Long getNextId(){
//        return ++id;
//    }

    @Override
    public void deletePersonById(Long id) {

    }
}
