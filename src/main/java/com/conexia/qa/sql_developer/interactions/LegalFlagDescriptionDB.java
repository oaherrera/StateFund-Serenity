package com.conexia.qa.sql_developer.interactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.conexia.qa.sql_developer.models.QueryResponse;
import com.conexia.qa.statefund.models.LegalFlag;
import com.conexia.qa.statefund.models.Selenium;
import com.conexia.qa.statefund.models.WorkerInformation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class LegalFlagDescriptionDB implements Interaction {

	@Override
	@Step("{0} Legal Flag Description")
	public <T extends Actor> void performAs(T actor) {
		String sql = "";
		ResultSet rset = null;

		sql = "SELECT	JSON_DATA\r\n" + "  FROM	STAGING.JSON_OUT\r\n" + " WHERE	JSON_DATA LIKE '%"
				+ WorkerInformation.readData(0).getClaimNumber() + "%'\r\n" + "   AND	JSON_DATA LIKE '%"
				+ LegalFlag.readData(0).getComment() + "%'\r\n" + "   AND	JSON_DATA LIKE '%"
				+ LegalFlag.readData(0).getSubmittedDate() + "%'";

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection(Selenium.parameters().getProperty("databaseConnection"),
					Selenium.parameters().getProperty("databaseUser"),
					Selenium.parameters().getProperty("databasePassword"));

			Statement stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				QueryResponse.setJsonString(rset.getString("JSON_DATA"));
			}
			actor.attemptsTo(SQLEvidences.screenshot(sql, QueryResponse.getJsonString()));
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static LegalFlagDescriptionDB query() {
		return Tasks.instrumented(LegalFlagDescriptionDB.class);
	}

}