package br.com.guilherme.calculadoraFinanceira.movimentacao;

import java.math.BigDecimal;

public class CalculadoraTipoMovimentacaoInvestimento implements CalculadoraTipoMovimentacao {
    @Override
    public BigDecimal getSaldo(Movimentacao movimentacao) {
        return movimentacao.getValor().negate();
    }
}
