package br.com.guilherme.calculadoraFinanceira.movimentacao;

import br.com.guilherme.calculadoraFinanceira.movimentacao.dto.MovimentacaoDTO;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMovimentacao extends ArrayList<MovimentacaoDTO> {

    public ArrayListMovimentacao(List<Movimentacao> movimentacoes){
        movimentacoes.forEach(movimentacao -> this.add(new MovimentacaoDTO(movimentacao)));
    }
}
