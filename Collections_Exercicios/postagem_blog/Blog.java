import java.util.*;
import java.util.stream.Collectors;

public class Blog {

    public Blog() {
        postList = new ArrayList<Post>();
    }

    List<Post> postList;

    public void adicionarPostagem(Post post) {
        if (postList.stream()
                .anyMatch(p -> p.compareTo(post) == 0)) {
            throw new IllegalArgumentException("Postagem jah existente");
        }
        postList.add(post);
    }

    public Set<Autor> obterTodosAutores() {
        return postList.stream()
                .map(Post::getAutor)
                .collect(Collectors.toCollection(TreeSet::new));

    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        return postList.stream()
                .collect(Collectors.groupingBy(Post::getCategoria, LinkedHashMap::new, Collectors.summingInt(p -> 1)));
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        postList.sort(Comparator.comparing(Post::getTitulo));

        return postList.stream()
                .filter(p -> p.getAutor().toString().equals(autor.toString()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        postList.sort(Comparator.comparing(Post::getTitulo));

        return postList.stream()
                .filter(p -> p.getCategoria() == categoria)
                .collect(Collectors.toCollection(LinkedHashSet::new));

    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Set<Categorias> categorias = postList.stream().map(Post::getCategoria).collect(Collectors.toSet());

        Map<Categorias, Set<Post>> map = new TreeMap<>();

        for (Categorias categoria: categorias) {
            map.put(categoria, obterPostsPorCategoria(categoria));
        }

        return map;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {

        Map<Autor, Set<Post>> map = new TreeMap<>();

        for (Autor autor: obterTodosAutores()) {
            map.put(autor, obterPostsPorAutor(autor));
        }

        return map;
    }

}
