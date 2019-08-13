package br.com.guilherme.calculadoraFinanceira.movimentacao;

public enum TipoMovimentacao {
    GASTO(new CalculadoraTipoMovimentacaoGasto()),
    GANHO(new CalculadoraTipoMovimentacaoGanho()),
    INVESTIMENTO(new CalculadoraTipoMovimentacaoInvestimento());

    private CalculadoraTipoMovimentacao calculadoraTipoMovimentacao;

    TipoMovimentacao(CalculadoraTipoMovimentacao calculadoraTipoMovimentacao){
        this.calculadoraTipoMovimentacao = calculadoraTipoMovimentacao;
    }

    public CalculadoraTipoMovimentacao getCalculadoraTipoMovimentacao(){
        return this.calculadoraTipoMovimentacao;
    }
}
