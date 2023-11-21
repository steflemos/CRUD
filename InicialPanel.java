import javax.swing.JPanel;

public class InicialPanel extends JPanel {
	private AppFrame frame;

	public InicialPanel(AppFrame appFrame) {
		frame = appFrame;
		frame.mostrarListaTarefas();
	}
} // fim da class InicialPanel