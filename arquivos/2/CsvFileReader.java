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

        System.out.println("Funcionário: Nome");
        System.out.println("Idade: Idade");
        System.out.println("Departamento: Departamento");
        System.out.println("Salarial: Salarial");
        System.out.println(SEPARADOR);

        try (Stream<String> linhas = Files.lines(Path.of("./funcionarios.csv"))) {
            linhas.forEach(linha -> imprimirFuncionario(linha.split(",")));
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

