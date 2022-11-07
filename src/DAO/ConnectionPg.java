/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author karol
 */
public class ConnectionPg {
	private static Connection con;

	public static Connection connect() {
		String dbname = "imobiliaria";

		String url = "jdbc:postgresql://localhost:5432/" + dbname;

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, "postgres", "root");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ConnectionPg.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException err) {
			err.printStackTrace();
		}

		return con;
	}

	public boolean disconnect() throws Exception {
		con.close();
		return true;
	}

	public boolean isConnected() throws Exception {
		return con.isValid(15);
	}

	public PreparedStatement getNewStatement(String SQL) throws Exception {
		return con.prepareStatement(SQL);
	}

	public PreparedStatement getNewStatement(String SQL, int option) throws Exception {
		return con.prepareStatement(SQL, option);
	}

	public DatabaseMetaData getDatabaseMetaData() throws Exception {
		return con.getMetaData();
	}
}
