package com.co.certificacion.pruebas.definitions;


import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import data.Templates;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.slf4j.Logger;


import java.text.Normalizer;
import java.util.Locale;

import static jxl.biff.BaseCellFeatures.logger;
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
    private Response response;
    private String apellido;
    private String pasword;
    private String correo;
    private JSONObject jsonObject;


    @Given("^consumo el servicio de registo$")
    public void consumoElServicioDeRegisto() {
        String nombre = faker.name().firstName();
         apellido=faker.name().lastName();
        nombre=Normalizer.normalize(nombre, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
         pasword = faker.internet().password();
         correo=nombre+"@wolox.com.ar";

        RestAssured.baseURI = "https://nodejs-qa-training.herokuapp.com/";
        response = given()
                .header("Content-type", "application/json")
                .and()
                .body(templates.createLogion(correo,pasword,nombre,apellido))
                .when()
                .post("/users")
                .then().log().all()
                .extract().response();




    }
    @Then("^valido la creacion de usuario$")
    public void validoLaCreacionDeUsuario() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("201", response.statusCode()==201);
    }
    @Given("^consumo el servicio de registo con dominio Diferente a Wolox$")
    public void consumoElServicioDeRegistoConDominioDiferenteAWolox() {
        String nombre = faker.name().firstName();
        apellido=faker.name().lastName();
        nombre=Normalizer.normalize(nombre, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        pasword = faker.internet().password();
        correo=faker.internet().emailAddress();

        RestAssured.baseURI = "https://nodejs-qa-training.herokuapp.com/";
        response = given()
                .header("Content-type", "application/json")
                .and()
                .body(templates.createLogion(correo,pasword,nombre,apellido))
                .when()
                .post("/users")
                .then().log().all()
                .extract().response();

}
    @Then("^valido respuesta con correo diferente$")
    public void validoRespuestaConCorreoDiferente() {
         jsonObject=new JSONObject(response.getBody().print());
       Assert.assertTrue(jsonObject.getJSONArray("errors").getJSONObject(0).get("message").equals("The email must be @wolox.com.ar"));

    }

    @Given("^consumo el servicio de registo con dominio nombres con numeros$")
    public void consumoElServicioDeRegistoConDominioNombresConNumeros() {

        String nombre = "1"+faker.name().firstName()+"1";
        apellido="1"+faker.name().lastName()+"1";
        nombre=Normalizer.normalize(nombre, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        pasword = faker.internet().password();
        correo=faker.name().firstName()+"@wolox.com.ar";

        RestAssured.baseURI = "https://nodejs-qa-training.herokuapp.com/";
        response = given()
                .header("Content-type", "application/json")
                .and()
                .body(templates.createLogion(correo,pasword,nombre,apellido))
                .when().log().all()
                .post("/users")
                .then().log().all()
                .extract().response();

    }
    @Then("^valido respuesta con nombre con numeros$")
    public void validoRespuestaConNombreConNumeros() {
        Assert.assertTrue("201", response.statusCode()==201);
    }

    @Given("^consumo el servicio de loguin$")
    public void consumoElServicioDeLoguin() {

        pasword = "candidatoWolox2020";
        correo="admin@wolox.com.ar";

        RestAssured.baseURI = "https://nodejs-qa-training.herokuapp.com/";
        response = given()
                .header("Content-type", "application/json")
                .and()
                .body(templates.logiin(correo,pasword))
                .when().log().all()
                .post("/users/sessions")
                .then().log().all()
                .extract().response();

    }
    @Then("^valido la respuesta del loguin$")
    public void validoLaRespuestaDelLoguin() {
        Assert.assertTrue("202", response.statusCode()==200);

    }

    @Given("^consumo listado usuario$")
    public void consumoListadoUsuario() {
        RestAssured.baseURI = "https://nodejs-qa-training.herokuapp.com/";
        response = given()
                .header("Content-type", "application/json")
                .when().log().all()
                .get("/users")
                .then().log().all()
                .extract().response();
    }
    @Then("^valido la respuesta del listado$")
    public void validoLaRespuestaDelListado() {
        logger.info(String.format(response.body().print()));
    }




}
