package br.com.guilherme.calculadoraFinanceira.cartao.dto;

import br.com.guilherme.calculadoraFinanceira.geral.DefaultResponseDTO;

public class CriarCartaoResponseDTO extends DefaultResponseDTO {

    public CriarCartaoResponseDTO(Exception e) {
        super(e);
    }

    public CriarCartaoResponseDTO() {
        super("Cartão criado com sucesso");
    }
}
