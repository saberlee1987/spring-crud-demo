package com.saber.springcruddemo.repositories.query.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.saber.springcruddemo.model.query.Person;
import com.saber.springcruddemo.model.query.QPerson;
import com.saber.springcruddemo.repositories.query.PersonQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class QDSLPersonQueryRepository implements PersonQueryRepository {
    @Value("${spring.datasource.hikari.schema}")
    private String schema;

    private final QPerson qPerson = new QPerson("person");

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Person> findById(Integer id) {
        return Optional.ofNullable(
                jpaQueryFactory.selectFrom(qPerson)
                        .where(qPerson.id.eq(id))
                        .fetchOne()
        );
    }

    @Override
    public Optional<Person> findByNationalCode(String nationalCode) {
        return Optional.ofNullable(
                jpaQueryFactory.selectFrom(qPerson)
                        .where(qPerson.nationalCode.eq(nationalCode))
                        .fetchOne()
        );
    }
}
