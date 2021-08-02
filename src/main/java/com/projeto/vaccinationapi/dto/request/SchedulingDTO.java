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
public class SchedulingDTO {

    private Long id;

    @NotEmpty
    private String scheduledDate;

    @NotEmpty
    private String place;
}
