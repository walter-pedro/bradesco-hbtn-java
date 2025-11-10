import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class ProcessamentoDePagamentos {


    // Logger SLF4j
    private static final Logger logger = LoggerFactory.getLogger(ProcessamentoDePagamentos.class);


    public static void main(String[] args) throws InterruptedException {


        List<String> listaPagamentos = Arrays.asList("Falha", "Sucesso", "Sucesso", "Falha", "Pendente");

        for (int i = 0; i < listaPagamentos.size(); i++) {
            logger.info(String.format("Iniciando o processamento do pagamento %d", i+1));
            Thread.sleep(1000);

            switch(listaPagamentos.get(i)) {
                case "Sucesso": {
                    logger.info(String.format("Pagamento %d processado com sucesso.", i+1));
                    break;
                }
                case "Falha": {
                    logger.error(String.format("Erro ao processar o pagamento %d: Falha na transação.", i+1));
                    break;
                }
                case "Pendente": {
                    logger.warn(String.format("Pagamento %d está pendente. Aguardando confirmação.", i+1));
                    break;
                }
            }

        }

        logger.info(String.format("Processamento de pagamentos concluído."));
    }
}