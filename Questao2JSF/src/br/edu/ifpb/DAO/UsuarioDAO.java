package br.edu.ifpb.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.ifpb.Entidades.Usuario;

public class UsuarioDAO {

	static String user = "root";
	static String password = "";
	static String url = "jdbc:mysql://localhost:3306/bdq";
	static Connection connection;
	static ResultSet rs;

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
	
	//DML
	
	public void insereUsuario(ArrayList<Usuario> usuario) {

		try {

			abrirConexao();
			Statement st = connection.createStatement();

			String sql = "INSERT INTO usuario (matricula, nome, data_nasc) "
					+ "VALUES ('"
					+ usuario.getMatricula()
					+ "','"
					+ usuario.getNome()
					+ "','"					
					+ usuario.getData()+"')";

			st.executeUpdate(sql);
						
			st.close();
			fecharConexao();
		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel realizar inserção");
			sqle.printStackTrace(System.err);
		} catch (NullPointerException npe){
			System.out.println("Nao foi possivel realizar inserção");
			npe.printStackTrace(System.err);
		}

	}
	
	

}
