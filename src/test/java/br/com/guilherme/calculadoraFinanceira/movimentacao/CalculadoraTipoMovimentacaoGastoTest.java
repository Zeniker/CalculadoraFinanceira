package br.com.guilherme.calculadoraFinanceira.movimentacao;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CalculadoraTipoMovimentacaoGastoTest {

    @Test
    public void getSaldo() {
        CalculadoraTipoMovimentacao calculadoraTipoMovimentacao = new CalculadoraTipoMovimentacaoGasto();

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setValorMovimentacao(BigDecimal.TEN);

        assertEquals(new BigDecimal("-10"), calculadoraTipoMovimentacao.getSaldo(movimentacao));

    }
}