package br.com.guilherme.calculadoraFinanceira.cartao;

import br.com.guilherme.calculadoraFinanceira.cartao.dto.CartaoDTO;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCartao extends ArrayList<CartaoDTO> {

    public ArrayListCartao(List<Cartao> cartoes){
        cartoes.forEach(movimentacao -> this.add(new CartaoDTO(movimentacao)));
    }
}
