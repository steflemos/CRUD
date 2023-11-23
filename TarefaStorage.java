

import java.util.ArrayList;
import java.util.List;

public class TarefaStorage {
	private static int incremento = 0;
	private static List<Matricula> tarefas = new ArrayList<>();

	public static void inserir(Matricula tarefa) {
		tarefa.setId(++incremento);
		tarefas.add(tarefa);
	}

	public static void atualizar(Matricula tarefa) {
		int i = tarefas.indexOf(tarefa);
		if (i >= 0) {
			tarefas.set(i, tarefa);
		}
	}

	public static void remover(Matricula tarefa) {
		tarefas.remove(tarefa);
	}

	public static List<Matricula> listar() {
		return tarefas;
	}
}