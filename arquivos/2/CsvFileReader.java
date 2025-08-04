import org.w3c.dom.ls.LSOutput;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class CsvFileReader {

    private static final String SEPARADOR = "------------------------";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("./funcionarios.csv"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                imprimirFuncionario(linha.split(","));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Leitura Concluída.");
    }

    private static void imprimirFuncionario(String[] linha) {
        System.out.println("Funcionário: " + linha[0]);
        System.out.println("Idade: " + linha[1]);
        System.out.println("Departamento: " + linha[2]);
        System.out.println("Salarial: " + linha[3]);
        System.out.println(SEPARADOR);
    }

}

