import java.util.List;

public class ManipularArrayNumeros {

    public static int buscarPosicaoNumero(List<Integer> lista, int numero) {
        return lista.indexOf(numero);
    }

    public static void adicionarNumero(List<Integer> lista, int numero) {
        if (buscarPosicaoNumero(lista, numero) >= 0) {
            throw new RuntimeException("Numero jah contido na lista");
        }

        lista.add(numero);
    }

    public static void removerNumero(List<Integer> lista, int numero) {
        int indice = buscarPosicaoNumero(lista, numero);

        if (indice < 0) {
            throw new RuntimeException("Numero nao encontrado na lista");
        }

        lista.remove(indice);
    }

    public static void substituirNumero(List<Integer> lista, int numeroSubstituir, int numeroSubstituto) {
        int indice = buscarPosicaoNumero(lista, numeroSubstituir);

        if (indice < 0) {
            lista.add(numeroSubstituto);
        } else {
            lista.set(indice, numeroSubstituto);
        }
    }
}
