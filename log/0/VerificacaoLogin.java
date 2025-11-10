import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class VerificacaoLogin {


    // Inicialização do logger
    private static final java.util.logging.Logger logger = LoggerFactory.getLogger(VerificacaoLogin.class);


    public static void main(String[] args) {
        // Simulação de entradas do usuário
        String usuarioCorreto = "admin";
        String senhaCorreta = "12345";


        // Tentativas de login
        realizarLogin("admin", "12345", usuarioCorreto, senhaCorreta); // Login correto
        realizarLogin("admin", "senhaErrada", usuarioCorreto, senhaCorreta); // Senha incorreta
        realizarLogin("usuarioDesconhecido", "12345", usuarioCorreto, senhaCorreta); // Usuário desconhecido
    }


    public static void realizarLogin(String usuario, String senha, String usuarioCorreto, String senhaCorreta) {
        logger.info(String.format("Tentativa de login com o usuário: %s", usuario));

        if (!usuario.equals(usuarioCorreto)) {
            logger.warn(String.format("Usuário %s não encontrado!", usuario));
        } else if (!senha.equals(senhaCorreta)) {
            logger.error(String.format("Senha incorreta para o usuário: %s", usuario));
        }

        logger.info(String.format("Login bem-sucedido para o usuário: %s", usuario));
    }
}