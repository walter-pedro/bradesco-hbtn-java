public class Pedido {

    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {

        double valorTotalProdutos = getValorTotalProdutos();

        return valorTotalProdutos - getValorDesconto(valorTotalProdutos);
    }

    private double getValorTotalProdutos() {
        double valorTotalProdutos = 0;

        for (ItemPedido item: itens) {
            valorTotalProdutos += item.getQuantidade() * item.getProduto().obterPrecoLiquido();
        }
        return valorTotalProdutos;
    }

    private double getValorDesconto (double valorTotalPedido) {
        return this.percentualDesconto / 100 * valorTotalPedido;
    }

    public void apresentarResumoPedido() {
        StringBuilder stringBuilder = new StringBuilder(
                "------- RESUMO PEDIDO -------\n"
        );

        for (ItemPedido item: itens) {
            stringBuilder.append(
                    String.format("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                            item.getProduto().getClass().getSimpleName(),
                            item.getProduto().getTitulo(),
                            item.getProduto().obterPrecoLiquido(),
                            item.getQuantidade(),
                            item.getQuantidade() * item.getProduto().obterPrecoLiquido()
                            )
            );
        }

        double valorTotalProdutos = getValorTotalProdutos();
        double valorDesconto = getValorDesconto(valorTotalProdutos);

        stringBuilder.append("----------------------------\n");
        stringBuilder.append(String.format("DESCONTO: %.2f\n", valorDesconto));
        stringBuilder.append(String.format("TOTAL PRODUTOS: %.2f\n", valorTotalProdutos));
        stringBuilder.append("----------------------------\n");
        stringBuilder.append(String.format("TOTAL PEDIDO: %.2f\n", calcularTotal()));
        stringBuilder.append("----------------------------\n");

        System.out.println(stringBuilder.toString());
    }
}
