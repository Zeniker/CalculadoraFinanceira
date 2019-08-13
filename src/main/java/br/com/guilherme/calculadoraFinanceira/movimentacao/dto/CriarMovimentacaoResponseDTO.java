package br.com.guilherme.calculadoraFinanceira.movimentacao.dto;

import br.com.guilherme.calculadoraFinanceira.geral.DefaultResponseDTO;

public class CriarMovimentacaoResponseDTO extends DefaultResponseDTO {
    public CriarMovimentacaoResponseDTO() {
        super("Movimentação criada com sucesso.");
    }

    public CriarMovimentacaoResponseDTO(Exception exception) {
        super(exception);
    }
}
