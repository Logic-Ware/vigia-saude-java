package br.com.fiap.vigiasaude.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.vigiasaude.model.Unidade;

public class UnidadeDao {
	
	private Unidade populaUnidade(ResultSet rs) throws SQLException {
        return new Unidade(
                rs.getLong("id_unidade"),
                rs.getString("nom_unidade"),
                rs.getString("des_email_unidade"),
                rs.getString("des_senha"),
                rs.getString("des_telefone_unidade"),
                rs.getString("des_endereco_unidade"),
                rs.getString("des_cep_unidade"),
                rs.getString("des_estado"),
                rs.getString("des_cidade"),
                rs.getString("des_CNES"),
                rs.getLong("id_tipo"));
    }
	
	public Unidade findByNome(String nome) throws ClassNotFoundException, SQLException {
		try(Connection connection = ConnectionFactory.getConnection()){
			String sql = "SELECT * FROM T_VGS_UNIDADE WHERE nom_unidade = ?";
			try(PreparedStatement ps = connection.prepareStatement(sql)){
				ps.setString(1, nome);
				try(ResultSet rs = ps.executeQuery()){
					return rs.next() ? populaUnidade(rs) : null;
				}
			}
		}
	}

	public void cadastrar(Unidade unidade) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "INSERT INTO T_VGS_UNIDADE "
				+ "(nom_unidade, "
				+ "des_telefone_unidade, "
				+ "des_email_unidade,"
	            + "des_endereco_unidade, "
	            + "des_cep_unidade, "
	            + "des_senha, des_estado, "
	            + "des_cidade, "
	            + "des_CNES, "
	            + "id_tipo) "
	            + "VALUES (?,?,?,?,?,?,?,?,?,?)";
	    PreparedStatement ps = connection.prepareStatement(sql);
	    ps.setString(1, unidade.getNome());
	    ps.setString(2, unidade.getTelefone());
	    ps.setString(3, unidade.getEmail());
	    ps.setString(4, unidade.getEndereco());
	    ps.setString(5, unidade.getCep());
	    ps.setString(6, unidade.getSenha());
	    ps.setString(7, unidade.getEstado());
	    ps.setString(8, unidade.getCidade());
	    ps.setString(9, unidade.getCnes());
	    ps.setLong(10, unidade.getTipo());
		
	    ps.executeUpdate();
		connection.close();
	}

	public Unidade findById(Long id) throws ClassNotFoundException, SQLException {
		try(Connection connection = ConnectionFactory.getConnection()){
			String sql = "SELECT * FROM T_VGS_UNIDADE WHERE id_unidade = ?";
			try(PreparedStatement ps = connection.prepareStatement(sql)){
				ps.setLong(1, id);
				try(ResultSet rs = ps.executeQuery()){
					return rs.next() ? populaUnidade(rs) : null;
				}
			}
		}
	}

	public Unidade findByEmail(String email) throws ClassNotFoundException, SQLException {
		try(Connection connection = ConnectionFactory.getConnection()){
			String sql = "SELECT * FROM T_VGS_UNIDADE WHERE des_email_unidade = ?";
			try(PreparedStatement ps = connection.prepareStatement(sql)){
				ps.setString(1, email);
				try(ResultSet rs = ps.executeQuery()){
					return rs.next() ? populaUnidade(rs) : null;
				}
			}
		}
	}
	
}
