package com.saber.springcruddemo.services;

import com.saber.springcruddemo.dto.PersonDto;
import com.saber.springcruddemo.dto.PersonRequestDto;

public interface PersonService {

    PersonDto savePerson(PersonRequestDto personRequestDto);
     PersonDto getPersonById(Integer id);
}
