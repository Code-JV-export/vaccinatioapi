package com.projeto.vaccinationapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity // informando ao JPA que essa classe é uma entidade e que deve estár no banco de dados
@Data // adiciona getters e setters dos atributos da classe
@Builder // da um padrão de projeto para fazer a construção de objetos muito simples
@AllArgsConstructor // faz um construtor recebendo dados para todos os atributos
@NoArgsConstructor // faz um construtor sem receber parametros
public class Person {

    @Id // para ter uma classe "Entity" deve se ter um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // define qual é a estrategia de geração deste ID. O escolhido foi o que incrementa a cada novo dado
    private long id;

    @Column(nullable = false) // obriga a este dado ser obrigatorio
    private String firstName;

    @Column(nullable = false) // obriga a este dado ser obrigatorio
    private String lastName;

    @Column(nullable = false, unique = true) // obriga a este dado ser obrigatorio. // o unique só deixa cadastra dados unicos, não pode se repetir
    private String cpf;

    private LocalDate birthDate;

    private LocalDate scheduledDate;

    @OneToOne(fetch = FetchType.LAZY, // o LAZY é para deixar a consulta mais rapida
    cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}) // o cascade permite adicionar o telefone já na criação da pessoa, como se um fosse o pai do outro
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, // o LAZY é para deixar a consulta mais rapida
                cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}) // o cascade permite adicionar o telefone já na criação da pessoa, como se um fosse o pai do outro
    private List<Phone> phones;
}
