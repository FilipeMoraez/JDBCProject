package br.com.jdbc.main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainConcorrency {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");

		// iniciar conexao
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcexample", "root", "");
		Statement stmt = null;
		ResultSet rs = null;

		// Criando statement
		conexao.setAutoCommit(false);
		stmt = conexao.createStatement();
		// Comandos SQL
		String updateQuery1 = "INSERT INTO usuarios(name, password) VALUES('Maria','CBA')";
		String updateQuery2 = "INSERT INTO usuarios(name, password)  VALUES('Joana','ABC')";
		String selectQuery = "SELECT * FROM usuarios";

		stmt.executeUpdate(updateQuery1);
		stmt.executeUpdate(updateQuery2);
		rs = stmt.executeQuery(selectQuery);
		DatabaseMetaData dbMetaData = conexao.getMetaData();
		if (dbMetaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE)) {
			conexao.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			conexao.commit();
		}
		while (rs.next()) {
			System.out.println("Id - " + rs.getInt("id") + ", name- " + rs.getString("name") + ", password- "
					+ rs.getString("password"));
		}

	}
}
