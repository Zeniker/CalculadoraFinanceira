package br.com.guilherme.calculadoraFinanceira.conta.dto;

import br.com.guilherme.calculadoraFinanceira.geral.DefaultResponseDTO;

public class AtualizarContaResponseDTO extends DefaultResponseDTO {

    public AtualizarContaResponseDTO(Exception e) {
        super(e);
    }

    public AtualizarContaResponseDTO() {
        super("Conta atualizada com sucesso");
    }
}
