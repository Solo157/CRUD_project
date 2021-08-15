package com.vasyukovkirill.myproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

}
