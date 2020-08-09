package com.conexia.qa.statefund.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/fase_2a/br3_password_recovery/br3_password_recovery.feature",
		snippets = SnippetType.CAMELCASE,
		glue = "com.conexia.qa.statefund.steps_definitions"
//		,tags = "@TestCaseBR3Scenario11"
)
public class BR3PasswordRecoveryRunner {

}