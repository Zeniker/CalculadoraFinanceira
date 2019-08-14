package br.com.guilherme.calculadoraFinanceira.conta;

import br.com.guilherme.calculadoraFinanceira.conta.dto.ContaDTO;
import br.com.guilherme.calculadoraFinanceira.movimentacao.MovimentacaoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Optional;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    private final MovimentacaoRepository movimentacaoRepository;

    public ContaService(ContaRepository contaRepository, MovimentacaoRepository movimentacaoRepository){
        this.contaRepository = contaRepository;
        this.movimentacaoRepository = movimentacaoRepository;
    }

    @Transactional
    public void criarConta(ContaDTO contaDTO){
        Conta conta = new Conta();
        conta.setNomePessoa(contaDTO.getNomePessoa());
        contaRepository.save(conta);
    }

    @Transactional
    public Conta buscarContaPor(Integer idConta){
        Optional<Conta> contaOptional = contaRepository.findById(idConta);
        return contaOptional.orElse(null);
    }

    @Transactional
    public void atualizarConta(Integer idConta, ContaDTO contaDTO) throws Exception{
        Optional<Conta> contaOptional = contaRepository.findById(idConta);
        Conta conta = contaOptional.orElseThrow(() -> new Exception("Conta não encontrada"));

        conta.setNomePessoa(contaDTO.getNomePessoa());
        contaRepository.save(conta);
    }

    @Transactional
    public void deletarConta(Integer idConta) throws Exception{
        Optional<Conta> contaOptional = contaRepository.findById(idConta);
        Conta conta = contaOptional.orElseThrow(() -> new Exception("Conta não encontrada"));

        contaRepository.delete(conta);
    }

    public BigDecimal buscarSaldoMesConta(Conta conta, Integer ano, Integer mes){
        CalculadoraSaldoConta calculadoraSaldoConta = new CalculadoraSaldoConta(movimentacaoRepository);
        YearMonth yearMonth = YearMonth.of(ano, mes);

        return calculadoraSaldoConta.calculaPorAnoMes(conta, yearMonth);
    }

    public BigDecimal buscarSaldoMesConta(Integer idConta, Integer ano, Integer mes) throws Exception{
        Optional<Conta> contaOptional = contaRepository.findById(idConta);
        Conta conta = contaOptional.orElseThrow(() -> new Exception("Conta não encontrada"));

        return this.buscarSaldoMesConta(conta, ano, mes);
    }
}
