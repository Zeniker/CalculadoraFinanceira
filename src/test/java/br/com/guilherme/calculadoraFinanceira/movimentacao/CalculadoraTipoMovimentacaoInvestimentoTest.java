package br.com.guilherme.calculadoraFinanceira.movimentacao;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CalculadoraTipoMovimentacaoInvestimentoTest {

    @Test
    public void getSaldo() {
        CalculadoraTipoMovimentacao calculadoraTipoMovimentacao = new CalculadoraTipoMovimentacaoInvestimento();

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setValor(BigDecimal.TEN);

        assertEquals(new BigDecimal("-10"), calculadoraTipoMovimentacao.getSaldo(movimentacao));
    }
}