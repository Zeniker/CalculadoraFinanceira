package br.com.guilherme.calculadoraFinanceira.conta;

import br.com.guilherme.calculadoraFinanceira.movimentacao.Movimentacao;
import br.com.guilherme.calculadoraFinanceira.movimentacao.MovimentacaoRepository;
import br.com.guilherme.calculadoraFinanceira.movimentacao.TipoMovimentacao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CalculadoraSaldoMesContaTest {

    private Conta conta;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Before
    public void setUp() throws Exception {
        conta = new Conta();
        conta.setNomePessoa("Jorge");

        contaRepository.save(conta);
    }

    private void incluiNovaMovimentacao(LocalDate data, BigDecimal valor){
        Movimentacao mov = new Movimentacao();
        mov.setConta(conta);
        mov.setRecorrente(false);
        mov.setStatus(Movimentacao.StatusMovimentacao.ATIVO);
        mov.setDataCobranca(data);
        mov.setDataOperacao(data);
        mov.setValor(valor);
        mov.setTipoMovimentacao(TipoMovimentacao.GANHO);

        movimentacaoRepository.save(mov);
    }


    @Test
    public void calculaSaldoMes() {
        incluiNovaMovimentacao(LocalDate.now(), new BigDecimal("150"));
        incluiNovaMovimentacao(LocalDate.now(), new BigDecimal("200"));
        incluiNovaMovimentacao(LocalDate.now().plusMonths(1), new BigDecimal("200"));
        incluiNovaMovimentacao(LocalDate.now().plusYears(1), new BigDecimal("1200"));

        CalculadoraSaldoConta calculadoraSaldoMesConta = new CalculadoraSaldoConta(movimentacaoRepository);
        BigDecimal saldo = calculadoraSaldoMesConta.calculaPorAnoMes(conta, YearMonth.now());

        assertEquals(new BigDecimal("350.00"), saldo);
    }

    @Test
    public void calculaSaldoMesSemMovimentacao() {
        CalculadoraSaldoConta calculadoraSaldoMesConta = new CalculadoraSaldoConta(movimentacaoRepository);
        BigDecimal saldo = calculadoraSaldoMesConta.calculaPorAnoMes(conta, YearMonth.now());

        assertEquals(BigDecimal.ZERO, saldo);
    }


}