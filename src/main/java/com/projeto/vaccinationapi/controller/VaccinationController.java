package com.projeto.vaccinationapi.controller;

import com.projeto.vaccinationapi.dto.MessageResponseDTO;
import com.projeto.vaccinationapi.entity.Person;
import com.projeto.vaccinationapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController // informando que é um controlador que será acessada por uma requisição rest
@RequestMapping("/api/v1/register") // informa qual é o caminho principal de entrada da API
public class VaccinationController { // essa classe serve só para ser uma porta de entrada para a API

    private PersonService personService;

    @Autowired
    public VaccinationController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping // mapeando envio de dados atraves de um Post
    @ResponseStatus(HttpStatus.CREATED)
    // o @RequestBody garante que no corpo do post vem um Json com os dados que pertecem a classe pessoa
    public MessageResponseDTO createPerson(@RequestBody Person person) { // o parametro é do tipo pessoa, pois já ira criar uma instacia do tipo person
        return personService.createPerson(person);
    }
}
