package br.com.guilherme.calculadoraFinanceira.conta.dto;

import br.com.guilherme.calculadoraFinanceira.geral.DefaultResponseDTO;

import java.math.BigDecimal;

public class BuscarSaldoResponseDTO extends DefaultResponseDTO {

    private BigDecimal saldo;

    public BuscarSaldoResponseDTO(Exception e) {
        super(e);
        this.saldo = null;
    }

    public BuscarSaldoResponseDTO(BigDecimal saldo) {
        super(StatusResposta.SUCESSO, "");
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
