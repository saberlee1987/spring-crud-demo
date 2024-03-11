package com.saber.springcruddemo.model.command;

import lombok.Data;

@Data
public class PersonCommand {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String mobile;
    private String email;
    private String nationalCode;
}
