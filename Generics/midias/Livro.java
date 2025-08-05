public class Livro extends Midia {

    public Livro(String nome, int edicao) {
        super(nome);
        this.edicao = edicao;
    }

    private int edicao;

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

}
