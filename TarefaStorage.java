

import java.util.ArrayList;
import java.util.List;

public class TarefaStorage {
	private static int incremento = 0;
	private static List<Aluno> tarefas = new ArrayList<>();

	public static void inserir(Aluno tarefa) {
		tarefa.setId(++incremento);
		tarefas.add(tarefa);
	}

	public static void atualizar(Aluno tarefa) {
		int i = tarefas.indexOf(tarefa);
		if (i >= 0) {
			tarefas.set(i, tarefa);
		}
	}

	public static void remover(Aluno tarefa) {
		tarefas.remove(tarefa);
	}

	public static List<Aluno> listar() {
		return tarefas;
	}
}