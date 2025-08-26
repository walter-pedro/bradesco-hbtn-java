import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Consulta {

    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        return pedido.getProdutos()
                .stream()
                .filter(p -> p.getCategoria().equals(CategoriaProduto.LIVRO))
                .collect(Collectors.toList());
    }

    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        Optional<Produto> produtoMaisCaro = produtos.stream().max(Comparator.comparingDouble(Produto::getPreco));

        return produtoMaisCaro.orElseGet(Produto::new);

    }
}
