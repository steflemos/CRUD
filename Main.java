import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver não localizado");
		}

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
