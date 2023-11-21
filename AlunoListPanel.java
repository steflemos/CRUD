import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class AlunoListPanel extends JPanel {
	private AppFrame frame;
	private JButton novaTarefaBtn;
	private JButton editarTarefaBtn;
	private JButton removerTarefaBtn;
	private JTable tabela;
	private AlunoTableModel tableModel;

	public AlunoListPanel(AppFrame appFrame) {
		frame = appFrame;

		setLayout(new BorderLayout(15, 15));

		criarComandosPanel();
		criarTabelaPanel();
	}

	public void recarregar() {
		tableModel.carregar(TarefaStorage.listar());
	}

	private void criarComandosPanel() {
		JPanel panel = new JPanel();
		FlowLayout layout = (FlowLayout) panel.getLayout();
		layout.setAlignment(FlowLayout.CENTER);

		novaTarefaBtn = new JButton("Adicionar");
		novaTarefaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarFormTarefas(null);
			}
		});
		panel.add(novaTarefaBtn);

		editarTarefaBtn = new JButton("Alterar");
		editarTarefaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarFormTarefas(tableModel.getCadastro(tabela.getSelectedRow()));
			}
		});
		panel.add(editarTarefaBtn);

		removerTarefaBtn = new JButton("Remover");
		removerTarefaBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Aluno tarefa = tableModel.getCadastro(tabela.getSelectedRow());
				int resposta = JOptionPane.showConfirmDialog(AlunoListPanel.this, "Deseja realmente remover?",
						AppFrame.titulo, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (resposta == JOptionPane.YES_OPTION) {
					TarefaStorage.remover(tarefa);
					tableModel.remover(tarefa);
				}
			}
		});
		panel.add(removerTarefaBtn);

		add(panel, BorderLayout.SOUTH);

		desabilitarBtns();
	}

	private void criarTabelaPanel() {

		tableModel = new AlunoTableModel(TarefaStorage.listar());
		tabela = new JTable(tableModel);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (tabela.getSelectedRow() >= 0) {
						habilitarBtns();
					} else {
						desabilitarBtns();
					}
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(tabela);
		add(scrollPane, BorderLayout.CENTER);

		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		tabela.getTableHeader().setReorderingAllowed(false);

		TableColumnModel columnModel = tabela.getColumnModel();
		TableColumn firstColumn = columnModel.getColumn(0);
		firstColumn.setPreferredWidth(150);
	}

	private void habilitarBtns() {
		editarTarefaBtn.setEnabled(true);
		removerTarefaBtn.setEnabled(true);
	}

	private void desabilitarBtns() {
		editarTarefaBtn.setEnabled(false);
		removerTarefaBtn.setEnabled(false);
	}
} // fim da classe TarefaListPanel