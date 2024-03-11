package com.saber.springcruddemo.mapper;

import com.saber.springcruddemo.dto.PersonDto;
import com.saber.springcruddemo.dto.PersonRequestDto;
import com.saber.springcruddemo.model.command.PersonCommand;
import com.saber.springcruddemo.model.query.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonCommand requestDtoToCommand(PersonRequestDto personRequest);

    PersonDto modelToDto(Person person);
    PersonDto commandToDto(PersonCommand personCommand);

    PersonMapper getInstance = Mappers.getMapper(PersonMapper.class);

}
