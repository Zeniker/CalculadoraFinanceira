package br.com.guilherme.calculadoraFinanceira.movimentacao;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TipoMovimentacaoGanhoTest {

    @Test
    public void getSaldo() {
        TipoMovimentacao tipoMovimentacao = new TipoMovimentacaoGanho();

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setValorMovimentacao(BigDecimal.TEN);

        assertEquals(BigDecimal.TEN, tipoMovimentacao.getSaldo(movimentacao));
    }
}