public class Principal {
    public static void main(String[] args) {
        Contador contador = new Contador();

        ThreadContador thread1 = new ThreadContador(contador);
        ThreadContador thread2 = new ThreadContador(contador);

        thread1.run();
        thread2.run();

        System.out.printf("Valor final do contador: %d", contador.getContagem());
    }
}
