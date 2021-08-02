package com.projeto.vaccinationapi.service;

import com.projeto.vaccinationapi.dto.MessageResponseDTO;
import com.projeto.vaccinationapi.dto.request.PersonDTO;
import com.projeto.vaccinationapi.entity.Person;
import com.projeto.vaccinationapi.exception.PersonNotFoundException;
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
        return createMessageResponse(savePerson, "Person registered for vaccination: ", " in day: ");
    }

    public List<PersonDTO> listAll() { // listar todas as pessoas
        List<Person> allPeople = personRepository.findAll(); // chama através do repository todas as pessoas
        return allPeople.stream() // utilizando o serviços do stream
                .map(personMapper::toDTO) // pede para o personMapper transformar cada Person em PersonDTO
                .collect(Collectors.toList()); // passando todos os dados para uma list
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person); // pedindo pro PersonMapper converter para um PersonDTO
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id); // manda o metodo desta classe ver se existe o id
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate);// salva os dados passado através do Post
        return createMessageResponse(updatedPerson, "Update person and date of vaccination: ", " for the day: ");
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id)); // o Optional tem uma classe que faz uma comparação e se não for valida ela faz um up de uma exceção
    }

    private MessageResponseDTO createMessageResponse(Person savePerson, String message, String message2) {
        return MessageResponseDTO
                .builder()
                .message(message + savePerson.getFirstName() +
                        message2 + savePerson.getScheduling().getScheduledDate())
                .build();
    }
}
