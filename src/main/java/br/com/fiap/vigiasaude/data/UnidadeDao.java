package br.com.fiap.vigiasaude.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.vigiasaude.model.Unidade;

public class UnidadeDao {
	
	private final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private final String USER = "rm99627";
	private final String PASS = "051298";

	public Unidade findByNome(String nome) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM T_VGS_UNIDADE WHERE nom_unidade = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, nome);
		ResultSet rs = ps.executeQuery();
		
		Unidade unidade = null;
		
		while (rs.next()) {
			unidade = new Unidade(
					rs.getLong("id_unidade"), 
					rs.getString("nom_unidade"), 
					rs.getString("des_telefone_unidade"), 
					rs.getString("des_email_unidade"),
					rs.getString("des_senha"),
					rs.getString("des_endereco_unidade"), 
					rs.getString("des_cep_unidade"), 
					rs.getString("des_estado"), 
					rs.getString("des_cidade"),
					rs.getString("des_CNES"), 
					rs.getLong("id_tipo")); 
		}
		connection.close();
		return unidade;
	}

	public void cadastrar(Unidade unidade) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "INSERTO INTO T_VGS_UNIDADE (nom_unidade, des_telefone_unidade, des_email_unidade,"
				+ "des_endereco_unidade, des_cep_unidade, des_senha, des_estado, des_cidade, "
				+ "id_tipo, des_CNES) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, unidade.getNome());
		ps.setString(2, unidade.getTelefone());
		ps.setString(3, unidade.getEmail());
		ps.setString(4, unidade.getEndereco());
		ps.setString(5, unidade.getCep());
		ps.setString(7, unidade.getSenha());
		ps.setString(8, unidade.getEstado());
		ps.setString(9, unidade.getCidade());
		ps.setString(10, unidade.getCnes());
		
		connection.close();
		ps.executeQuery();
	}

	public Unidade findById(Long id) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		var con = DriverManager.getConnection(URL, USER, PASS);
		String sql = "SELECT * FROM T_VGS_UNIDADE WHERE id_unidade = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		
		Unidade unidade = null;
		
		while (rs.next()) {
			unidade = new Unidade(
					rs.getLong("id_unidade"), 
					rs.getString("nom_unidade"), 
					rs.getString("des_telefone_unidade"), 
					rs.getString("des_email_unidade"),
					rs.getString("des_senha"),
					rs.getString("des_endereco_unidade"), 
					rs.getString("des_cep_unidade"), 
					rs.getString("des_estado"), 
					rs.getString("des_cidade"),
					rs.getString("des_CNES"), 
					rs.getLong("id_tipo"));  
		}
		con.close();
		return unidade;
	}
}
