package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.HashMap;
import java.util.Map;


public class SistemaDeGestaoDePedidos {


    // Logger SLF4j
    private static final Logger logger = LoggerFactory.getLogger(SistemaDeGestaoDePedidos.class);


    // Simulação de um banco de dados simples com mapa de pedidos
    private static final Map<Integer, Pedido> pedidos = new HashMap<>();


    public static void main(String[] args) {


        logger.info("Sistema de Gestão de Pedidos iniciado.");


        // Criando pedidos
        criarPedido(1, "Produto A", 100.00);
        criarPedido(2, "Produto B", 50.00);


        // Pagamento de pedidos
        pagarPedido(1, 100.00);
        pagarPedido(2, 60.00); // Pagamento incorreto


        // Cancelando pedidos
        cancelarPedido(1);
        cancelarPedido(3); // Pedido inexistente


        logger.info("Sistema de Gestão de Pedidos finalizado.");
    }


    // Função para criar um pedido
    private static void criarPedido(int id, String nomeProduto, double valor) {
        logger.info(String.format("Criando pedido: ID = %d - Produto = %s - Valor = %.1f", id, nomeProduto, valor));
        if (pedidos.containsKey(id)) {
            logger.warn(String.format("Pedido ID %d já existe!", id));
        } else {
            pedidos.put(id, new Pedido(id, nomeProduto, valor));
            logger.info(String.format("Pedido ID %d criado com sucesso!", id));
        }
    }


    // Função para pagar um pedido
    private static void pagarPedido(int id, double valorPago) {
        logger.info(String.format("Processando pagamento do pedido ID %d - Valor pago = %.1f", id, valorPago));
        
        Pedido pedido = pedidos.get(id);

        if (pedido.getValor() == valorPago) {
            pedido.setPago(true);
            logger.info(String.format("Pagamento do pedido ID %d realizado com sucesso!", id));
        } else {
            logger.error(String.format("Erro ao pagar: Valor pago %.1f é diferente do valor do pedido %.1f para o pedido ID %d.", valorPago, pedido.getValor(), id));
        }
    }


    // Função para cancelar um pedido
    private static void cancelarPedido(int id) {
        logger.info(String.format("Processando cancelamento do pedido ID %d", id));

        Pedido pedido = pedidos.get(id);

        if (pedido == null) {
            logger.error(String.format("Erro ao cancelar: Pedido ID %d não encontrado.", id));
        } else if (pedido.isPago()) {
            logger.warn(String.format("Não é possível cancelar o pedido ID %d pois já foi pago.", id));
        } else {
            pedidos.remove(id);
            logger.info(String.format("Pedido ID %d cancelado com sucesso!", id));
        }
    }
}
