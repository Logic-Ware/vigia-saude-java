package br.com.fiap.vigiasaude.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Unidade{
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String endereco;
	private String cep;
	private String estado;
	private String cidade;
	private String cnes;
	private Long tipo;

}
