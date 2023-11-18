package br.com.fiap.vigiasaude.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.vigiasaude.model.Unidade;
import br.com.fiap.vigiasaude.model.Medico;

public class MedicoDao {
	
	public void cadastrar(Medico medico) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "INSERT INTO T_VGS_MEDICO(nom_medico, des_especialidade, num_crm,"
				+ "des_telefone, id_unidade,des_email, des_senha) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, medico.getNome());
		ps.setString(2, medico.getEspecialidade());
		ps.setString(3, medico.getCrm());
		ps.setString(4, medico.getTelefone());
		ps.setLong(5, medico.getUnidade().getId());
		ps.setString(6, medico.getEmail());
		ps.setString(7, medico.getSenha());
		ps.executeUpdate();
        connection.close();
	}

	public Medico buscarPorEmail(String email) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM T_VGS_MEDICO WHERE des_email = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		
		Medico medico = null;
		UnidadeDao unidadeDao = new UnidadeDao();
		
		while(rs.next()) {
			Unidade unidade = unidadeDao.findById(rs.getLong("id_unidade"));
			
			medico = new Medico(
					rs.getLong("id_medico"),
					rs.getString("des_nome"),
					rs.getString("des_especialidade"),
					rs.getString("num_crm"),
					rs.getString("des_telefone"),
					rs.getString("des_email"),
					rs.getString("des_senha"),
					unidade);
		}
		connection.close();
		return medico;
	}

	public Medico buscaPorId(Long id) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM T_VGS_MEDICO WHERE id_medico = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		
		Medico medico = null;
		UnidadeDao unidadeDao = new UnidadeDao();
		
		while(rs.next()) {
			Unidade unidade = unidadeDao.findById(rs.getLong("id_unidade"));
			
			medico = new Medico(
					rs.getLong("id_medico"),
					rs.getString("nom_medico"),
					rs.getString("des_especialidade"),
					rs.getString("num_crm"),
					rs.getString("des_telefone"),
					rs.getString("des_email"),
					rs.getString("des_senha"),
					unidade);
		}
		connection.close();
		return medico;
	}
	
	
}
