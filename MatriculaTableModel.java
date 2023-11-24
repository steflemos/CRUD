import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class MatriculaTableModel extends AbstractTableModel {
	private List<Matricula> cadastros = new ArrayList<Matricula>();
	private String[] colunas = new String[] { "Id", "Nome", "Idade", "Email", "Endereço", "Cep", "Telefone", "Curso",
			"Observação", "Ativo" };

	public MatriculaTableModel(List<Matricula> cadastros) {
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
			Matricula cadastro = cadastros.get(rowIndex);

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
					value = (String) cadastro.getCurso();
					break;
				case 8:
					value = cadastro.getObservacao();
					break;
				case 9:
					value = cadastro.getAtivo() ? "Ativo" : "Desativado";
					break;
				default:
					System.err.printf("[ERRO] Índice de coluna inválido: %d\n", columnIndex);
			}
		}

		return value;
	}

	public Matricula getCadastro(int rowIndex) {
		Matricula cadastro = null;

		if (rowIndex >= 0 && rowIndex < cadastros.size()) {
			cadastro = cadastros.get(rowIndex);
		}

		return cadastro;
	}

	public void carregar(List<Matricula> cadastros) {
		this.cadastros = cadastros;
		fireTableDataChanged();
	}

	public void remover(Matricula tarefa) {
		cadastros.remove(tarefa);
		fireTableDataChanged();
	}

} // fim da classe MatriculaTabelaModel