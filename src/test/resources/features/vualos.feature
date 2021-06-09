@tag
Feature: vuelos


  @tag1
  Scenario Outline: consultar un vuelo
    Given que ingreso a la pagina Avianca
    When consulto un vuelo a origen "<origen>" destino "<destino>"
    Then valido los precios
    Examples:
      | origen  | destino |
      |Medellín |Bogota   |


