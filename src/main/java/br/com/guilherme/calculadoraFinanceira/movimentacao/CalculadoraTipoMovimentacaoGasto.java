package br.com.guilherme.calculadoraFinanceira.movimentacao;

import java.math.BigDecimal;

public class CalculadoraTipoMovimentacaoGasto implements CalculadoraTipoMovimentacao {
    @Override
    public BigDecimal getSaldo(Movimentacao movimentacao) {
        return movimentacao.getValorMovimentacao().negate();
    }
}
