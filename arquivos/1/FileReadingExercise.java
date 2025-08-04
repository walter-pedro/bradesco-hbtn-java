import java.io.*;

public class FileReadingExercise {
    public static void main(String[] args) {
        String fileName = "./exemplo.txt";

        System.out.println("Conteúdo do arquivo 'exemplo.txt':\n");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro na leitura do arquivo: " + e.getMessage());
        }

        System.out.println("\nLeitura do arquivo concluída.");
    }
}
