package com.conexia.qa.sql_developer.interactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.conexia.qa.sql_developer.models.ClaimDetail;
import com.conexia.qa.statefund.models.Selenium;
import com.conexia.qa.statefund.models.WorkerInformation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class SpecificationDetailsClaimDB implements Interaction {

	@Override
	@Step("{0} Specification Claim Details")
	public <T extends Actor> void performAs(T actor) {
		String sql = "";
		ResultSet rset = null;

		sql = "      SELECT	w.FIRST_NAME, w.LAST_NAME, w.MIDDLE_NAME, e.NAME, to_char(W.DATE_OF_BIRTH,'MM/DD/YYYY'), to_char(c.WORKER_DATE_OF_INJURY,'MM/DD/YYYY')\r\n"
				+ "      FROM	master.claim c\r\n" + "INNER JOIN	master.employer e ON e.id = c.employer_id\r\n"
				+ "INNER JOIN	master.worker w ON w.id = c.worker_id\r\n" + "     WHERE	c.claim_number = '"
				+ WorkerInformation.readData(0).getClaimNumber() + "'";

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection(Selenium.parameters().getProperty("databaseConnection"),
					Selenium.parameters().getProperty("databaseUser"),
					Selenium.parameters().getProperty("databasePassword"));

			Statement stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);

			ClaimDetail.setClaimNumber(WorkerInformation.readData(0).getClaimNumber());
			while (rset.next()) {
				ClaimDetail.setWorkerFirstName(rset.getString(1));
				ClaimDetail.setWorkerLastName(rset.getString(2));
				ClaimDetail.setWorkerMiddleName(rset.getString(3));
				ClaimDetail.setEmployerName(rset.getString(4));
				ClaimDetail.setWorkerDateOfBirth(rset.getString(5));
				ClaimDetail.setWorkerDateOfInjury(rset.getString(6));
			}
			actor.attemptsTo(SQLEvidences.screenshot(sql,
					ClaimDetail.getWorkerFirstName() + " - " + ClaimDetail.getWorkerLastName() + " - "
							+ ClaimDetail.getWorkerMiddleName() + " - " + ClaimDetail.getEmployerName() + " - "
							+ ClaimDetail.getWorkerDateOfBirth() + " - " + ClaimDetail.getWorkerDateOfInjury()));
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static SpecificationDetailsClaimDB query() {
		return Tasks.instrumented(SpecificationDetailsClaimDB.class);
	}

}