package com.projeto.vaccinationapi.mapper;

import com.projeto.vaccinationapi.dto.request.PersonDTO;
import com.projeto.vaccinationapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper // para avisar ao mapstruct que está é uma classe que ele vai processar
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    // O @Mapping manda o mapstruct converter o formato String para LocalDate
    @Mapping(target = "birthDate, scheduledDate", source = "birthDate, scheduledDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
