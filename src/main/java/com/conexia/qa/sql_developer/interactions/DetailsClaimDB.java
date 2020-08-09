package com.conexia.qa.sql_developer.interactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.conexia.qa.sql_developer.models.ClaimDetail;
import com.conexia.qa.statefund.models.Selenium;
import com.conexia.qa.statefund.user_interfaces.ClaimDetailsPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

public class DetailsClaimDB implements Interaction {

	@Override
	@Step("{0} Claim Details")
	public <T extends Actor> void performAs(T actor) {
		String sql = "";
		String claimNumber = Text.of(ClaimDetailsPage.CLAIM_NUMBER_UNDEFINED).viewedBy(actor).asString()
				.replace("Claim Details - Claim Number: ", "");
		ResultSet rset = null;

		sql = "    SELECT	w.FIRST_NAME, w.LAST_NAME, e.NAME, to_char(c.WORKER_DATE_OF_INJURY,'MM/DD/YYYY')\r\n"
				+ "      FROM	master.claim c\r\n" + "INNER JOIN	master.employer e on e.id = c.employer_id\r\n"
				+ "INNER JOIN	master.worker w on w.id = c.worker_id\r\n" + "     WHERE	c.claim_number = '"
				+ claimNumber + "'";

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection(Selenium.parameters().getProperty("databaseConnection"),
					Selenium.parameters().getProperty("databaseUser"),
					Selenium.parameters().getProperty("databasePassword"));

			Statement stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				ClaimDetail.setWorkerFirstName(rset.getString(1));
				ClaimDetail.setWorkerLastName(rset.getString(2));
				ClaimDetail.setEmployerName(rset.getString(3));
				ClaimDetail.setWorkerDateOfInjury(rset.getString(4));
			}
			actor.attemptsTo(SQLEvidences.screenshot(sql,
					ClaimDetail.getWorkerFirstName() + " - " + ClaimDetail.getWorkerLastName() + " - "
							+ ClaimDetail.getEmployerName() + " - " + ClaimDetail.getWorkerDateOfInjury()));
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static DetailsClaimDB query() {
		return Tasks.instrumented(DetailsClaimDB.class);
	}

}