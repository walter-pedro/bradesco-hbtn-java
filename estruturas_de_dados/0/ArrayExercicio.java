package estruturas_de_dados.a0;

import java.util.Scanner;


public class ArrayExercicio {


    public static void main(String[] args) {
        // Criando o scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Definindo o tamanho do array
        int tamanhoArray = 10;
        int[] numeros = new int[tamanhoArray];
        int soma = 0;
        int maiorNumero = Integer.MIN_VALUE;


        // Preenchendo o array com números fornecidos pelo usuário
        // Utilize scanner.nextInt(); para receber o numero digitado
        System.out.println("Digite 10 números inteiros:");

        for (int i = 0; i < 10; i++) {
            System.out.printf("Digite o número %d: ", i + 1);
            int numero = scanner.nextInt();
            numeros[i] = numero;
            soma += numero;
            maiorNumero = Math.max(maiorNumero, numero);
        }

        // Exibindo os resultados
        System.out.println("Conteúdo do array:");
        for (int numero: numeros) {
            System.out.printf("%d ", numero);
        }

        System.out.printf("\nSoma de todos os números: %d", soma);
        System.out.printf("\nMaior número no array: %d", maiorNumero);

        // Fechando o scanner
        scanner.close();
    }
}
