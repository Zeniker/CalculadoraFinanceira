package br.com.guilherme.calculadoraFinanceira.conta.dto;

import br.com.guilherme.calculadoraFinanceira.conta.Conta;
import br.com.guilherme.calculadoraFinanceira.geral.DefaultResponseDTO;

public class BuscarContaResponseDTO extends DefaultResponseDTO {

    private final ContaDTO conta;

    public BuscarContaResponseDTO(Exception e) {
        super(e);
        this.conta = null;
    }

    public BuscarContaResponseDTO(Conta conta) {
        super(StatusResposta.SUCESSO, "");
        if(conta != null){
            this.conta = new ContaDTO(conta);
        }else{
            this.conta = null;
        }
    }

    public ContaDTO getConta() {
        return conta;
    }
}
