public class Pedido {

    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {

        double valorTotalPedido = 0;

        for (ItemPedido item: itens) {
            valorTotalPedido += item.getQuantidade() * item.getProduto().obterPrecoLiquido();
        }

        return valorTotalPedido - (this.percentualDesconto / 100 * valorTotalPedido);
    }
}
