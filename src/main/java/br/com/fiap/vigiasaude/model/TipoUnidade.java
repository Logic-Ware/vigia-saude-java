package br.com.fiap.vigiasaude.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TipoUnidade {

	private Long id;
	private String descricao;
}
