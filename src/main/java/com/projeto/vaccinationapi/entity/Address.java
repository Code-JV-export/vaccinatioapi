package com.projeto.vaccinationapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // informando ao JPA que essa classe é uma entidade e que deve estár no banco de dados
@Data // adiciona getters e setters dos atributos da classe
@Builder // da um padrão de projeto para fazer a construção de objetos muito simples
@AllArgsConstructor // faz um construtor recebendo dados para todos os atributos
@NoArgsConstructor // faz um construtor sem receber parametros
public class Address {

    @Id // para ter uma classe "Entity" deve se ter um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // define qual é a estrategia de geração deste ID. O escolhido foi o que incrementa a cada novo dado
    private Long id;

    @Column(nullable = false) // obriga a este dado ser obrigatorio
    private String street;

    @Column(nullable = false) // obriga a este dado ser obrigatorio
    private String number;

    @Column(nullable = false) // obriga a este dado ser obrigatorio
    private String city;

    @Column(nullable = false) // obriga a este dado ser obrigatorio
    private String state;

}
