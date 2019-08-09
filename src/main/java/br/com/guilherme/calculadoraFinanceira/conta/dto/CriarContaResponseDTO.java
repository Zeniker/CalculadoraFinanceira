package br.com.guilherme.calculadoraFinanceira.conta.dto;

import br.com.guilherme.calculadoraFinanceira.geral.DefaultResponseDTO;

public class CriarContaResponseDTO extends DefaultResponseDTO {

    public CriarContaResponseDTO(Exception e) {
        super(e);
    }

    public CriarContaResponseDTO() {
        super("Conta criada com sucesso");
    }
}
