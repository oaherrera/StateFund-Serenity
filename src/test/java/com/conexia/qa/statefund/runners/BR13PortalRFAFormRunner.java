package com.conexia.qa.statefund.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/fase_2a/br13_portal_rfa_form/br13_portal_rfa_form.feature",
		snippets = SnippetType.CAMELCASE,
		glue = "com.conexia.qa.statefund.steps_definitions"
//		,tags = "@TestCaseBR13Scenario63"
)
public class BR13PortalRFAFormRunner {

}