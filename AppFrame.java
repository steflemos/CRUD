import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class AppFrame extends JFrame {
	public static final String titulo = "TODO App";
	
	private CardLayout layout;
	private JPanel cardsPane;

	// private InicialPanel inicialPanel;
	// private TarefaListPanel tarefaListPanel;
	// private TarefaFormPanel tarefaFormPanel;

	public AppFrame() {
		super(titulo);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		layout = new CardLayout();

		cardsPane = new JPanel();
		cardsPane.setLayout(layout);
		add(cardsPane);

		// criarCards();
	}

	public void mostrar() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// public void mostrarListaTarefas() {
	// 	tarefaListPanel.recarregar();
	// 	layout.show(cardsPane, TarefaListPanel.class.getName());
	// }
	
	// public void mostrarFormTarefas(Tarefa tarefa) {
	// 	tarefaFormPanel.setTarefa(tarefa);
	// 	layout.show(cardsPane, TarefaFormPanel.class.getName());
	// }

	// private void criarCards() {
	// 	inicialPanel = new InicialPanel(this);
	// 	cardsPane.add(inicialPanel, InicialPanel.class.getName());

	// 	tarefaListPanel = new TarefaListPanel(this);
	// 	cardsPane.add(tarefaListPanel, TarefaListPanel.class.getName());

	// 	tarefaFormPanel = new TarefaFormPanel(this);
	// 	cardsPane.add(tarefaFormPanel, TarefaFormPanel.class.getName());
	// }
} // fim da classe AppFrame
