import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Fila {

    public Fila(int tamanhoLista) {
        this.tamanhoLista = tamanhoLista;
    }

    private final LinkedList<Integer> itens = new LinkedList<Integer>();
    private final int tamanhoLista;


    // Método para o produtor colocar um item no buffer
    public synchronized void adicionar(int item) throws InterruptedException {
        // Se o buffer já tem um item, espera o consumidor consumi-lo
        while (itens.size() == tamanhoLista) {
            wait(); // Espera o consumidor consumir o item
        }

        // Coloca o item no buffer
        itens.add(item);
        System.out.println("Produtor produziu: " + item);

        // Notifica o consumidor que o item foi produzido
        notifyAll();
    }


    // Método para o consumidor retirar um item do buffer
    public synchronized int retirar() throws InterruptedException {
        // Se o buffer estiver vazio, espera o produtor produzir um item
        while (itens.isEmpty()) {
            wait(); // Espera o produtor produzir um item
        }

        // Retira o item do buffer
        int consumido = itens.removeFirst();
        System.out.println("Consumidor consumiu: " + consumido);

        // Notifica o produtor que o buffer está vazio
        notifyAll();

        return consumido;
    }
}
