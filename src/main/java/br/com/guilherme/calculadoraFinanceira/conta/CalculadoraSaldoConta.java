package br.com.guilherme.calculadoraFinanceira.conta;

import br.com.guilherme.calculadoraFinanceira.movimentacao.Movimentacao;
import br.com.guilherme.calculadoraFinanceira.movimentacao.MovimentacaoRepository;

import java.math.BigDecimal;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

/**
 * Calculadora de saldo de uma conta
 */
public class CalculadoraSaldoConta {

    private final MovimentacaoRepository movimentacaoRepository;

    public CalculadoraSaldoConta(MovimentacaoRepository movimentacaoRepository){

        this.movimentacaoRepository = movimentacaoRepository;
    }

    /**
     * @param conta Conta que deve ser calculado o saldo
     * @param anoMes ano e mês do saldo
     * @return BigDecimal do saldo calculado
     */
    public BigDecimal calculaPorAnoMes(Conta conta, YearMonth anoMes){
        List<Movimentacao> movimentacoes = movimentacaoRepository.getMovimentacaoByContaAndDataCobrancaMonthAndStatus(conta,
                Movimentacao.StatusMovimentacao.ATIVO,
                anoMes.getYear(),
                anoMes.getMonthValue());

        return movimentacoes.stream().map(Movimentacao::getSaldo).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
