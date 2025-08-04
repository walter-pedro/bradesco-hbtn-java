public class Produto {
    private int id;
    private String nome;
    private int quantidade;
    private double preco;


    // Construtor
    public Produto(int id, String nome, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }


    // Getters e Setters
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public double getPreco() {
        return preco;
    }


    public void setPreco(double preco) {
        this.preco = preco;
    }


    // Representação do Produto em String
    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Quantidade: " + quantidade + ", Preço: " + preco;
    }


    // Converte um Produto para linha CSV
    public String toCsv() {
        return id + "," + nome + "," + quantidade + "," + preco;
    }
}
