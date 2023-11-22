package br.com.fiap.vigiasaude.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Medico{
	
	private Long id;
	private String nome;
	private String especialidade;
	private String crm;
	private String telefone; 
	private String email;
	private String senha;
	private Unidade unidade;
}
