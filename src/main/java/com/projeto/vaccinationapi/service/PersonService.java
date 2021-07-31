package com.projeto.vaccinationapi.service;

import com.projeto.vaccinationapi.dto.MessageResponseDTO;
import com.projeto.vaccinationapi.entity.Person;
import com.projeto.vaccinationapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service // serve para informa para o spring que essa classe ficará responsavel por colocar a regra de negocio da aplicação
public class PersonService {

    private PersonRepository personRepository;

    @Autowired // injeta uma gestão do tipo repository
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person) { // o parametro é do tipo pessoa, pois já ira criar uma instacia do tipo person
        Person savePerson = personRepository.save(person);// salva os dados passado através do Post
        return MessageResponseDTO
                .builder()
                .message("Person registered for vaccination: " + savePerson.getFirstName() +
                        " in day: " + savePerson.getScheduledDate())
                .build();
    }
}
