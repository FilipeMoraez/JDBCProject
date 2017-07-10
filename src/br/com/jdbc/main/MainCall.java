package br.com.jdbc.main;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MainCall {
	public static void main(String args[]) throws SQLException, ClassNotFoundException{
		// Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		// iniciar conexao
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcexample", "root", "");
		System.out.println("esta aberta conexao? "  + !conexao.isClosed());
		// Comando no banco de dados Simples
		// String sql
		String sql = "call Listar()";
		// cria prepared stament
		CallableStatement statement = conexao.prepareCall(sql);
		// Pega um resultado através de resultados.
		ResultSet result = statement.executeQuery();
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
