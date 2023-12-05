

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MatriculaStorage {

	public static void inserir(Matricula matricula) {
		final String query = "INSERT INTO matricula (nome, idade, email, endereco, cep, telefone, usuario, senha, curso, observacoes, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		try {
			conn = ConexaoFactory.getConexao();
			prepStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			prepStmt.setString(1, matricula.getNome());
			prepStmt.setString(2, matricula.getIdade());
			prepStmt.setString(3, matricula.getEmail());
			prepStmt.setString(4, matricula.getEndereco());
			prepStmt.setString(5, matricula.getCep());
			prepStmt.setString(6, matricula.getTelefone());
			prepStmt.setString(7, matricula.getUsuario());
			prepStmt.setString(8, matricula.getSenha());
			prepStmt.setObject(9, matricula.getCurso());
			prepStmt.setString(10, matricula.getObservacao());
			prepStmt.setBoolean(11, matricula.getAtivo());
			prepStmt.execute();

			rs = prepStmt.getGeneratedKeys();
			if (rs.next()) {
				matricula.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepStmt != null) {
					prepStmt.close();
				}

				if (rs != null) {
					rs.close();
				}
			} catch (Exception e){
				e.printStackTrace();
			}
		}

	}



	public static void atualizar(Matricula matricula) {
		final String query = "UPDATE matricula SET nome = ?, idade = ?, email = ?, endereco = ?, cep = ?, telefone = ?, usuario = ?, senha = ?, curso = ?, observacoes = ?, ativo = ? WHERE id = ?";

		Connection conn = null;
		PreparedStatement prepStmt = null;

		try {
			conn = ConexaoFactory.getConexao();

			prepStmt = conn.prepareStatement(query);
			prepStmt.setString(1, matricula.getNome());
			prepStmt.setString(2, matricula.getIdade());
			prepStmt.setString(3, matricula.getEmail());
			prepStmt.setString(4, matricula.getEndereco());
			prepStmt.setString(5, matricula.getCep());
			prepStmt.setString(6, matricula.getTelefone());
			prepStmt.setString(7, matricula.getUsuario());
			prepStmt.setString(8, matricula.getSenha());
			prepStmt.setObject(9, matricula.getCurso());
			prepStmt.setString(10, matricula.getObservacao());
			prepStmt.setBoolean(11, matricula.getAtivo());
			prepStmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepStmt != null)
					prepStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void remover(Matricula matricula) {
		final String query = "DELETE FROM matricula WHERE id = ?";

		Connection conn = null;
		PreparedStatement prepStmt = null;

		try {
			conn = ConexaoFactory.getConexao();

			prepStmt = conn.prepareStatement(query);
			prepStmt.setInt(1, matricula.getId());
			prepStmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepStmt != null)
					prepStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static List<Matricula> listar() {
		List<Matricula> matriculas = new ArrayList<>();

		final String query = "SELECT * FROM matricula ORDER BY id";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConexaoFactory.getConexao();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Matricula matricula = new Matricula();
				matricula.setId(rs.getInt("id"));
				matricula.setNome(rs.getString("nome"));
				matricula.setIdade(rs.getString("idade"));
				matricula.setEmail(rs.getString("email"));
				matricula.setEndereco(rs.getString("endereco"));
				matricula.setCep(rs.getString("cep"));
				matricula.setTelefone(rs.getString("telefone"));
				matricula.setUsuario(rs.getString("usuario"));
				matricula.setSenha(rs.getString("senha"));
				matricula.setCurso(rs.getString("curso"));
				matricula.setObservacao(rs.getString("observacoes"));
				matricula.setAtivo(rs.getBoolean("ativo"));

				matriculas.add(matricula);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();

				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return matriculas;
	}
}

