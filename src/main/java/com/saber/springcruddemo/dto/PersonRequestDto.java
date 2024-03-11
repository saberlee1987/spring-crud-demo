package com.saber.springcruddemo.dto;

import lombok.Data;

@Data
public class PersonRequestDto {
    private String firstName;
    private String lastName;
    private String nationalCode;
    private Integer age;
    private String mobile;
    private String email;
}
