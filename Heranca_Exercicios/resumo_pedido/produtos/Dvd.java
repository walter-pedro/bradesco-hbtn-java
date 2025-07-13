package produtos;

public class Dvd extends Produto{

    private String diretor;
    private String genero;
    private int duracao;

    public Dvd(String titulo, int ano, String pais, double precoBruto, String diretor, String genero, int duracao) {
        super(titulo, ano, pais, precoBruto);
    }

    @Override
    public double obterPrecoLiquido() {
        return super.getPrecoBruto() * 1.2;
    }
}
