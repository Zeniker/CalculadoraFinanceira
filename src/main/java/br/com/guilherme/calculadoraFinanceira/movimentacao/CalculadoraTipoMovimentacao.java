package br.com.guilherme.calculadoraFinanceira.movimentacao;

import java.math.BigDecimal;

public interface CalculadoraTipoMovimentacao {

    BigDecimal getSaldo(Movimentacao movimentacao);
}
