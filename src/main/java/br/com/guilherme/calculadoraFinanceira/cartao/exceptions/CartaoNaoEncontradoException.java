package br.com.guilherme.calculadoraFinanceira.cartao.exceptions;

public class CartaoNaoEncontradoException extends RuntimeException {

    public CartaoNaoEncontradoException() {
        super("Cartão não encontrado");
    }
}
