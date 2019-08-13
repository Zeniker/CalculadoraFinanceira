package br.com.guilherme.calculadoraFinanceira.conta;

import br.com.guilherme.calculadoraFinanceira.movimentacao.Movimentacao;
import br.com.guilherme.calculadoraFinanceira.movimentacao.MovimentacaoRepository;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;

/**
 * Calculadora de saldo de uma conta
 */
//@Service
public class CalculadoraSaldoMesConta {

    private final MovimentacaoRepository movimentacaoRepository;

    public CalculadoraSaldoMesConta(MovimentacaoRepository movimentacaoRepository){

        this.movimentacaoRepository = movimentacaoRepository;
    }

    /**
     * @param conta Conta que deve ser calculado o saldo
     * @param month Mês relativo do saldo
     * @return BigDecimal do saldo calculado
     */
    public BigDecimal calcula(Conta conta, Month month){
        List<Movimentacao> movimentacoes = movimentacaoRepository.getMovimentacaoByContaAndDataCobrancaMonthAndStatus(conta,
                month.getValue(),
                Movimentacao.StatusMovimentacao.ATIVO);

        return movimentacoes.stream().map(Movimentacao::getSaldo).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
