package com.conexia.qa.statefund.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/fase_2a/br4_admin_user_menu/br4_admin_user_menu.feature",
		snippets = SnippetType.CAMELCASE,
		glue = "com.conexia.qa.statefund.steps_definitions"
//		, tags = "@TestCaseBR4Scenario7"
)
public class BR4AdminUserMenuRunner {

}