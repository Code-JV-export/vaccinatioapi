package com.projeto.vaccinationapi.repository;

import com.projeto.vaccinationapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> { // o JpaRepository é uma interface do spring que gerencia toda a plataforma de conexão com o banco de dados
}
