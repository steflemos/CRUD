import javax.swing.SwingUtilities;

// import view.AppFrame;

public class TodoApp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				criarMostrarGUI();
			}
		});
	}

	private static void criarMostrarGUI() {
		AppFrame frame = new AppFrame();

		frame.mostrar();
	}
} // fim da classe Matriculas
