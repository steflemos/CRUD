import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AlunoTableModel extends AbstractTableModel {
	private List<Aluno> cadastros = new ArrayList<Aluno>();
	private String[] colunas = new String[] { "Id", "Nome", "Idade", "Email", "Endereco", "Cep", "Telefone", "Observacao", "Ativo" };

	public AlunoTableModel(List<Aluno> cadastros) {
		this.cadastros = cadastros;
	}

	@Override
	public int getRowCount() {
		return cadastros.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String columnName = null;

		if (columnIndex >= 0 && columnIndex < colunas.length) {
			columnName = colunas[columnIndex];
		}
		return columnName;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String value = null;

		if (rowIndex >= 0 && rowIndex < cadastros.size()) {
			Aluno tarefa = cadastros.get(rowIndex);

			switch (columnIndex) {
			case 0:
				value = Integer.toString(tarefa.getId());
				break;
			case 1:
				value = tarefa.getNome();
				break;
			case 2:
				value = tarefa.getIdade();
				break;
			case 3:
				value = tarefa.getEmail();
				break;
			case 4:
				value = tarefa.getEndereco();
				break;
			case 5:
				value = tarefa.getCep();
				break;
			case 6:
				value = tarefa.getTelefone();
				break;
			case 7:
				value = tarefa.getObservacao();
				break;
			case 8:
				value = tarefa.getStatus();
				break;
			default:
				System.err.printf("[ERRO] Índice de coluna inválido: %d\n", columnIndex);
			}
		}

		return value;
	}

	public Aluno getCadastro(int rowIndex) {
		Aluno cadastro = null;

		if (rowIndex >= 0 && rowIndex < cadastros.size()) {
			cadastro = cadastros.get(rowIndex);
		}

		return cadastro;
	}

	public void carregar(List<Aluno> cadastros) {
		this.cadastros = cadastros;
		fireTableDataChanged();
	}

	public void remover(Aluno tarefa) {
		cadastros.remove(tarefa);
		fireTableDataChanged();
	}

} // fim da classe TarefaTabelaModel