package br.com.guilherme.calculadoraFinanceira.conta;

import br.com.guilherme.calculadoraFinanceira.conta.dto.ContaDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository){
        this.contaRepository = contaRepository;
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
}
