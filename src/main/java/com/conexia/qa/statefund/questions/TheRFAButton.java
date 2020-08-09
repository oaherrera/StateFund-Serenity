package com.conexia.qa.statefund.questions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;

import com.conexia.qa.sql_developer.interactions.SQLEvidences;
import com.conexia.qa.sql_developer.models.ClaimDecision;
import com.conexia.qa.sql_developer.models.ClaimType;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.models.Selenium;
import com.conexia.qa.statefund.models.WorkerInformation;
import com.conexia.qa.statefund.user_interfaces.ClaimDetailsPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;

public class TheRFAButton implements Question<Boolean> {

	private String state;
	private String claimType;
	private String claimDecision;

	public TheRFAButton(String state, String claimType, String claimDecision) {
		this.state = state;
		this.claimType = claimType;
		this.claimDecision = claimDecision;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		String sql = "";
		ResultSet rset = null;
		Boolean validate = null;

		if (state.equalsIgnoreCase("disabled")) {
			sql = "SELECT	ID\r\n" + "  FROM	PARAMETERS.CLAIM_TYPE\r\n"
					+ " WHERE	PARAMETERS.CLAIM_TYPE.DESCRIPTION LIKE '" + claimType + "'";

			try {
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection conn = DriverManager.getConnection(Selenium.parameters().getProperty("databaseConnection"),
						Selenium.parameters().getProperty("databaseUser"),
						Selenium.parameters().getProperty("databasePassword"));

				Statement stmt = conn.createStatement();
				rset = stmt.executeQuery(sql);

				while (rset.next()) {
					ClaimType.setId(rset.getString(1));
				}
				actor.attemptsTo(SQLEvidences.screenshot(sql, ClaimType.getId()));
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

			if (!claimDecision.isEmpty()) {

				if (!claimDecision.equalsIgnoreCase("blank")) {
					sql = "SELECT	ID, DESCRIPTION\r\n" + "  FROM	PARAMETERS.CLAIM_DECISION\r\n"
							+ " WHERE	PARAMETERS.CLAIM_DECISION.DESCRIPTION LIKE '" + claimDecision + "'";

					try {
						DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
						Connection conn = DriverManager.getConnection(
								Selenium.parameters().getProperty("databaseConnection"),
								Selenium.parameters().getProperty("databaseUser"),
								Selenium.parameters().getProperty("databasePassword"));

						Statement stmt = conn.createStatement();
						rset = stmt.executeQuery(sql);

						while (rset.next()) {
							ClaimDecision.setId(rset.getString(1));
						}
						actor.attemptsTo(SQLEvidences.screenshot(sql, ClaimDecision.getId()));
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println(e.getMessage());
					}
					sql = "SELECT	CLAIM_TYPE_ID, CLAIM_DECISION_ID, CLAIM_NUMBER\r\n" + "  FROM	master.CLAIM\r\n"
							+ " WHERE	CLAIM.CLAIM_TYPE_ID = " + ClaimType.getId() + "\r\n"
							+ "   AND	CLAIM.CLAIM_DECISION_ID = " + ClaimDecision.getId() + "\r\n"
							+ "   AND	CLAIM.CLAIM_NUMBER = " + WorkerInformation.readData(0).getClaimNumber() + "";
				} else {
					sql = "SELECT	CLAIM_TYPE_ID, CLAIM_DECISION_ID, CLAIM_NUMBER\r\n" + "  FROM	master.CLAIM\r\n"
							+ " WHERE	CLAIM.CLAIM_TYPE_ID = " + ClaimType.getId() + "\r\n"
							+ "   AND	CLAIM.CLAIM_DECISION_ID IS NULL\r\n" + "   AND	CLAIM.CLAIM_NUMBER = "
							+ WorkerInformation.readData(0).getClaimNumber() + "";
				}

				try {
					DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
					Connection conn = DriverManager.getConnection(
							Selenium.parameters().getProperty("databaseConnection"),
							Selenium.parameters().getProperty("databaseUser"),
							Selenium.parameters().getProperty("databasePassword"));

					Statement stmt = conn.createStatement();
					rset = stmt.executeQuery(sql);

					while (rset.next()) {
						ClaimType.setId(rset.getString(1));
						ClaimDecision.setId(rset.getString(2));
						ClaimType.setDescription(rset.getString(3));
					}
					actor.attemptsTo(SQLEvidences.screenshot(sql,
							ClaimType.getId() + " - " + ClaimDecision.getId() + " - " + ClaimType.getDescription()));
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}

			if (claimDecision.isEmpty()) {
				sql = "SELECT	CLAIM_TYPE_ID, CLAIM_NUMBER\r\n" + "  FROM	master.CLAIM\r\n"
						+ " WHERE	CLAIM.CLAIM_TYPE_ID = " + ClaimType.getId() + "\r\n"
						+ "   AND	CLAIM.CLAIM_NUMBER = " + WorkerInformation.readData(0).getClaimNumber() + "";

				try {
					DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
					Connection conn = DriverManager.getConnection(
							Selenium.parameters().getProperty("databaseConnection"),
							Selenium.parameters().getProperty("databaseUser"),
							Selenium.parameters().getProperty("databasePassword"));

					Statement stmt = conn.createStatement();
					rset = stmt.executeQuery(sql);

					while (rset.next()) {
						ClaimType.setId(rset.getString(1));
						ClaimType.setDescription(rset.getString(2));
					}
					actor.attemptsTo(
							SQLEvidences.screenshot(sql, ClaimType.getId() + " - " + ClaimType.getDescription()));
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}

		} else if (state.equalsIgnoreCase("enabled")) {
			sql = "SELECT	ID\r\n" + "  FROM	PARAMETERS.CLAIM_TYPE\r\n"
					+ " WHERE	PARAMETERS.CLAIM_TYPE.DESCRIPTION LIKE '" + claimType + "'";

			try {
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection conn = DriverManager.getConnection(Selenium.parameters().getProperty("databaseConnection"),
						Selenium.parameters().getProperty("databaseUser"),
						Selenium.parameters().getProperty("databasePassword"));

				Statement stmt = conn.createStatement();
				rset = stmt.executeQuery(sql);

				while (rset.next()) {
					ClaimType.setId(rset.getString(1));
				}
				actor.attemptsTo(SQLEvidences.screenshot(sql, ClaimType.getId()));
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

			sql = "SELECT	ID, DESCRIPTION\r\n" + "  FROM	PARAMETERS.CLAIM_DECISION\r\n"
					+ " WHERE	PARAMETERS.CLAIM_DECISION.DESCRIPTION LIKE '" + claimDecision + "'";

			try {
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection conn = DriverManager.getConnection(Selenium.parameters().getProperty("databaseConnection"),
						Selenium.parameters().getProperty("databaseUser"),
						Selenium.parameters().getProperty("databasePassword"));

				Statement stmt = conn.createStatement();
				rset = stmt.executeQuery(sql);

				while (rset.next()) {
					ClaimDecision.setId(rset.getString(1));
				}
				actor.attemptsTo(SQLEvidences.screenshot(sql, ClaimDecision.getId()));
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

			sql = "SELECT	CLAIM_TYPE_ID, CLAIM_DECISION_ID, CLAIM_NUMBER\r\n" + "  FROM	master.CLAIM\r\n"
					+ " WHERE	CLAIM.CLAIM_TYPE_ID = " + ClaimType.getId() + "\r\n"
					+ "   AND	CLAIM.CLAIM_DECISION_ID = " + ClaimDecision.getId() + "\r\n"
					+ "   AND	CLAIM.CLAIM_NUMBER = " + WorkerInformation.readData(0).getClaimNumber() + "";

			try {
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection conn = DriverManager.getConnection(Selenium.parameters().getProperty("databaseConnection"),
						Selenium.parameters().getProperty("databaseUser"),
						Selenium.parameters().getProperty("databasePassword"));

				Statement stmt = conn.createStatement();
				rset = stmt.executeQuery(sql);

				while (rset.next()) {
					ClaimType.setId(rset.getString(1));
					ClaimDecision.setId(rset.getString(2));
					ClaimType.setDescription(rset.getString(3));
				}
				actor.attemptsTo(SQLEvidences.screenshot(sql,
						ClaimType.getId() + " - " + ClaimDecision.getId() + " - " + ClaimType.getDescription()));
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		Assert.assertTrue(ClaimType.getDescription().equals(WorkerInformation.readData(0).getClaimNumber()));
		actor.attemptsTo(WaitLoading.page(), Scroll.to(ClaimDetailsPage.SUBMIT_RFA));
		Serenity.takeScreenshot();
		if (state.equalsIgnoreCase("disabled")) {
			validate = !ClaimDetailsPage.SUBMIT_RFA.resolveFor(actor).isEnabled();
		} else if (state.equalsIgnoreCase("enabled")) {
			validate = ClaimDetailsPage.SUBMIT_RFA.resolveFor(actor).isEnabled();
		}
		return validate;
	}

	public static TheRFAButton isDisabled(String claimType) {
		return new TheRFAButton("Disabled", claimType, "");
	}

	public static TheRFAButton isEnabled(String claimType, String claimDecision) {
		return new TheRFAButton("Enabled", claimType, claimDecision);
	}

	public static TheRFAButton isDisabled(String claimType, String claimDecision) {
		return new TheRFAButton("Disabled", claimType, claimDecision);
	}

}