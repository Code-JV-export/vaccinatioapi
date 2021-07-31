package com.projeto.vaccinationapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private long id;

    @NotEmpty
    private String street;

    @NotEmpty
    private String number;

    @NotEmpty
    private String city;

    @NotEmpty
    private String state;
}
