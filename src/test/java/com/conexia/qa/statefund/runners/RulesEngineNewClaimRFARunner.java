package com.conexia.qa.statefund.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/claims/rule_engine_new_claim_rfa/create_new_claim_rfa.feature",
		snippets = SnippetType.CAMELCASE,
		glue = "com.conexia.qa.statefund.steps_definitions"
//		, tags = "@TestCase1"
)
public class RulesEngineNewClaimRFARunner {

}