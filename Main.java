import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				criarMostrarGUI();
			}
		});
	}

	private static void criarMostrarGUI() {
		InitialFrame frame = new InitialFrame();
		frame.mostrar();
	}
} // fim da classe Main
