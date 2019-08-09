package br.com.guilherme.calculadoraFinanceira.conta.dto;

import br.com.guilherme.calculadoraFinanceira.conta.Conta;

import javax.validation.constraints.NotNull;

public class ContaDTO {

    private Integer id;

    @NotNull
    private String nomePessoa;

    public ContaDTO() {
    }

    public ContaDTO(Conta conta) {
        if (conta != null){
            this.id = conta.getId();
            this.nomePessoa = conta.getNomePessoa();
        }
    }

    public Integer getId() {
        return id;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }
}
