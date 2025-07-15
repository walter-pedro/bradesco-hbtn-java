public class PersonagemGame {

    public PersonagemGame(int saudeAtual, String nome) {
        setSaudeAtual(saudeAtual);
        this.nome = nome;
    }

    private int saudeAtual;
    private String nome;
    private String status;

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;
        if (this.saudeAtual > 0) {
            this.status = "vivo";
        } else {
            this.status = "morto";
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public String getStatus() {
        return status;
    }

    public void tomarDano(int quantidadeDano) {
        if (this.saudeAtual - quantidadeDano < 0) {
            setSaudeAtual(0);
        } else {
            setSaudeAtual(this.saudeAtual - quantidadeDano);
        }
    }

    public void receberCura(int quantidadeDeCura) {
        if (this.saudeAtual + quantidadeDeCura > 100) {
            setSaudeAtual(100);
        } else {
            setSaudeAtual(this.saudeAtual + quantidadeDeCura);
        }
    }
}
