package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteDB {
	final static String URL = "jdbc:mariadb://localhost:3307/agendadb";
	final static String USER = "root";
	final static String PASS = "alunofatec";

	public static void main(String args[]) {
		System.out.println("Ola mundo");
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Conectado no database");
			PreparedStatement stm =con.prepareStatement("INSERT INTO contatos(nome, email, telefone) VALUE ('Maria Santos', 'joao@teste.com', '(11) 1111-1111')");
			stm.executeUpdate();
		} catch(SQLException | ClassNotFoundException e) {
			System.err.println("Erro ao Conectar");
			e.printStackTrace();
		}
		
	}

}