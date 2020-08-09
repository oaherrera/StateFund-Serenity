package com.conexia.qa.sql_developer.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.conexia.qa.statefund.models.Selenium;

/**
 * @author ChristianCamiloSchottlaender
 */
public class ConectionBD_CAS {

	public static ConectionBD_CAS objClaConxion;
	private Connection conexion;

	public static ConectionBD_CAS getConexion() {
		if (objClaConxion == null) {
			objClaConxion = new ConectionBD_CAS();
		}
		return objClaConxion;
	}

	public Connection Conexion() {
		return this.conexion;
	}

	private Connection metGetConexionDrive() {
		try {
			Class.forName("org.postgresql.Driver");
			return this.conexion = DriverManager.getConnection(
					Selenium.parameters().getProperty("databaseConnectionCAS"),
					Selenium.parameters().getProperty("databaseUserCAS"),
					Selenium.parameters().getProperty("databasePasswordCAS"));
		} catch (SQLException ex) {
			Logger.getLogger(ConectionBD_CAS.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error Metodo metGetConexionDrive: " + ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println("Error Metodo metGetConexionDrive: " + ex.getMessage());
			Logger.getLogger(ConectionBD_CAS.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public void metDesconectarBd() {
		try {
			this.conexion.close();
			System.out.println("Desconectado? " + this.conexion.isClosed());
		} catch (SQLException ex) {
			System.out.println("Error Metodo metDesconectarBd: " + ex.getMessage());
			Logger.getLogger(ConectionBD_CAS.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public PreparedStatement metPrepararSentcia(String parSentencia) {
		try {
			PreparedStatement preparedStatement = metGetConexionDrive().prepareStatement(parSentencia);
			System.out.println("" + parSentencia);
			return preparedStatement;
		} catch (SQLException ex) {
			System.out.println("Error Metodo metPrepararSentcia: " + ex.getMessage());
			Logger.getLogger(ConectionBD_CAS.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public CallableStatement metPrepararSentciaSP(String parSentencia) {
		try {
			CallableStatement preparedStatement = metGetConexionDrive().prepareCall(parSentencia);
			System.out.println("" + parSentencia);
			return preparedStatement;
		} catch (SQLException ex) {
			System.out.println("Error Metodo metPrepararSentcia: " + ex.getMessage());
			Logger.getLogger(ConectionBD_CAS.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}