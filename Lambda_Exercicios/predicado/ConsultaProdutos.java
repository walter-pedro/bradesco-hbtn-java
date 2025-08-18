import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ConsultaProdutos {
    public static List<Produto> filtrar(List<Produto> listaProdutos, Predicate<Produto> predicate) {
        return listaProdutos.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
