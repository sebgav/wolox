package com.co.certificacion.pruebas.runnertest;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/wolox.feature",
        glue = "com.co.certificacion.pruebas.definitions",
        snippets = SnippetType.CAMELCASE,
        tags = {"@tag5"}

)
public class TestRunnerAvianca {
}
