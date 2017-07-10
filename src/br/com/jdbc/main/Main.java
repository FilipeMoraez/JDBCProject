package br.com.jdbc.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	public static void main(String args[]) throws SQLException, ClassNotFoundException{
		// Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		// iniciar conexao
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcexample", "root", "");
		System.out.println("esta aberta conexao? "  + !conexao.isClosed());
		// Comando no banco de dados Simples
		// String sql
		String sql = "select id, name, password from usuarios where id = ? and name = ?";
		// cria prepared stament
		PreparedStatement statement = conexao.prepareStatement(sql);
		//Informa o valor do parametro na primeira posição com valor de 1 
		statement.setInt(1,  1);
		// Informa o valor do segundo parametro, com valor de Filipe
		statement.setString(2,  "Filipe");
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
