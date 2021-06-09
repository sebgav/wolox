@tag
Feature: wolox


  @tag1
  Scenario: Registro Logion
    Given consumo el servicio de registo
    When obtengo la respuesta
    Then valido el loguin

