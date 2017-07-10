package br.com.jdbc.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainPrepared {
	public static void main(String args[]) throws SQLException, ClassNotFoundException{
		// Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		// iniciar conexao
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcexample", "root", "");
		System.out.println("esta aberta conexao? "  + !conexao.isClosed());
		// Comando no banco de dados Simples
		Statement statement = conexao.createStatement();
		// String sql
		String sql = "select * from usuarios;";
		// Pega um resultado através de resultados.
		ResultSet result = statement.executeQuery(sql);
		// Enquanto houver resultados
		while(result.next()){
			// Imprime a primeira coluna
			System.out.println(result.getInt("id"));
			// Imprime a primeira coluna
			System.out.println(result.getString("name"));
			// Imprime a terceira coluna
			System.out.println(result.getString("password"));
		}
		
	}
}
