package br.com.fiap.vigiasaude.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.vigiasaude.model.Usuario;

public class UsuarioDao {

	public void cadastrar(Usuario usuario) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "INSERT INTO T_VGS_USUARIO(des_nome,des_email,des_senha,des_telefone)"
        		+ " VALUES(?,?,?,?) ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, usuario.nome());
        ps.setString(2, usuario.email());
        ps.setString(3, usuario.senha());
        ps.setString(4, usuario.telefone());
        ps.executeQuery();
        connection.close();
	}

	public Usuario findByEmail(String email) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM T_VGS_USUARIO WHERE des_email = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		Usuario usuario = null;
		while (rs.next()) {
			usuario = new Usuario(
					rs.getLong("cod_usuario"),
					rs.getString("des_nome"),
					rs.getString("des_email"),
					rs.getString("des_senha"),
					rs.getString("des_telefone"));
		}
		return usuario;
	}


}
