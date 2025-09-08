public class Consumidor extends Thread {
    private Fila fila;


    public Consumidor(Fila fila) {
        this.fila = fila;
    }


    @Override
    public void run() {
        try {
            do {
                fila.retirar();  // O consumidor retira os itens da fila
                Thread.sleep(500);  // Simula o tempo para consumir um item
            } while (true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}