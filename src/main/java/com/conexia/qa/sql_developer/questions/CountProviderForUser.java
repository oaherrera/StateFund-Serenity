package com.conexia.qa.sql_developer.questions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conexia.qa.sql_developer.interactions.SQLEvidences;
import com.conexia.qa.sql_developer.models.QueryResponse;
import com.conexia.qa.sql_developer.models.User;
import com.conexia.qa.sql_developer.utils.ConectionBD;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class CountProviderForUser implements Task {

	private int idUserCas;
	private ConectionBD conection = ConectionBD.getConexion();

	public CountProviderForUser(int idUserCas) {
		this.idUserCas = idUserCas;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		PreparedStatement pstatement = conection
				.metPrepararSentcia("" + " select count(distinct pr.name ) " + " from security.user_model um  "
						+ " inner join MASTER.physician_user_model  pu on um.id = pu.user_id  "
						+ " inner join master.provider_physician  ph on pu.physician_id = ph.physician_id "
						+ " inner join MASTER.physician p on ph.physician_id = p.id "
						+ " inner join master.provider pr on ph.provider_id = pr.id " + " where cas_user = ? "
						+ " and pu.deleted <> 'T' " + "");

		String statement = "" + " select count(distinct pr.name ) " + " from security.user_model um  "
				+ " inner join MASTER.physician_user_model  pu on um.id = pu.user_id  "
				+ " inner join master.provider_physician  ph on pu.physician_id = ph.physician_id "
				+ " inner join MASTER.physician p on ph.physician_id = p.id "
				+ " inner join master.provider pr on ph.provider_id = pr.id " + " where cas_user = ? "
				+ " and pu.deleted <> 'T' ";

		try {
			pstatement.setInt(1, idUserCas);
			ResultSet Data = pstatement.executeQuery();

			while (Data.next()) {
				User.setCountProvider(Data.getInt(1));
				QueryResponse.setQueryResponse("Count BD:" + Data.getInt(1));
			}

			pstatement.clearParameters();
			pstatement.close();

			conection.metDesconectarBd();
			actor.attemptsTo(SQLEvidences.screenshot(statement, QueryResponse.getQueryResponse()));
		} catch (SQLException e) {
			conection.metDesconectarBd();
			e.printStackTrace();
		}
	}

	public static CountProviderForUser inDataBase(int idUserCas) {
		return Tasks.instrumented(CountProviderForUser.class, idUserCas);
	}

}