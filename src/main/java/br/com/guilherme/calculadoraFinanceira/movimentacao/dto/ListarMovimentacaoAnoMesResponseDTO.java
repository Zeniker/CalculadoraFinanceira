package br.com.guilherme.calculadoraFinanceira.movimentacao.dto;

import br.com.guilherme.calculadoraFinanceira.geral.DefaultResponseDTO;
import br.com.guilherme.calculadoraFinanceira.movimentacao.ArrayListMovimentacao;
import br.com.guilherme.calculadoraFinanceira.movimentacao.Movimentacao;

import java.util.List;

public class ListarMovimentacaoAnoMesResponseDTO extends DefaultResponseDTO {

    private List<MovimentacaoDTO> movimentacoes;

    public ListarMovimentacaoAnoMesResponseDTO(Exception e) {
        super(e);
        this.movimentacoes = null;
    }

    public ListarMovimentacaoAnoMesResponseDTO(List<Movimentacao> movimentacoes) {
        super(StatusResposta.SUCESSO, "");
        this.movimentacoes = new ArrayListMovimentacao(movimentacoes);
    }

    public List<MovimentacaoDTO> getMovimentacoes() {
        return movimentacoes;
    }
}
