package com.saber.springcruddemo;

import com.saber.springcruddemo.dto.PersonDto;
import com.saber.springcruddemo.dto.PersonRequestDto;
import com.saber.springcruddemo.services.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringCrudDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringCrudDemoApplication.class, args);

        try {
            PersonRequestDto personRequestDto = new PersonRequestDto();
            personRequestDto.setFirstName("saber");
            personRequestDto.setLastName("azizi");
            personRequestDto.setAge(36);
            personRequestDto.setEmail("saberazizi66@yahoo.com");
            personRequestDto.setMobile("09365627895");
            personRequestDto.setNationalCode("0079028748");
            PersonService personService = context.getBean(PersonService.class);
            PersonDto personDto = personService.savePerson(personRequestDto);
            System.out.println(personDto);
            PersonDto person = personService.getPersonById(personDto.getId());
            System.out.println(person);
        } catch (Exception ex) {
            System.out.println("error ==> " + ex.getMessage());
        }
    }

}
