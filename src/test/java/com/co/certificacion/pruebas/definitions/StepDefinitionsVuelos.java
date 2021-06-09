package com.co.certificacion.pruebas.definitions;


import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import data.Templates;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;


import java.util.Locale;

import static net.serenitybdd.rest.SerenityRest.given;

public class StepDefinitionsVuelos {

/*
    @Steps
    VuelosStep vuelosStep;
    private String precioTalla;

    @Given("^que ingreso a la pagina Avianca$")
    public void queIngresoALaPaginaAvianca() {
vuelosStep.abrirAvianca();
    }


    @When("^consulto un vuelo a origen \"([^\"]*)\" destino \"([^\"]*)\"$")
    public void consultoUnVueloAOrigenDestino(String vueloOrigen, String vueloDestino) {
vuelosStep.ingresarVuelos(vueloOrigen,vueloDestino);
vuelosStep.ingresarSoloIda();
vuelosStep.ingresarFecha();
vuelosStep.seleccionarSegundoVuelo();
precioTalla=vuelosStep.seleccionarTallaXS();
    }

    @Then("^valido los precios$")
    public void validoLosPrecios() {
    vuelosStep.validarPreciosTallas(precioTalla);
    }

 */
    Templates templates=new Templates();
    Faker faker = new Faker(new Locale("es"));


    @Given("^consumo el servicio de registo$")
    public void consumoElServicioDeRegisto() {
        String nombre = faker.name().firstName();
        String apellido=faker.name().lastName();
        String pasword = faker.internet().password();
        String correo=nombre+"@wolox.com.ar";

        RestAssured.baseURI = "https://nodejs-qa-training.herokuapp.com/";
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(templates.createLogion(correo,pasword,nombre,apellido))
                .when()
                .put("/users")
                .then()
                .extract().response();


    }
}
