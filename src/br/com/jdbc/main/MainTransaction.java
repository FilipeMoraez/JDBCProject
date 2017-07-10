package br.com.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainTransaction {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// Driver
		Class.forName("com.mysql.jdbc.Driver");

		// iniciar conexao
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcexample", "root", "");
		System.out.println("esta aberta conexao? " + !conexao.isClosed());

		// Inicia transacao
		conexao.setAutoCommit(false);
		// Cria primeiro comando sql
		PreparedStatement updateSales = conexao
				.prepareStatement("insert into usuarios (name, password) values (? , ?)");
		// defini os parametros
		updateSales.setString(1, "Steffani");
		updateSales.setString(2, "321");
		// executa dentro da transação
		updateSales.executeUpdate();
		
		// Cria segundo comando sql
		PreparedStatement updateTotal = conexao
				.prepareStatement("update usuarios set name =  ? WHERE id = ?");
		// Defini os parametros
		updateTotal.setString(1, "José");
		updateTotal.setInt(2, 5);
		// Executa o segundo comando na transação
		updateTotal.executeUpdate();
		
		//executa transação completa
		conexao.commit();
		conexao.setAutoCommit(true);
	}
}
