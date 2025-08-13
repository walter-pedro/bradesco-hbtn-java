public class Autor implements Comparable<Autor>{

    public Autor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    private String nome;
    private String sobrenome;

    @Override
    public String toString() {
        return String.format("%s %s", nome, sobrenome);
    }

    @Override
    public int compareTo(Autor a) {
        return toString().compareToIgnoreCase(a.toString());
    }
}
