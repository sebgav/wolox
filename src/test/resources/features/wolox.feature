@tag
Feature: wolox


  @tag1
  Scenario: Crear Usuario
    Given consumo el servicio de registo
    Then valido la creacion de usuario

  @tag2
  Scenario: crear usuario validando correo
    Given consumo el servicio de registo con dominio Diferente a Wolox
    Then valido respuesta con correo diferente

  @tag3
  Scenario: Crear usuario validando nombres
    Given consumo el servicio de registo con dominio nombres con numeros
    Then valido respuesta con nombre con numeros

  @tag4
  Scenario: loguin usuario validando nombres
    Given consumo el servicio de loguin
    Then valido la respuesta del loguin

  @tag5
  Scenario: loguin usuario validando nombres
    Given consumo listado usuario
    Then valido la respuesta del listado