package com.conexia.qa.statefund.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
		features = "src/test/resources/features/fase_2a_mas/rule_engine_non_claim_rfa/create_non_claim_rfa.feature",
		snippets = SnippetType.CAMELCASE,
		glue = "com.conexia.qa.statefund.steps_definitions"
//		, tags = "@TestCaseRuleEngineANonClaimRFA"
)
public class RulesEngineNonClaimRFARunner {

}