package com.vasyukovkirill.myproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotebooksDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;
    private String record;

}
