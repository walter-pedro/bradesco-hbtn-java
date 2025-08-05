public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes =new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    // implementar o método de buscaBinaria
    public void buscaBinaria(String nome){
        boolean encontrado = false;

        System.out.printf("Procurando pelo nome: \"%s\"\n", nome);

        int indiceInicial = 0;
        int indiceFinal = nomes.length - 1;

        while (indiceInicial <= indiceFinal) {
            int indice = (indiceInicial + indiceFinal) / 2;
            int resultado = nomes[indice].compareTo(nome);

            System.out.printf("Passando pelo indice: %d\n", indice);

            if (resultado == 0) {
                System.out.printf("Nome %s encontrado na posição %d\n", nome, indice);
                encontrado = true;
                break;
            } else if (resultado < 0) {
                indiceInicial = indice + 1;
            } else {
                indiceFinal = indice - 1;
            }
        }

        if (!encontrado) {
            throw new IllegalArgumentException(String.format("O nome %s não se encontra no array de nomes", nome));
        }
    }
}
