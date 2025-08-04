import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Estoque {

    private Path path;

    public Estoque(String path) {
        this.path = Path.of(path);
        lerArquivo();
    }

    List<Produto> produtos = new ArrayList<Produto>();

    private void lerArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path.toFile()))) {
            Stream<String> linhas = reader.lines();
            this.produtos = linhas
                    .map(Estoque::mapToProduto)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void gravarArquivo() {
        try (FileWriter writer = new FileWriter(this.path.toFile())) {
            this.produtos.stream()
                    .map(p -> String.format("%d, %s, %.2f, %d", p.getId(), p.getNome(), p.getPreco(), p.getQuantidade()))
                    .forEach(linha -> {
                        try {
                            writer.write(linha + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Produto mapToProduto(String linha) {
        String[] campos = linha.split(",");
        return new Produto(Integer.parseInt(campos[0]),
                campos[1],
                Integer.parseInt(campos[3]),
                Double.parseDouble(campos[2]));
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        int id = this.produtos.stream()
                .mapToInt(Produto::getId)
                .max()
                .getAsInt() + 1;

        this.produtos.add(new Produto(id, nome, quantidade, preco));

        gravarArquivo();
    }


    public void excluirProduto(int idExcluir) {
        produtos =
                produtos.stream()
                        .filter(p -> p.getId() != idExcluir)
                        .collect(Collectors.toList());

        gravarArquivo();
    }

    public void exibirEstoque() {
        produtos.stream().forEach(System.out::println);
    }

    public void atualizarQuantidade(int idAtualizar, int novaQuantidade) {
        produtos.stream().filter(p -> p.getId() == idAtualizar).forEach(p -> p.setQuantidade(novaQuantidade));

        gravarArquivo();
    }
}
