package br.com.guilherme.calculadoraFinanceira.conta.exceptions;

public class ContaNaoEncontradaException extends RuntimeException{
    public ContaNaoEncontradaException() {
        super("Conta não encontrada");
    }
}
