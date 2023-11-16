package br.com.fiap.vigiasaude.service;

import java.sql.SQLException;

import br.com.fiap.vigiasaude.data.UsuarioDao;
import br.com.fiap.vigiasaude.model.Usuario;

public class UsuarioService {
	
	UsuarioDao dao = new UsuarioDao();

	public boolean cadastrarUsuario(Usuario usuario) {
		if (usuario.nome().isEmpty() 
				&& usuario.email().isEmpty()
				&& usuario.senha().isEmpty()) return false;
		try {
			dao.cadastrar(usuario);
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Usuario buscaUsuario(Usuario usuario) {
		try {
			Usuario userEncontrado = dao.findByEmail(usuario.email());
			return userEncontrado;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean existeUsuario(Usuario usuario) {
		var userEncontrado = buscaUsuario(usuario);
		return userEncontrado != null 
				&& userEncontrado.email().equals(usuario.email());
	}

	public boolean validaUsuario(Usuario usuario) {
		var userEncontrado = buscaUsuario(usuario);
		return userEncontrado.email().equals(usuario.email())
				&& userEncontrado.senha().equals(usuario.senha());
	}
	
}
