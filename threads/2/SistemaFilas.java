public class SistemaFilas {

    public static void main(String[] args) {
        Fila fila = new Fila(10);

        Produtor produtor1 = new Produtor(fila);
        Produtor produtor2 = new Produtor(fila);

        Consumidor consumidor1 = new Consumidor(fila);
        Consumidor consumidor2 = new Consumidor(fila);

        produtor1.start();
        produtor2.start();
        consumidor1.start();
        consumidor2.start();

        long duracao = 20000; // 20 segundos

        try {
            Thread.sleep(duracao); // A thread principal espera
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0); // Encerra todas as threads e o programa
    }
}
