import java.util.ArrayList;
import java.util.List;

public class Biblioteca<T> extends Midia{

    private List<Midia> listaMidias = new ArrayList<Midia>();

    public void adicionarMidia(Midia midia) {
        listaMidias.add(midia);
    }

    public List<Midia> obterListaMidias() {
        return listaMidias;
    }

}
