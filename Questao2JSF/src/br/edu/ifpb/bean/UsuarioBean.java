package br.edu.ifpb.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.ifpb.Entidades.Usuario;
import br.edu.ifpb.DAO.*;

public class UsuarioBean {

	ArrayList<Usuario> usuario;
	Usuario user;

	public static Connection connection;
	public static ResultSet rs;

	public UsuarioBean() {
		this.usuario = new ArrayList<Usuario>();
		this.user= new Usuario();
	}

	public void exibeUsuario() {

		UsuarioDAO bd = new UsuarioDAO();

		int i = 0;

		for (int cont = 0; cont < 5; cont++) {

			try {

				bd.abrirConexao();
				Statement st = connection.createStatement();

				String sql = "SELECT * FROM usuario";

				rs = st.executeQuery(sql);

				if (rs.next()) {

					user.setMatricula(rs.getInt("matricula"));
					user.setData(rs.getString("data_nasc"));
					user.setNome(rs.getString("nome"));
				}

				i = i + 1;

				st.close();
				rs.close();
				bd.fecharConexao();
			} catch (SQLException sqle) {
				System.out.println("Nao foi possivel realizar inserção");
				sqle.printStackTrace(System.err);
			} catch (NullPointerException npe) {
				System.out.println("Nao foi possivel realizar inserção");
				npe.printStackTrace(System.err);
			}

			usuario.add(i, user);
		}

	}
}
