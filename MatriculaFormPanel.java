import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MatriculaFormPanel extends JPanel {
	private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);

	private Matricula cadastro;

	private InitialFrame frame;

	private GridBagLayout layout;
	private GridBagConstraints constraints;

	private JTextField idTxt;
	private JTextField nomeTxt;
	private JTextField idadeTxt;
	private JTextField emailTxt;
	private JTextField enderecoTxt;
	private JTextField cepTxt;
	private JTextField telefoneTxt;
	private JTextField usuarioTxt;
	private JTextField senhaTxt;
	private String[] cursos = { "Selecione uma opção: ", "Desenvolvimento Web", "Inteligência Artificial",
			"Segurança da Informação", "Ciência de Dados", "Desenvolvimento Mobile", "Redes de Computadores",
			"Blockchain e Criptomoedas", "Cloud Computing", "Desenvolvimento de Jogos", "Arquitetura de Software" };
	private JComboBox<String> cursoTxt;
	private JTextArea obsTxt;

	private interface AtivoLabel {
		public static final String ATIVO = "Ativo";
		public static final String DESATIVO = "Desativo";
		public static String[] labels = {
				ATIVO, DESATIVO
		};
	}

	private JComboBox<String> ativoComboBox;
	private JButton salvarBtn;
	private JButton cancelarBtn;

	public MatriculaFormPanel(InitialFrame appFrame) {
		frame = appFrame;

		cadastro = null;

		layout = new GridBagLayout();
		constraints = new GridBagConstraints();

		setLayout(layout);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				if (cadastro == null) {
					idTxt.setText("");
					nomeTxt.setText("");
					idadeTxt.setText("");
					emailTxt.setText("");
					enderecoTxt.setText("");
					cepTxt.setText("");
					telefoneTxt.setText("");
					usuarioTxt.setText("");
					senhaTxt.setText("");
					cursoTxt.setSelectedIndex(0);
					obsTxt.setText("");
					ativoComboBox.setSelectedItem(AtivoLabel.ATIVO);

					adicionarTextoExemplo(nomeTxt, "Eduardo Camilo Inacio");
					adicionarTextoExemplo(idadeTxt, "25 anos");
					adicionarTextoExemplo(emailTxt, "exemplo@exemplo.com");
					adicionarTextoExemplo(enderecoTxt, "Rua Exemplo, 123");
					adicionarTextoExemplo(cepTxt, "12345-678");
					adicionarTextoExemplo(telefoneTxt, "(12) 3456-7890");

				} else {
					idTxt.setText(Integer.toString(cadastro.getId()));
					nomeTxt.setText(cadastro.getNome());
					idadeTxt.setText(cadastro.getIdade());
					emailTxt.setText(cadastro.getEmail());
					enderecoTxt.setText(cadastro.getEndereco());
					cepTxt.setText(cadastro.getCep());
					telefoneTxt.setText(cadastro.getTelefone());
					usuarioTxt.setText(cadastro.getUsuario());
					senhaTxt.setText(cadastro.getSenha());
					cursoTxt.setSelectedIndex(Arrays.asList(cadastro.getCurso()).indexOf(cadastro.getCurso()));
					obsTxt.setText(cadastro.getObservacao());
					ativoComboBox.setSelectedItem(cadastro.getAtivo() ? AtivoLabel.ATIVO : AtivoLabel.DESATIVO);
				}
			}
		});

		criarForm();
	}

	public void setTarefa(Matricula cadastro) {
		this.cadastro = cadastro;
	}

	private void criarForm() {
		JLabel rotulo;

		rotulo = new JLabel("Id");
		adicionarComponente(rotulo, 0, 0);
		idTxt = new JTextField(5);
		idTxt.setEditable(false);
		adicionarComponente(idTxt, 0, 1);

		rotulo = new JLabel("Nome (*)");
		adicionarComponente(rotulo, 1, 0);
		nomeTxt = new JTextField(30);
		adicionarComponente(nomeTxt, 1, 1);

		rotulo = new JLabel("Idade (*)");
		adicionarComponente(rotulo, 2, 0);
		idadeTxt = new JTextField(3);
		adicionarComponente(idadeTxt, 2, 1);

		rotulo = new JLabel("Email (*)");
		adicionarComponente(rotulo, 3, 0);
		emailTxt = new JTextField(30);
		adicionarComponente(emailTxt, 3, 1);

		rotulo = new JLabel("Endereço (*)");
		adicionarComponente(rotulo, 4, 0);
		enderecoTxt = new JTextField(30);
		adicionarComponente(enderecoTxt, 4, 1);

		rotulo = new JLabel("Cep");
		adicionarComponente(rotulo, 5, 0);
		cepTxt = new JTextField(8);
		adicionarComponente(cepTxt, 5, 1);

		rotulo = new JLabel("Telefone");
		adicionarComponente(rotulo, 6, 0);
		telefoneTxt = new JTextField(11);
		adicionarComponente(telefoneTxt, 6, 1);

		rotulo = new JLabel("Usuario (*)");
		adicionarComponente(rotulo, 7, 0);
		usuarioTxt = new JTextField(24);
		adicionarComponente(usuarioTxt, 7, 1);

		rotulo = new JLabel("Senha (*)");
		adicionarComponente(rotulo, 8, 0);
		senhaTxt = new JPasswordField(12);
		adicionarComponente(senhaTxt, 8, 1);

		rotulo = new JLabel("Curso (*)");
		adicionarComponente(rotulo, 9, 0);
		cursoTxt = new JComboBox<>(cursos);
		adicionarComponente(cursoTxt, 9, 1);

		JScrollPane scrollPane;
		rotulo = new JLabel("Observação");
		adicionarComponente(rotulo, 10, 0);
		obsTxt = new JTextArea(5, 30);
		scrollPane = new JScrollPane(obsTxt);
		adicionarComponente(scrollPane, 10, 1);

		rotulo = new JLabel("Ativo (*)");
		adicionarComponente(rotulo, 11, 0);
		ativoComboBox = new JComboBox<>(AtivoLabel.labels);
		adicionarComponente(ativoComboBox, 11, 1);

		criarBotoes();
	}

	private void criarBotoes() {
		JPanel btnPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) btnPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);

		criarSalvarBtn(btnPanel);
		criarCancelarBtn(btnPanel);

		adicionarComponente(btnPanel, 12, 1, 2, 1);
	}

	private void adicionarTextoExemplo(JTextField textField, String exemplo) {
		textField.setText(exemplo);
		textField.setForeground(Color.GRAY);

		textField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField.getText().equals(exemplo)) {
					textField.setText("");
					textField.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField.getText().isEmpty()) {
					textField.setText(exemplo);
					textField.setForeground(Color.GRAY);
				}
			}
		});
	}

	private void criarSalvarBtn(JPanel panel) {
		salvarBtn = new JButton("Salvar");
		salvarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (camposPreenchidosCorretamente()) {
					if (cadastro == null) {
						cadastro = new Matricula();
						cadastro.setNome(nomeTxt.getText());
						cadastro.setIdade(idadeTxt.getText());
						cadastro.setEmail(emailTxt.getText());
						cadastro.setEndereco(enderecoTxt.getText());
						cadastro.setCep(cepTxt.getText());
						cadastro.setTelefone(telefoneTxt.getText());
						cadastro.setUsuario(usuarioTxt.getText());
						cadastro.setSenha(senhaTxt.getText());
						cadastro.setObservacao(obsTxt.getText());
						cadastro.setCurso(cursoTxt.getSelectedItem());
						cadastro.setAtivo(ativoComboBox.getSelectedItem() == AtivoLabel.ATIVO);
						// TarefaStorage.inserir(cadastro);
					} else {
						cadastro.setId(Integer.parseInt(idTxt.getText()));
						cadastro.setNome(nomeTxt.getText());
						cadastro.setIdade(idadeTxt.getText());
						cadastro.setEmail(emailTxt.getText());
						cadastro.setEndereco(enderecoTxt.getText());
						cadastro.setCep(cepTxt.getText());
						cadastro.setTelefone(telefoneTxt.getText());
						cadastro.setUsuario(usuarioTxt.getText());
						cadastro.setSenha(senhaTxt.getText());
						cadastro.setCurso(cursoTxt.getSelectedItem());
						cadastro.setObservacao(obsTxt.getText());
						cadastro.setAtivo(ativoComboBox.getSelectedItem() == AtivoLabel.ATIVO);
						// TarefaStorage.atualizar(cadastro);
					}
					JOptionPane.showMessageDialog(MatriculaFormPanel.this, "Aluno cadastrado com sucesso!",
							InitialFrame.titulo,
							JOptionPane.INFORMATION_MESSAGE);
					frame.mostrarListaTarefas();
				} else {
					JOptionPane.showMessageDialog(MatriculaFormPanel.this, "Preencha todos os campos corretamente!",
							"Erro de validação", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(salvarBtn);
	}

	private boolean camposPreenchidosCorretamente() {
		// falta descobrir como fazer para o usuario nao conseguir submeter um form sem
		// preencher curso e status
		if (nomeTxt.getText().isEmpty() || idadeTxt.getText().isEmpty() || emailTxt.getText().isEmpty()
				|| usuarioTxt.getText().isEmpty() || senhaTxt.getText().isEmpty()) {
			return false;
		}

		if (!idadeTxt.getText().matches("\\d+")) {
			JOptionPane.showMessageDialog(MatriculaFormPanel.this, "A idade deve ser um número válido!",
					"Erro de validação", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		String email = emailTxt.getText();
		String emailModel = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		if (!email.matches(emailModel)) {
			JOptionPane.showMessageDialog(MatriculaFormPanel.this, "O email deve ser válido!",
					"Erro de validação", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	private void criarCancelarBtn(JPanel panel) {
		cancelarBtn = new JButton("Cancelar");
		cancelarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarListaTarefas();
			}
		});
		panel.add(cancelarBtn);
	}

	private void adicionarComponente(JComponent componente, int linha, int coluna) {
		adicionarComponente(componente, linha, coluna, 1, 1);
	}

	private void adicionarComponente(JComponent componente, int linha, int coluna, int largura, int altura) {
		constraints.gridx = coluna;
		constraints.gridy = linha;
		constraints.gridwidth = largura;
		constraints.gridheight = altura;

		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = FIELD_INSETS;

		layout.setConstraints(componente, constraints);
		add(componente);
	}
} // fim da classe MatriculaFormPanel