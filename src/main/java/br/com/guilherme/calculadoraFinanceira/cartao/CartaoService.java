package br.com.guilherme.calculadoraFinanceira.cartao;

import br.com.guilherme.calculadoraFinanceira.cartao.dto.CartaoDTO;
import br.com.guilherme.calculadoraFinanceira.cartao.exceptions.CartaoNaoEncontradoException;
import br.com.guilherme.calculadoraFinanceira.conta.Conta;
import br.com.guilherme.calculadoraFinanceira.conta.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaoService {

    private final CartaoRepository cartaoRepository;
    private final ContaService contaService;

    public CartaoService(CartaoRepository cartaoRepository, ContaService contaService){

        this.cartaoRepository = cartaoRepository;
        this.contaService = contaService;
    }

    public void criarCartao(CartaoDTO cartaoDTO){
        Conta conta = contaService.buscarContaPor(cartaoDTO.getIdConta());

        Cartao cartao = new Cartao();
        cartao.setConta(conta);
        cartao.setBandeira(Cartao.CartaoBandeira.valueOf(cartaoDTO.getBandeira()));
        cartao.setApelido(cartaoDTO.getApelido());
        cartao.setBanco(cartaoDTO.getBanco());

        cartaoRepository.save(cartao);
    }

    public Cartao buscarCartaoPor(Integer id){
        Optional<Cartao> cartao = cartaoRepository.findById(id);
        return cartao.orElseThrow(CartaoNaoEncontradoException::new);
    }

    public List<Cartao> listaCartoesPor(Integer idConta){
        Conta conta = contaService.buscarContaPor(idConta);
        return cartaoRepository.findByConta(conta);
    }
}
