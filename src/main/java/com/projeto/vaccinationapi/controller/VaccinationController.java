package com.projeto.vaccinationapi.controller;

import com.projeto.vaccinationapi.dto.MessageResponseDTO;
import com.projeto.vaccinationapi.dto.request.PersonDTO;
import com.projeto.vaccinationapi.exception.PersonNotFoundException;
import com.projeto.vaccinationapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController // informando que é um controlador que será acessada por uma requisição rest
@RequestMapping("/api/v1/register") // informa qual é o caminho principal de entrada da API
@AllArgsConstructor(onConstructor = @__(@Autowired)) // cria um construtor com todos os parametros
public class VaccinationController { // essa classe serve só para ser uma porta de entrada para a API

    private PersonService personService;

    @PostMapping // mapeando envio de dados atraves de um Post
    @ResponseStatus(HttpStatus.CREATED)
    // o @RequestBody garante que no corpo do post vem um Json com os dados que pertecem a classe pessoa
    // o @Valid manda o validation verificar cada um dos atributos
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) { // o parametro é do tipo pessoa, pois já ira criar uma instacia do tipo person
        return personService.createPerson(personDTO);
    }

    @GetMapping // mapeando o get, onde ira retornar uma lista com todas as pessoas salvas
    public List<PersonDTO> listAll() {
        return personService.listAll(); // chamando o método na classe PersonService
    }

    @GetMapping("/{id}") // mapeando o get, mas esperando através do requerimento o id no endereço
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException { // indica que o parametro está na requisição
        return personService.findById(id); // chamando o método na classe PersonService
    }

    @DeleteMapping("/{id}") // mapeando a solicitação de delete
    @ResponseStatus(HttpStatus.NO_CONTENT) // ira responder com o codigo Http para não existe conteudo
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }
}
