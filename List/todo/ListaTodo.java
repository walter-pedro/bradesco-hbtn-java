import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListaTodo {

    List<Tarefa> tarefas = new ArrayList<Tarefa>();

    public void adicionarTarefa(Tarefa tarefa) {
        if (tarefas.stream().anyMatch(t -> t.getIdentificador() == tarefa.getIdentificador())) {
            throw new RuntimeException(String.format("Tarefa com identificador %s ja existente na lista", tarefa.getIdentificador()));
        }

        tarefas.add(tarefa);
    }

    public boolean marcarTarefaFeita(int identificador) {
        return tarefas.stream()
                        .filter(t -> t.getIdentificador() == identificador)
                        .peek(t -> t.setEstahFeita(true))
                        .count() > 0;
    }

    public boolean desfazerTarefa(int identificador) {
        return tarefas.stream()
                .filter(t -> t.getIdentificador() == identificador)
                .peek(t -> t.setEstahFeita(false))
                .count() > 0;
    }

    public void desfazerTodas() {
        tarefas.forEach(t -> t.setEstahFeita(false));
    }

    public void fazerTodas() {
        tarefas.forEach(t -> t.setEstahFeita(true));
    }

    public void listarTarefas() {
        tarefas.forEach(System.out::println);
    }

}
