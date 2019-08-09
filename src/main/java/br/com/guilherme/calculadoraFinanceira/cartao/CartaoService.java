package br.com.guilherme.calculadoraFinanceira.cartao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    public Cartao getCartaoBy(Integer id){
        Optional<Cartao> cartao = cartaoRepository.findById(id);
        return cartao.orElse(null);
    }
}
