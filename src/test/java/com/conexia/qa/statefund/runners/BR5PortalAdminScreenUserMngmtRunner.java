package com.conexia.qa.statefund.runners;

import static cucumber.api.SnippetType.CAMELCASE;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/fase_2a/br5_portal_admin_screen_user_mngmt/br5_portal_admin_screen_user_mngmt.feature",
		snippets = CAMELCASE,
		glue = "com.conexia.qa.statefund.steps_definitions"
//		, tags = "@TestCaseBR5Scenario45"
)
public class BR5PortalAdminScreenUserMngmtRunner {

}