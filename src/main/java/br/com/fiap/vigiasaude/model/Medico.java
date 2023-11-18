package br.com.fiap.vigiasaude.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.ToString.Exclude;

@Data
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Medico{
	@Exclude
	@JsonIgnore
	private Long id;
	private String nome;
	private String especialidade;
	private String crm;
	private String telefone; 
	@Exclude
	@JsonIgnore
	private String email;
	@Exclude
	@JsonIgnore
	private String senha;
	private Unidade unidade;
}
