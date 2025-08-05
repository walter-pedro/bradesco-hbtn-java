public class Comida {

    public Comida(String nome, double calorias, double preco) {
        this.nome = nome;
        this.calorias = calorias;
        this.preco = preco;
    }

    private String nome;
    private double calorias;
    private double preco;

    @Override
    public String toString() {
        return String.format("[%s] %f R$ %f", nome, calorias, preco);
    }
}
