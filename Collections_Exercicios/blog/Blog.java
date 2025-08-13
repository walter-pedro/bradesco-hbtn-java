import java.util.*;
import java.util.stream.Collectors;

public class Blog {

    public Blog() {
        postList = new ArrayList<Post>();
    }

    private List<Post> postList;

    public void adicionarPostagem(Post post) {
        postList.add(post);
    }

    public Set<String> obterTodosAutores() {
        return postList.stream()
                .map(Post::getAutor)
                .collect(Collectors.toCollection(TreeSet::new));

    }

    public Map<String, Integer> obterContagemPorCategoria() {
        return postList.stream()
                .collect(Collectors.groupingBy(Post::getCategoria, TreeMap::new, Collectors.summingInt(p -> 1)));
    }
}
