public class Tarefa {

    private String descricao;
    private boolean estahFeita;
    private int identificador;

    public Tarefa(String descricao, int identificador) {
        modificarDescricao(descricao);
        this.identificador = identificador;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isEstahFeita() {
        return estahFeita;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void modificarDescricao(String descricao) {
        if(descricao == null || descricao.isEmpty()) {
            throw new RuntimeException("Descricao de tarefa invalida");
        }
        this.descricao = descricao;
    }

    public void setEstahFeita(boolean estahFeita) {
        this.estahFeita = estahFeita;
    }

    @Override
    public String toString() {
        return String.format("[%s]  Id: %d - Descricao: %s",
                estahFeita ? "X": " ", identificador, descricao);
    }
}
