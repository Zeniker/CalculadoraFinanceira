package br.com.guilherme.calculadoraFinanceira.conta.dto;

import br.com.guilherme.calculadoraFinanceira.geral.DefaultResponseDTO;

public class DeletarContaResponseDTO extends DefaultResponseDTO {

    public DeletarContaResponseDTO() {
        super("Conta deletada com sucesso");
    }

    public DeletarContaResponseDTO(Exception exception) {
        super(exception);
    }
}
