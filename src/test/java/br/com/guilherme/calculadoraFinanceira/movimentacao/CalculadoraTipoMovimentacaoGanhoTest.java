package br.com.guilherme.calculadoraFinanceira.movimentacao;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CalculadoraTipoMovimentacaoGanhoTest {

    @Test
    public void getSaldo() {
        CalculadoraTipoMovimentacao calculadoraTipoMovimentacao = new CalculadoraTipoMovimentacaoGanho();

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setValor(BigDecimal.TEN);

        assertEquals(BigDecimal.TEN, calculadoraTipoMovimentacao.getSaldo(movimentacao));
    }
}