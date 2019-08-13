package br.com.guilherme.calculadoraFinanceira.movimentacao;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TipoMovimentacaoInvestimentoTest {

    @Test
    public void getSaldo() {
        TipoMovimentacao tipoMovimentacao = new TipoMovimentacaoInvestimento();

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setValorMovimentacao(BigDecimal.TEN);

        assertEquals(new BigDecimal("-10"), tipoMovimentacao.getSaldo(movimentacao));
    }
}