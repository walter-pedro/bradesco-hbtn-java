import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class FileWritingExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            String entrada = "";
            do {
                System.out.print("Digite uma frase para entrar no arquivo: ");
                entrada = scanner.nextLine();
                if (entrada.equalsIgnoreCase("sair")) {
                    break;
                } else {
                    writer.write(entrada);
                    writer.newLine(); // adiciona quebra de linha
                }
            } while (!entrada.equalsIgnoreCase("sair"));

            System.out.println("Arquivo foi criado e o conteúdo salvo com sucesso.");

        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo:");
            e.printStackTrace();
        }

        scanner.close();
    }
}

