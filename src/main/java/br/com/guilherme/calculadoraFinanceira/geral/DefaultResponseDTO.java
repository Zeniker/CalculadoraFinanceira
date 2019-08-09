package br.com.guilherme.calculadoraFinanceira.geral;

public abstract class DefaultResponseDTO {

    private StatusResposta status;
    private String mensagem;

    public DefaultResponseDTO(StatusResposta status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public DefaultResponseDTO(String mensagem) {
        this.status = StatusResposta.SUCESSO;
        this.mensagem = mensagem;
    }

    public DefaultResponseDTO(Exception exception) {
        this.status = StatusResposta.ERRO;
        this.mensagem = exception.getMessage();
    }

    public enum StatusResposta{
        ERRO, SUCESSO;
    }

    public StatusResposta getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }
}
