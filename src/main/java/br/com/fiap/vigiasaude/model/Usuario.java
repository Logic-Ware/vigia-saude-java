package br.com.fiap.vigiasaude.model;

public record Usuario(
		Long id,
		String nome,
		String email,
		String senha,
		String telefone ) {}
