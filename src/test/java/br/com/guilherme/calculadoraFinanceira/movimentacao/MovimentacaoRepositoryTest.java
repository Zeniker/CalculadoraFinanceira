package br.com.guilherme.calculadoraFinanceira.movimentacao;

import br.com.guilherme.calculadoraFinanceira.conta.Conta;
import br.com.guilherme.calculadoraFinanceira.conta.ContaRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MovimentacaoRepositoryTest {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    private Conta conta;

    @Before
    public void setUp() throws Exception {
        conta = new Conta();
        conta.setNomePessoa("Guilherme");

        contaRepository.save(conta);
    }

    private Movimentacao criaMovimentacao(Movimentacao.StatusMovimentacao status, LocalDate data){
        Movimentacao mov = new Movimentacao();
        mov.setConta(conta);
        mov.setRecorrente(false);
        mov.setStatus(status);
        mov.setDataCobranca(data);
        mov.setDataOperacao(data);
        mov.setValorMovimentacao(BigDecimal.ONE);

        return mov;
    }

    @Test
    public void deveRetornarMovimentacoesAtivasNoMes() {
        List<Integer> listaIds = new ArrayList<>();

        Movimentacao mov = criaMovimentacao(Movimentacao.StatusMovimentacao.ATIVO, LocalDate.now());
        movimentacaoRepository.save(mov);
        listaIds.add(mov.getId());

        mov = criaMovimentacao(Movimentacao.StatusMovimentacao.ATIVO, LocalDate.now());
        movimentacaoRepository.save(mov);
        listaIds.add(mov.getId());

        mov = criaMovimentacao(Movimentacao.StatusMovimentacao.INATIVO, LocalDate.now());
        movimentacaoRepository.save(mov);

        mov = criaMovimentacao(Movimentacao.StatusMovimentacao.INATIVO, LocalDate.now().plusMonths(1));
        movimentacaoRepository.save(mov);


        List<Movimentacao> movimentacaoList = movimentacaoRepository.getMovimentacaoByContaAndDataCobrancaMonthAndStatus(conta,
                LocalDate.now().getMonth().getValue(),
                Movimentacao.StatusMovimentacao.ATIVO);

        assertEquals(2, movimentacaoList.size());
        assertTrue(listaIds.contains(movimentacaoList.get(0).getId()));
        assertTrue(listaIds.contains(movimentacaoList.get(1).getId()));
    }
}