import java.util.HashMap;
import java.util.Map;

public class Armazem<T> implements Armazenavel<T> {

    private Map<String, T> itens = new HashMap<String, T>();

    @Override
    public void adicionarAoInventario(String nome, T t) {
        itens.put(nome, t);
    }

    @Override
    public T obterDoInventario(String nome) {
        return itens.get(nome);
    }
}
