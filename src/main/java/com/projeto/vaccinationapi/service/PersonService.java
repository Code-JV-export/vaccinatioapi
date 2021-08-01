package com.projeto.vaccinationapi.service;

import com.projeto.vaccinationapi.dto.MessageResponseDTO;
import com.projeto.vaccinationapi.dto.request.PersonDTO;
import com.projeto.vaccinationapi.entity.Person;
import com.projeto.vaccinationapi.mapper.PersonMapper;
import com.projeto.vaccinationapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
// serve para informa para o spring que essa classe ficará responsavel por colocar a regra de negocio da aplicação
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) { // o parametro é do tipo pessoa, pois já ira criar uma instacia do tipo person
        Person personToSave = personMapper.toModel(personDTO);

        Person savePerson = personRepository.save(personToSave);// salva os dados passado através do Post
        return MessageResponseDTO
                .builder()
                .message("Person registered for vaccination: " + savePerson.getFirstName() +
                        " in day: " + savePerson.getScheduledDate())
                .build();
    }

    public List<PersonDTO> listAll() { // listar todas as pessoas
        List<Person> allPeople = personRepository.findAll(); // chama através do repository todas as pessoas
        return allPeople.stream() // utilizando o serviços do stream
                .map(personMapper::toDTO) // pede para o personMapper transformar cada Person em PersonDTO
                .collect(Collectors.toList()); // passando todos os dados para uma list
    }
}
