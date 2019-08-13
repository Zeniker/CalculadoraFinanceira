package br.com.guilherme.calculadoraFinanceira.movimentacao.dto;

import br.com.guilherme.calculadoraFinanceira.movimentacao.Movimentacao;
import br.com.guilherme.calculadoraFinanceira.movimentacao.TipoMovimentacao;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class MovimentacaoDTO {

    private Integer idMovimentacao;

    private Integer idConta;

    private Integer idCartao;

    private MovimentacaoDTO original;

    private boolean recorrente;

    private Movimentacao.StatusMovimentacao status;

    private LocalDate dataOperacao;

    private LocalDate dataCobranca;

    private BigDecimal valor;

    private TipoMovimentacao tipoMovimentacao;

    public MovimentacaoDTO(Movimentacao movimentacao) {
        this.idMovimentacao = movimentacao.getId();
        this.idConta = movimentacao.getIdConta();
        this.idCartao = movimentacao.getIdCartao();
        this.recorrente = movimentacao.isRecorrente();
        this.status = movimentacao.getStatus();
        this.dataOperacao = movimentacao.getDataOperacao();
        this.dataCobranca = movimentacao.getDataCobranca();
        this.valor = movimentacao.getValor();
        this.tipoMovimentacao = movimentacao.getTipoMovimentacao();

        if(movimentacao.getOriginal() != null){
            this.original = new MovimentacaoDTO(movimentacao.getOriginal());
        }
    }

    public Integer getIdConta() {
        return idConta;
    }

    public Integer getIdCartao() {
        return idCartao;
    }

    public MovimentacaoDTO getOriginal() {
        return original;
    }

    public boolean isRecorrente() {
        return recorrente;
    }

    public Movimentacao.StatusMovimentacao getStatus() {
        return status;
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
