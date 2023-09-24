package Api.policia.civil.de.mato.grosso.adapters.exceptions;

public class ErrosResponse {
    private String mensagem;

    public ErrosResponse(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
