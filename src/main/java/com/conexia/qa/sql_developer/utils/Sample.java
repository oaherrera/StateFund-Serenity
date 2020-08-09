package com.conexia.qa.sql_developer.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sample {

//		DriverManager.getConnection(dataBase, "APP_CA_READ", "Pa5s4Conexia!");
	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {
		String rfaID = "N000000000717";
		String sql = "SELECT\r\n" + "ncr.SF_REQUEST_ID AS \"Non-Claim-RFA number\",\r\n"
				+ "pr.CODE AS \"Procedure Code\",\r\n" + "s.DESCRIPTION AS \"Provisional Decision\",\r\n"
				+ "d.DESCRIPTION AS \"Provisional Source of Decision\",\r\n"
				+ "s2.description AS \"Actual Decision\",\r\n" + "d2.DESCRIPTION AS \"Actual Source of Decision\"\r\n"
				+ "FROM TRANSACTIONAL.NON_CLAIM_RFA_PROCEDURE rfap\r\n"
				+ "INNER JOIN PARAMETERS.\"PROCEDURE\" pr ON pr.id = rfap.PROCEDURE_ID\r\n"
				+ "INNER JOIN PARAMETERS.STATUS s ON s.ID = rfap.PROVISIONAL_DECISION\r\n"
				+ "INNER JOIN parameters.status s2 ON s2.id = rfap.STATUS_ID\r\n"
				+ "INNER JOIN PARAMETERS.SOURCE_OF_DECISION d ON d.id = rfap.PROVISIONAL_DECISION_SOD\r\n"
				+ "INNER JOIN PARAMETERS.SOURCE_OF_DECISION d2 ON d2.id = rfap.SOURCE_OF_DECISION_ID\r\n"
				+ "INNER JOIN TRANSACTIONAL.NON_CLAIM_RFA ncr ON ncr.ID = rfap.NON_CLAIM_RFA_ID\r\n"
				+ "WHERE ncr.SF_REQUEST_ID = '" + rfaID + "'";
		String dataBase = "jdbc:oracle:thin:@192.168.80.106:1521:SFT";
		String jsonString = "";
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

		Connection conn = DriverManager.getConnection(dataBase, "APP_CA_READ", "Pa5s4Conexia!");

		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		while (rset.next()) {
			System.out.println(rset.getString(1));
			jsonString = rset.getString(1);
		}
		stmt.close();
		System.out.println("end");

		// JSON Path
//		String pageName = JsonPath.read(jsonString, "$.claimNumber");
//		System.out.println(pageName);
	}

}