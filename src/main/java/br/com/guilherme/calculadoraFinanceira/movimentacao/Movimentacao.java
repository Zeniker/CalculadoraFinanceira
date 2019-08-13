package br.com.guilherme.calculadoraFinanceira.movimentacao;

import br.com.guilherme.calculadoraFinanceira.cartao.Cartao;
import br.com.guilherme.calculadoraFinanceira.conta.Conta;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Movimentacao {

    @GenericGenerator(name="movimentacao_gen" , strategy="increment")
    @GeneratedValue(generator="movimentacao_gen")
    @Id
    private Integer id;

    @NotNull
    @ManyToOne
    private Conta conta;

    @ManyToOne
    private Cartao cartao;

    @ManyToOne
    private Movimentacao original;

    @NotNull
    private boolean recorrente;

    @NotNull
    private StatusMovimentacao status;

    @NotNull
    private LocalDate dataOperacao;

    @NotNull
    private LocalDate dataCobranca;

    @NotNull
    private BigDecimal valorMovimentacao;

    @NotNull
    private TipoMovimentacao tipoMovimentacao;

    public enum StatusMovimentacao {
        ATIVO, INATIVO, CANCELADO
    }

    public enum TipoMovimentacao {
        GASTO(new TipoMovimentacaoGasto()),
        GANHO(new TipoMovimentacaoGanho()),
        INVESTIMENTO(new TipoMovimentacaoInvestimento());

        private br.com.guilherme.calculadoraFinanceira.movimentacao.TipoMovimentacao objetoTipoMovimentacao;

        TipoMovimentacao(br.com.guilherme.calculadoraFinanceira.movimentacao.TipoMovimentacao objetoTipoMovimentacao){
            this.objetoTipoMovimentacao = objetoTipoMovimentacao;
        }

        public br.com.guilherme.calculadoraFinanceira.movimentacao.TipoMovimentacao getObjetoTipoMovimentacao(){
            return this.objetoTipoMovimentacao;
        }
    }

    public Integer getId() {
        return id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Movimentacao getOriginal() {
        return original;
    }

    public void setOriginal(Movimentacao original) {
        this.original = original;
    }

    public boolean isRecorrente() {
        return recorrente;
    }

    public void setRecorrente(boolean recorrente) {
        this.recorrente = recorrente;
    }

    public StatusMovimentacao getStatus() {
        return status;
    }

    public void setStatus(StatusMovimentacao status) {
        this.status = status;
    }

    public LocalDate getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(LocalDate dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public LocalDate getDataCobranca() {
        return dataCobranca;
    }

    public void setDataCobranca(LocalDate dataCobranca) {
        this.dataCobranca = dataCobranca;
    }

    public BigDecimal getValorMovimentacao() {
        return valorMovimentacao;
    }

    public void setValorMovimentacao(BigDecimal valorMovimentacao) {
        this.valorMovimentacao = valorMovimentacao;
    }

    public BigDecimal getSaldo(){
        return this.tipoMovimentacao.getObjetoTipoMovimentacao().getSaldo(this);
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
}
