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
        System.out.println("------- RESUMO PEDIDO -------");

        for (ItemPedido item: itens) {
            System.out.println(
                    String.format("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f",
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

        System.out.println("----------------------------");
        System.out.println(String.format("DESCONTO: %.2f", valorDesconto));
        System.out.println(String.format("TOTAL PRODUTOS: %.2f", valorTotalProdutos));
        System.out.println("----------------------------");
        System.out.println(String.format("TOTAL PEDIDO: %.2f", calcularTotal()));
        System.out.println("----------------------------");
    }
}
