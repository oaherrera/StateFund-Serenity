package com.conexia.qa.sql_developer.interactions;

import static com.conexia.qa.sql_developer.models.QueryResponse.getQueryResponse;
import static com.conexia.qa.sql_developer.models.QueryResponse.setQueryResponse;
import static com.conexia.qa.sql_developer.utils.ConectionBD.getConexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conexia.qa.sql_developer.models.QueryResponse;
import com.conexia.qa.sql_developer.utils.ConectionBD;
import com.conexia.qa.statefund.models.FieldsSavedDraft;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

/**
 * @author ChristianCamiloSchottlaender
 */
public class SearchDraftSavedDB implements Interaction {

	private String userCreated;
	private String claimNumber;
	private String orderBy;
	private String idDraft;
	private ConectionBD conection = getConexion();

	public SearchDraftSavedDB(String userCreated, String claimNumber, String idDraft, String orderBy) {
		this.userCreated = userCreated;
		this.claimNumber = claimNumber;
		this.idDraft = idDraft;

		switch (orderBy) {
		case "ascending":
			this.orderBy = "asc";
			break;
		case "descending":
			this.orderBy = "desc";
			break;
		default:
			this.orderBy = "desc";
			break;
		}
	}

	@Override
	@Step("{0} Search Saved Draft for (#userCreated and #claimNumber) or (#idDraft) order by Date")
	public <T extends Actor> void performAs(T actor) {
		try {
			String statement = "";
			PreparedStatement pStatement = null;
			if (idDraft != null) {
				statement = "" + "select "
						+ "    d.id,d.worker_claim_number, d.worker_full_name,to_char(d.worker_date_of_injury,'mm/dd/yyyy')worker_date_of_injury,\r\n"
						+ "    to_char(d.saved_draft_date,'mm/dd/yyyy HH12:Mi pm') saved_draft_date "
						+ "from  MASTER.rfa_drafts d " + " where " + "    d.id = ? " + "    and d.deleted = 'F'"
						+ " order by  d.saved_draft_date " + orderBy + " ";

				pStatement = conection.metPrepararSentcia(statement);
				pStatement.setString(1, idDraft);
			} else {

				statement = "" + "select * from (" + "select "
						+ "    d.id,d.worker_claim_number, d.worker_full_name,to_char(d.worker_date_of_injury,'mm/dd/yyyy')worker_date_of_injury,\r\n"
						+ "    to_char(d.saved_draft_date,'mm/dd/yyyy HH12:Mi pm') saved_draft_date "
						+ "from  MASTER.rfa_drafts d " + " where " + "    d.worker_claim_number = ?"
						+ "    and d.created_by = ? " + "    and d.deleted = 'F'" + " order by  d.saved_draft_date "
						+ orderBy + "" + ")" + "where rownum <6 " + "";
				pStatement = conection.metPrepararSentcia(statement);
				pStatement.setString(1, claimNumber);
				pStatement.setString(2, userCreated);
			}

			ResultSet Results = pStatement.executeQuery();

			FieldsSavedDraft.emptyfieldsSavedDraftList();

			setQueryResponse("" + "<table border=1>" + "<tr>"
					+ "<td>id</td><td>ClaimNumber</td><td>InjuredWorker</td><td>DateOfInjury</td><td>SavedDate</td>"
					+ "</tr>");

			while (Results.next()) {
				FieldsSavedDraft SavedDraft = new FieldsSavedDraft();
				SavedDraft.setId(Results.getString(1));
				SavedDraft.setClaimNumber(Results.getString(2));
				SavedDraft.setInjuredWorker(Results.getString(3));
				SavedDraft.setDateOfInjury(Results.getString(4));
				SavedDraft.setSavedDate(Results.getString(5));

				FieldsSavedDraft.savefieldsSavedDraftList(SavedDraft);

				setQueryResponse(getQueryResponse() + "<tr><td>" + Results.getString(1) + "</td>" + "<td>"
						+ Results.getString(2) + "</td>" + "<td>" + Results.getString(3) + "</td>" + "<td>"
						+ Results.getString(4) + "</td>" + "<td>" + Results.getString(5) + "</td></tr>");
			}

			setQueryResponse(getQueryResponse() + "</table>");

			pStatement.clearParameters();
			pStatement.close();
			conection.metDesconectarBd();

			actor.attemptsTo(SQLEvidences.screenshot(statement, QueryResponse.getQueryResponse()));
		} catch (SQLException e) {
			conection.metDesconectarBd();
			e.printStackTrace();
		}
	}

	/**
	 * @param orderBy (ascending, descending)
	 **/
	public static SearchDraftSavedDB forFilds(String userCreated, String claimNumber, String orderBy) {
		return Tasks.instrumented(SearchDraftSavedDB.class, userCreated, claimNumber, null, orderBy);
	}

	public static SearchDraftSavedDB byId(String idDraft) {
		return Tasks.instrumented(SearchDraftSavedDB.class, null, null, idDraft, "descending");
	}

}