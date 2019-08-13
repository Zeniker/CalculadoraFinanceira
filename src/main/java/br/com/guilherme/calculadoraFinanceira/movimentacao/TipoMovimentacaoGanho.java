package br.com.guilherme.calculadoraFinanceira.movimentacao;

import java.math.BigDecimal;

public class TipoMovimentacaoGanho implements TipoMovimentacao {
    @Override
    public BigDecimal getSaldo(Movimentacao movimentacao) {
        return movimentacao.getValorMovimentacao();
    }
}
