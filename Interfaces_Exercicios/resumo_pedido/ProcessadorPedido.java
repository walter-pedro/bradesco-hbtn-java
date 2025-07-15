import provedores.ProvedorFrete;

public class ProcessadorPedido {

    public ProcessadorPedido(ProvedorFrete provedorFrete) {
        this.provedorFrete = provedorFrete;
    }

    private ProvedorFrete provedorFrete;

    public void processar(Pedido pedido) {
        pedido.setFrete(provedorFrete.calcularFrete(pedido.getPeso(), pedido.getTotal()));
    }
}
