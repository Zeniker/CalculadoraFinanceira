package br.com.guilherme.calculadoraFinanceira.conta;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Conta {

    @GenericGenerator(name="conta_gen" , strategy="increment")
    @GeneratedValue(generator="conta_gen")
    @Id
    private Integer id;

    private String nomePessoa;

    public Integer getId() {
        return id;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }
}
