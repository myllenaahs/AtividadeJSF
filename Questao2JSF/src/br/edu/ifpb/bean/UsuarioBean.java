package br.edu.ifpb.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.edu.ifpb.Entidades.Usuario;
import br.edu.ifpb.DAO.UsuarioDAO;

@RequestScoped
@ManagedBean
public class UsuarioBean {

	ArrayList<Usuario> usuario;

	public static Connection connection;
	public static ResultSet rs;

	public UsuarioBean() {
		this.usuario = new ArrayList<Usuario>();
	}

	public ArrayList<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(ArrayList<Usuario> usuario) {
		this.usuario = usuario;
	}

	public void exibeUsuario() {
		int i = 0;
		UsuarioDAO bd = new UsuarioDAO();
		Usuario user = new Usuario();

		for (i = 0; i < 5; i++) {
			user = bd.mostraUsuario();
			this.usuario.add(i, user);
		}

	}

}
