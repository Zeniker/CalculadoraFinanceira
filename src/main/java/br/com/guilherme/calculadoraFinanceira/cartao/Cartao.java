package br.com.guilherme.calculadoraFinanceira.cartao;

import br.com.guilherme.calculadoraFinanceira.conta.Conta;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Cartao {

    @GenericGenerator(name="cartao_gen" , strategy="increment")
    @GeneratedValue(generator="cartao_gen")
    @Id
    private Integer id;

    @ManyToOne
    private Conta conta;

    @Enumerated(EnumType.STRING)
    private CartaoBandeira bandeira;

    private String banco;

    private String apelido;

    public Integer getId() {
        return id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public CartaoBandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(CartaoBandeira bandeira) {
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

    public enum CartaoBandeira {
        MASTERCARD, VISA
    }
}
