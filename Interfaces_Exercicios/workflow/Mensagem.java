public class Mensagem {

    public Mensagem(String texto, TipoMensagem tipoMensagem) {
        this.texto = texto;
        this.tipoMensagem = tipoMensagem;
    }

    private String texto;
    private TipoMensagem tipoMensagem;

    public String getTexto() {
        return texto;
    }

    public TipoMensagem getTipoMensagem() {
        return tipoMensagem;
    }
}
