package br.edu.ifpb.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.ifpb.Entidades.Usuario;

public class UsuarioDAO {

	public static String user = "root";
	public static String password = "";
	public static String url = "jdbc:mysql://localhost:3306/bdq";
	public static Connection connection;
	public static ResultSet rs;

	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}

	// CONEXÃO COM O BD
	public void abrirConexao() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException cnfe) {
			System.out.println("Nao foi possivel encontrar o Driver apropriado");
		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel conectar ao SGBD");
			sqle.printStackTrace(System.err);
		}

	}

	public void fecharConexao() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			System.out.println("Nao foi possivel fechar conexão");
			e.printStackTrace();
		} catch (NullPointerException npe) {
			System.out.println("Nao foi possivel realizar inserção");
			npe.printStackTrace(System.err);
		}
	}

	// DML

	

}
