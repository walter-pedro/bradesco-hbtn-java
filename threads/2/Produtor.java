import java.util.Random;

public class Produtor extends Thread {
    private Fila fila;

    public Produtor(Fila fila) {
        this.fila = fila;
    }


    @Override
    public void run() {
        Random random = new Random();
        try {
            do {
                fila.adicionar(random.nextInt(1, 100));  // O produtor coloca os itens no buffer
                Thread.sleep(1000);   // Simula o tempo para produzir um item
            } while (true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}