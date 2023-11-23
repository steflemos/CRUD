import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class InitialFrame extends JFrame {
	public static final String titulo = "Matricula de alunos";
	
	private CardLayout layout;
	private JPanel cardsPane;

	private MatriculaListPanel alunoListPanel;
	private MatriculaFormPanel alunoFormPanel;

	public InitialFrame() {
		super(titulo);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		layout = new CardLayout();

		cardsPane = new JPanel();
		cardsPane.setLayout(layout);
		add(cardsPane);

		criarCards();
	}

	public void mostrar() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void mostrarListaTarefas() {
		alunoListPanel.recarregar();
		layout.show(cardsPane, MatriculaListPanel.class.getName());
	}
	
	public void mostrarFormTarefas(Matricula tarefa) {
		alunoFormPanel.setTarefa(tarefa);
		layout.show(cardsPane, MatriculaFormPanel.class.getName());
	}

	private void criarCards() {
		alunoListPanel = new MatriculaListPanel(this);
		cardsPane.add(alunoListPanel, MatriculaListPanel.class.getName());

		alunoFormPanel = new MatriculaFormPanel(this);
		cardsPane.add(alunoFormPanel, MatriculaFormPanel.class.getName());
	}
} // fim da classe InitialFrame
