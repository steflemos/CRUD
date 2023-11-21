import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class AppFrame extends JFrame {
	public static final String titulo = "Matricula de alunos";
	
	private CardLayout layout;
	private JPanel cardsPane;

	private InicialPanel inicialPanel;
	private AlunoListPanel alunoListPanel;
	private AlunoFormPanel alunoFormPanel;

	public AppFrame() {
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
		layout.show(cardsPane, AlunoListPanel.class.getName());
	}
	
	public void mostrarFormTarefas(Aluno tarefa) {
		alunoFormPanel.setTarefa(tarefa);
		layout.show(cardsPane, AlunoFormPanel.class.getName());
	}

	private void criarCards() {
		inicialPanel = new InicialPanel(this);
		cardsPane.add(inicialPanel, InicialPanel.class.getName());

		alunoListPanel = new AlunoListPanel(this);
		cardsPane.add(alunoListPanel, AlunoListPanel.class.getName());

		alunoFormPanel = new AlunoFormPanel(this);
		cardsPane.add(alunoFormPanel, AlunoFormPanel.class.getName());
	}
} // fim da classe AppFrame
