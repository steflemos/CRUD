import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AlunoTableModel extends AbstractTableModel {
	private List<Aluno> cadastros = new ArrayList<Aluno>();
	private String[] colunas = new String[] {"Nome", "Idade", "Email", "Endereço", "Cep", "Telefone", "Curso", "Observação" ,"Ativo" };

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
			Aluno cadastro = cadastros.get(rowIndex);

			switch (columnIndex) {
			case 0:
				value = Integer.toString(cadastro.getId());
				break;
			case 1:
				value = cadastro.getNome();
				break;
			case 2:
				value = cadastro.getIdade();
				break;
			case 3:
				value = cadastro.getEmail();
				break;
			case 4:
				value = cadastro.getEndereco();
				break;
			case 5:
				value = cadastro.getCep();
				break;
			case 6:
				value = cadastro.getTelefone();
				break;
			case 7:
				value = cadastro.getObservacao();
				break; /// descobrir como inserir getCurso aqui para o curso escolhido apareca na tabela inicial
			case 8:
				value = cadastro.getAtivo() ? "Ativo" : "Desativado";
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