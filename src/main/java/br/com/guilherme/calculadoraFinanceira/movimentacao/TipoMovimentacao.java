package br.com.guilherme.calculadoraFinanceira.movimentacao;

import java.math.BigDecimal;

public interface TipoMovimentacao {

    BigDecimal getSaldo(Movimentacao movimentacao);
}
