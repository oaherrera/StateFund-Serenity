package com.conexia.qa.sql_developer.interactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.conexia.qa.sql_developer.models.RequestedBodyParts;
import com.conexia.qa.statefund.models.Selenium;
import com.conexia.qa.statefund.models.WorkerInformation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class RequestedBodyPartsDB implements Interaction {

	@Override
	@Step("{0} Requested Body Parts")
	public <T extends Actor> void performAs(T actor) {
		String sql = "";
		ResultSet rset = null;

		sql = "    SELECT	PARAMETERS.BODY_PART.DESCRIPTION, PARAMETERS.BODY_PART_DECISION.DESCRIPTION\r\n"
				+ "      FROM	MASTER.CLAIM\r\n"
				+ "INNER JOIN	MASTER.CLAIM_BODY_PART ON MASTER.CLAIM_BODY_PART.CLAIM_ID = MASTER.CLAIM.ID\r\n"
				+ "INNER JOIN	PARAMETERS.BODY_PART ON PARAMETERS.BODY_PART.ID = MASTER.CLAIM_BODY_PART.BODY_PART_ID\r\n"
				+ "INNER JOIN	PARAMETERS.BODY_PART_DECISION ON PARAMETERS.BODY_PART_DECISION.ID = MASTER.CLAIM_BODY_PART.BODY_PART_DECISION_ID\r\n"
				+ "     WHERE	MASTER.CLAIM.CLAIM_NUMBER = '" + WorkerInformation.readData(0).getClaimNumber() + "'";

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection(Selenium.parameters().getProperty("databaseConnection"),
					Selenium.parameters().getProperty("databaseUser"),
					Selenium.parameters().getProperty("databasePassword"));

			Statement stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				RequestedBodyParts.setDescription(rset.getString(1));
				RequestedBodyParts.setDecision(rset.getString(2));
			}
			actor.attemptsTo(SQLEvidences.screenshot(sql,
					RequestedBodyParts.getDescription() + " - " + RequestedBodyParts.getDecision()));
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static RequestedBodyPartsDB query() {
		return Tasks.instrumented(RequestedBodyPartsDB.class);
	}

}