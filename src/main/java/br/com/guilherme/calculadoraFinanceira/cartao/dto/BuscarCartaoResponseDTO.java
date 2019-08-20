package br.com.guilherme.calculadoraFinanceira.cartao.dto;

import br.com.guilherme.calculadoraFinanceira.cartao.Cartao;
import br.com.guilherme.calculadoraFinanceira.geral.DefaultResponseDTO;

public class BuscarCartaoResponseDTO extends DefaultResponseDTO {

    private CartaoDTO cartao;

    public BuscarCartaoResponseDTO(Exception e) {
        super(e);
        this.cartao = null;
    }

    public BuscarCartaoResponseDTO(Cartao cartao) {
        super(StatusResposta.SUCESSO, "");
        if(cartao != null){
            this.cartao = new CartaoDTO(cartao);
        }else{
            this.cartao = null;
        }
    }

    public CartaoDTO getCartao() {
        return cartao;
    }
}
