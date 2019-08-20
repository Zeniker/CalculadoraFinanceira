package br.com.guilherme.calculadoraFinanceira.movimentacao;

import br.com.guilherme.calculadoraFinanceira.conta.Conta;
import br.com.guilherme.calculadoraFinanceira.conta.ContaService;
import br.com.guilherme.calculadoraFinanceira.movimentacao.dto.CriarMovimentacaoRequestDTO;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    private final ContaService contaService;
    private final MovimentacaoRepository movimentacaoRepository;

    public MovimentacaoService(ContaService contaService, MovimentacaoRepository movimentacaoRepository) {
        this.contaService = contaService;
        this.movimentacaoRepository = movimentacaoRepository;
    }

    public void criarMovimentacao(CriarMovimentacaoRequestDTO requestDTO){
        Conta conta = contaService.buscarContaPor(requestDTO.getIdConta());

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setConta(conta);
        movimentacao.setRecorrente(requestDTO.isRecorrente());
        movimentacao.setStatus(Movimentacao.StatusMovimentacao.ATIVO);
        movimentacao.setDataCobranca(requestDTO.getDataCobranca());
        movimentacao.setDataOperacao(requestDTO.getDataOperacao());
        movimentacao.setTipoMovimentacao(requestDTO.getTipoMovimentacao());
        movimentacao.setValor(requestDTO.getValor());

        movimentacaoRepository.save(movimentacao);
    }

    public Movimentacao buscarMovimentacao(Integer idMovimentacao){
        Optional<Movimentacao> movimentacaoOptional = movimentacaoRepository.findById(idMovimentacao);
        return movimentacaoOptional.orElse(null);
    }

    public List<Movimentacao> listarPorAnoMes(Integer idConta, Integer ano, Integer mes){
        Conta conta = contaService.buscarContaPor(idConta);

        return movimentacaoRepository.findByMovimentacaoByContaAndDataCobrancaMonthAndStatus(conta,
                Movimentacao.StatusMovimentacao.ATIVO,
                ano,
                mes);
    }

}
