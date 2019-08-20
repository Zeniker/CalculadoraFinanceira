package br.com.guilherme.calculadoraFinanceira.cartao.dto;

import br.com.guilherme.calculadoraFinanceira.cartao.Cartao;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CartaoDTO {

    private Integer id;

    @NotNull
    private Integer idConta;

    @NotNull
    @NotEmpty
    private String bandeira;

    private String banco;

    @NotNull
    @NotEmpty
    private String apelido;

    public CartaoDTO(){

    }

    public CartaoDTO(Cartao cartao){
        this.id = cartao.getId();
        this.idConta = cartao.getConta().getId();
        this.bandeira = cartao.getBandeira().toString();
        this.banco = cartao.getBanco();
        this.apelido = cartao.getApelido();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
}
