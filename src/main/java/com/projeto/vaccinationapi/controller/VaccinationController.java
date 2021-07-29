package com.projeto.vaccinationapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // informando que é um controlador que será acessada por uma requisição rest
@RequestMapping("/api/v1/register") // informa qual é o caminho principal de entrada da API
public class VaccinationController {

    @GetMapping // mapeando uma requisição http do tipo Get
    public String getBook() {
        return "API test!";
    }
}
