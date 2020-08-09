package com.conexia.qa.sql_developer.interactions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;

import com.conexia.qa.sql_developer.utils.ConectionBD_CAS;
import com.conexia.qa.statefund.models.UserAuthentication;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class PasswordEncryptedDB implements Interaction {

	@Override
	@Step("{0} Password Encrypted")
	public <T extends Actor> void performAs(T actor) {
		String sql = "";
		ResultSet rset = null;

		sql = "SELECT	username, password\r\n" + "  FROM	PUBLIC.USER\r\n" + " WHERE	username = '"
				+ UserAuthentication.readData(0).getUserName() + "'";

		try {
			PreparedStatement stmt = ConectionBD_CAS.getConexion().metPrepararSentcia(sql);
			rset = stmt.executeQuery();

			while (rset.next()) {
				Assert.assertTrue(rset.getString(1).equals(UserAuthentication.readData(0).getUserName()));
				UserAuthentication.readData(0).setPassword(rset.getString(2));
			}
			actor.attemptsTo(SQLEvidences.screenshot(sql, UserAuthentication.readData(0).getUserName() + " - "
					+ UserAuthentication.readData(0).getPassword()));
			stmt.close();

			ConectionBD_CAS.getConexion().metDesconectarBd();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			ConectionBD_CAS.getConexion().metDesconectarBd();
		}
	}

	public static PasswordEncryptedDB query() {
		return Tasks.instrumented(PasswordEncryptedDB.class);
	}

}