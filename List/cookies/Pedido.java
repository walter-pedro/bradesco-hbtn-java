import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pedido {

    public Pedido() {
        this.cookies = new ArrayList<PedidoCookie>();
    }

    List<PedidoCookie> cookies;

    public void adicionarPedidoCookie(PedidoCookie pedidoCookie) {
        cookies.add(pedidoCookie);
    }

    public int obterTotalCaixas() {
        return cookies.stream().mapToInt(PedidoCookie::getQuantidadeCaixas).sum();
    }

    public int removerSabor(String sabor) {
        int quantidadeRemovidos = cookies.stream()
                .filter(c -> c.getSabor().equals(sabor))
                .mapToInt(PedidoCookie::getQuantidadeCaixas)
                .sum();
        cookies = cookies.stream()
                .filter(c -> !c.getSabor().equals(sabor))
                .collect(Collectors.toList());
        return quantidadeRemovidos;
    }

}
