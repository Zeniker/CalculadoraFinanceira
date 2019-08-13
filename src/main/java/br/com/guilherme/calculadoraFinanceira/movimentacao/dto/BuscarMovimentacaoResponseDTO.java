package br.com.guilherme.calculadoraFinanceira.movimentacao.dto;

import br.com.guilherme.calculadoraFinanceira.geral.DefaultResponseDTO;
import br.com.guilherme.calculadoraFinanceira.movimentacao.Movimentacao;

public class BuscarMovimentacaoResponseDTO extends DefaultResponseDTO {

    private MovimentacaoDTO movimentacao;

    public BuscarMovimentacaoResponseDTO(Movimentacao movimentacao) {
        super("");
        if(movimentacao != null){
            this.movimentacao = new MovimentacaoDTO(movimentacao);
        }
    }

    public BuscarMovimentacaoResponseDTO(Exception exception) {
        super(exception);
    }

    public MovimentacaoDTO getMovimentacao() {
        return movimentacao;
    }
}
