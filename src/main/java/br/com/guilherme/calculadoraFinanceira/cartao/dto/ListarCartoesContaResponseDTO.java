package br.com.guilherme.calculadoraFinanceira.cartao.dto;

import br.com.guilherme.calculadoraFinanceira.cartao.ArrayListCartao;
import br.com.guilherme.calculadoraFinanceira.cartao.Cartao;
import br.com.guilherme.calculadoraFinanceira.geral.DefaultResponseDTO;

import java.util.List;

public class ListarCartoesContaResponseDTO extends DefaultResponseDTO {

    private List<CartaoDTO> cartoes;

    public ListarCartoesContaResponseDTO(Exception e) {
        super(e);
        this.cartoes = null;
    }

    public ListarCartoesContaResponseDTO(List<Cartao> cartoes) {
        super(StatusResposta.SUCESSO, "");
        this.cartoes = new ArrayListCartao(cartoes);
    }

    public List<CartaoDTO> getCartoes() {
        return cartoes;
    }
}
