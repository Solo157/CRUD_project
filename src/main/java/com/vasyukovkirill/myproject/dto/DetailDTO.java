package com.vasyukovkirill.myproject.dto;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;
    private String city;
    private String phoneNumber;
    private String email;

}
