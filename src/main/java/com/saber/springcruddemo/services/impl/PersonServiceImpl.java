package com.saber.springcruddemo.services.impl;

import com.saber.springcruddemo.dto.PersonDto;
import com.saber.springcruddemo.dto.PersonRequestDto;
import com.saber.springcruddemo.mapper.PersonMapper;
import com.saber.springcruddemo.model.command.PersonCommand;
import com.saber.springcruddemo.model.query.Person;
import com.saber.springcruddemo.repositories.command.PersonCommandRepository;
import com.saber.springcruddemo.repositories.query.PersonQueryRepository;
import com.saber.springcruddemo.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonMapper personMapper;
    private final PersonCommandRepository personCommandRepository;
    private final PersonQueryRepository personQueryRepository;
    @Override
    @Transactional
    public PersonDto savePerson(PersonRequestDto personRequest) {
        checkRules(personRequest);
        PersonCommand personCommand = personMapper.requestDtoToCommand(personRequest);
        Integer id = personCommandRepository.save(personCommand);
        personCommand.setId(id);
        return personMapper.commandToDto(personCommand);
    }

    private void checkRules(PersonRequestDto personRequestDto){
        String nationalCode = personRequestDto.getNationalCode();
        Optional<Person> optionalPerson = personQueryRepository.findByNationalCode(nationalCode);
        if (optionalPerson.isPresent()){
            throw new RuntimeException("person already by nationalCode exist");
        }
    }

    public PersonDto getPersonById(Integer id){
        Optional<Person> optionalPerson = personQueryRepository.findById(id);
        if (optionalPerson.isEmpty()){
            throw new RuntimeException("person byId does not exist");
        }
        Person person = optionalPerson.get();
        return personMapper.modelToDto(person);
    }
}
