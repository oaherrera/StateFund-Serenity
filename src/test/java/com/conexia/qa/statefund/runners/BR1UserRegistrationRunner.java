package com.conexia.qa.statefund.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/fase_2a/br1_user_registration/br1_user_registration.feature",
		snippets = SnippetType.CAMELCASE,
		glue = "com.conexia.qa.statefund.steps_definitions"
		, tags = "@TestCaseBR1Scenario11"
)
public class BR1UserRegistrationRunner {

}
