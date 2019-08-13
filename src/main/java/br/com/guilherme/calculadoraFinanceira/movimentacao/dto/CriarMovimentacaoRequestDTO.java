package br.com.guilherme.calculadoraFinanceira.movimentacao.dto;

import br.com.guilherme.calculadoraFinanceira.movimentacao.TipoMovimentacao;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CriarMovimentacaoRequestDTO {

    @NotNull
    private Integer idConta;

    private Integer idCartao;

    @NotNull
    private boolean recorrente;

    @NotNull
    private LocalDate dataOperacao;

    @NotNull
    private LocalDate dataCobranca;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private TipoMovimentacao tipoMovimentacao;

    public Integer getIdConta() {
        return idConta;
    }

    public Integer getIdCartao() {
        return idCartao;
    }

    public boolean isRecorrente() {
        return recorrente;
    }

    public LocalDate getDataOperacao() {
        return dataOperacao;
    }

    public LocalDate getDataCobranca() {
        return dataCobranca;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }
}
