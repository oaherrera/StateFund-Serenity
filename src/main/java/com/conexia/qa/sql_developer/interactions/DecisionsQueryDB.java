package com.conexia.qa.sql_developer.interactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.conexia.qa.sql_developer.models.QueryResponse;
import com.conexia.qa.statefund.models.Selenium;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class DecisionsQueryDB implements Interaction {

	private String rfaID;

	public DecisionsQueryDB(String rfaID) {
		this.rfaID = rfaID;
	}

	@SuppressWarnings("resource")
	@Override
	@Step("{0} query the Claim ID #rfaID")
	public <T extends Actor> void performAs(T actor) {
		String provisionalDecision = "";
		String provisionalSourceOfDecision = "";
		String sql = "SELECT\r\n" + "s.DESCRIPTION AS \"Provisional Decision\",\r\n"
				+ "s2.description AS \"Actual Decision\"\r\n" + "FROM TRANSACTIONAL.NON_CLAIM_RFA_PROCEDURE rfap\r\n"
				+ "INNER JOIN PARAMETERS.\"PROCEDURE\" pr ON pr.id = rfap.PROCEDURE_ID\r\n"
				+ "INNER JOIN PARAMETERS.STATUS s ON s.ID = rfap.PROVISIONAL_DECISION\r\n"
				+ "INNER JOIN parameters.status s2 ON s2.id = rfap.STATUS_ID\r\n"
				+ "INNER JOIN PARAMETERS.SOURCE_OF_DECISION d ON d.id = rfap.PROVISIONAL_DECISION_SOD\r\n"
				+ "INNER JOIN PARAMETERS.SOURCE_OF_DECISION d2 ON d2.id = rfap.SOURCE_OF_DECISION_ID\r\n"
				+ "INNER JOIN TRANSACTIONAL.NON_CLAIM_RFA ncr ON ncr.ID = rfap.NON_CLAIM_RFA_ID\r\n"
				+ "WHERE ncr.SF_REQUEST_ID = '" + rfaID + "'";
		ResultSet rset = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection(Selenium.parameters().getProperty("databaseConnection"),
					Selenium.parameters().getProperty("databaseUser"),
					Selenium.parameters().getProperty("databasePassword"));

			Statement stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			int ex = 0;
			while (!rset.isBeforeFirst()) {
				Thread.sleep(5000);
				rset = stmt.executeQuery(sql);
				ex += 1;
				System.out.println("Waiting response Query Decision: " + ex);
			}
			while (rset.next()) {
				provisionalDecision = rset.getString(1);
				provisionalSourceOfDecision = rset.getString(2);
				actor.attemptsTo(
						SQLEvidences.screenshot(sql, provisionalDecision + " - " + provisionalSourceOfDecision));
				QueryResponse.setProvisionalDecision(provisionalDecision);
				QueryResponse.setProvisionalSourceOfDecision(provisionalSourceOfDecision);
			}
			stmt.close();
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static DecisionsQueryDB ofClaimId(String rfaID) {
		return Tasks.instrumented(DecisionsQueryDB.class, rfaID);
	}

}