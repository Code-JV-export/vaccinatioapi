<h2>Desenvolvendo um sistema de gerenciamento de cadastro e, agendamento de pessoas em API REST com Spring Boot</h2>

Esse projeto foi desenvolvido pensando em cirar uma API que poderia ser usado na organização de uma "fila", para a vacinação do COVID-19.

Tal projeto, teve como base as aulas da plataforma Digital Innovation One (DIO).

Etapas até agora desenvolvida nesta API: 

* Cadastro de uma pessoa, passando o seu nome, CPF, data de nascimento, telefone, e o seu endereço.
* Agendamento do dia e local para a vacinação
* Atualização tanto dos dados da pessoa, como do dia da vacinação.
* Leitura de todas as pessoas cadastradas, ou alguma em especial.
* Além da remoção de uma pessoa do sistema.

Para executar este projeto, basta fazer o download do mesmo e, através do terminal, digite o seguinte comando, na raiz do sistema:

```shell script
mvn spring-boot:run
```

Após executar o comando acima basta apenas abrir o seguinte endereço e visualizar a execução deste projeto:

```
http://localhost:8080/api/v1/register
```

Para melhor experiência do resultado deste projeto, indicamos o uso do Postman, que pode ser obtido clicando [aqui](https://www.postman.com/)