package br.com.fiap.vigiasaude.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Unidade{
	@Exclude @JsonIgnore private Long id;
	private String nome;
	@Exclude @JsonIgnore private String email;
	@Exclude @JsonIgnore private String senha;
	private String telefone;
	private String endereco;
	private String cep;
	private String estado;
	private String cidade;
	@Exclude @JsonIgnore private String cnes;
	private Long tipo;

}
