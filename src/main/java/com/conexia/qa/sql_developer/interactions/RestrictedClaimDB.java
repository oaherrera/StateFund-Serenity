package com.conexia.qa.sql_developer.interactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;

import com.conexia.qa.statefund.models.Selenium;
import com.conexia.qa.statefund.models.WorkerInformation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class RestrictedClaimDB implements Interaction {

	@Override
	@Step("{0} Restricted Claim")
	public <T extends Actor> void performAs(T actor) {
		String sql = "";
		ResultSet rset = null;

		sql = "SELECT	RESTRICTED_FLAG_ID\r\n" + "  FROM	MASTER.CLAIM\r\n" + " WHERE	CLAIM.CLAIM_NUMBER = "
				+ WorkerInformation.readData(0).getClaimNumber() + "";

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection(Selenium.parameters().getProperty("databaseConnection"),
					Selenium.parameters().getProperty("databaseUser"),
					Selenium.parameters().getProperty("databasePassword"));

			Statement stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				Assert.assertTrue(rset.getString(1).equals("1"));
				actor.attemptsTo(SQLEvidences.screenshot(sql, rset.getString(1)));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static RestrictedClaimDB query() {
		return Tasks.instrumented(RestrictedClaimDB.class);
	}

}