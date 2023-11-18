package br.com.fiap.vigiasaude.service;

import java.sql.SQLException;

import br.com.fiap.vigiasaude.data.UnidadeDao;
import br.com.fiap.vigiasaude.model.Unidade;

public class UnidadeService {
	
	UnidadeDao dao = new UnidadeDao();

	public boolean existeUnidade(Unidade unidade) {
		var unidadeEncontrado = buscarPorNome(unidade);
		return unidadeEncontrado != null
				&& unidadeEncontrado.getNome().equals(unidade.getNome());
				
	}
	
	public Unidade buscarPorNome(Unidade unidade) {
		try {
			Unidade unidadeEncontrado = dao.findByNome(unidade.getEmail());
			return unidadeEncontrado;
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}
		return null;
	}
	
	public Unidade buscarPorId(Long id) {
		try {
			Unidade unidadeEncontrado = dao.findById(id);
			return unidadeEncontrado;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean validaUnidade(Unidade unidade) {
			var hospitalEncontrado = buscarPorNome(unidade);
			return hospitalEncontrado.getEmail().equals(unidade.getEmail())
					&& hospitalEncontrado.getSenha().equals(unidade.getSenha());
	}

	public boolean cadastrar(Unidade unidade) {
		if (unidade.getNome().isEmpty()
				&& unidade.getEmail().isEmpty()
				&& unidade.getTelefone().isEmpty()
				&& unidade.getCep().isEmpty()) return false;
			try {
				dao.cadastrar(unidade);
				return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


}
