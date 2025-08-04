import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestaoAlunos {

    List<Aluno> alunos = new ArrayList<Aluno>();

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    private void excluirAluno(Aluno aluno) {
        alunos = alunos.stream().filter(a -> !a.getNome().equals(aluno.getNome())).collect(Collectors.toList())
    }

    private void buscarAluno(Aluno aluno) {
        alunos.stream().filter(a -> a.getNome().equals(aluno.getNome())).forEach(System.out::println);
    }

    private void listarAlunos(Aluno aluno) {
        alunos.forEach(System.out::println);
    }
}
