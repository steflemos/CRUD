import java.util.ArrayList;

public class Aluno {
    private int id;
    private String nome;
    private int idade;
    private String email;
    private String endereco;
    private String cep;
    private String telefone;
    private String usuario;
    private String senha;
    private ArrayList<String> curso;
    private String observacao;
    private boolean ativo;

    public Aluno() {
        this.curso = new ArrayList<>();
        cursosDisponiveis();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade > 0) {
            this.idade = idade;
        } else {
            System.out.println("Idade inválida. Por favor, insira um valor válido.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b")) {
            this.email = email;
        } else {
            System.out.println("Email inválido. Por favor, insira um email válido.");
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (cep.matches("\\d{8}")) {
            this.cep = cep;
        } else {
            System.out.println("CEP inválido. Por favor, insira um valor maior que zero.");
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone.matches("\\d{10,11}")) {
            this.telefone = telefone;
        } else {
            System.out.println("Telefone inválido. Por favor, insira um número de telefone válido com 10 ou 11 dígitos.");
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        if (usuario != null && !usuario.isEmpty()) {
            this.usuario = usuario;
        } else {
            System.out.println("Nome de usuário inválido. Por favor, insira um nome de usuário válido.");
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha != null && senha.length() >= 6) {
            this.senha = senha;
        } else {
            System.out.println("Senha inválida. Por favor, insira uma senha com pelo menos 6 caracteres.");
        }
    }

    public void cursosDisponiveis() {
        this.curso.add("Desenvolvimento Web");
        this.curso.add("Inteligência Artificial");
        this.curso.add("Segurança da Informação");
        this.curso.add("Ciência de Dados");
        this.curso.add("Desenvolvimento Mobile");
        this.curso.add("Redes de Computadores");
        this.curso.add("Blockchain e Criptomoedas");
        this.curso.add("Cloud Computing");
        this.curso.add("Desenvolvimento de Jogos");
        this.curso.add("Arquitetura de Software");
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean estaAtivo() {
        return ativo;
    }

    public void setStatusAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getStatus() {
        return (ativo) ? "Ativo" : "Inativo";
    }

}