package br.com.vieira.gestaofuncionarios.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.vieira.gestaofuncionarios.dao.exception.DAOException;
import br.com.vieira.gestaofuncionarios.model.Usuario;

public class UsuarioDAO implements UsuarioDAOInterface {
	private final ConexaoDAO conexaoDAO = ConexaoDAO.getInstancia();

	@Override
	public void salvar(Usuario usuario) throws DAOException, NoSuchAlgorithmException {
		try (Connection conn = conexaoDAO.abrirConexao();
				PreparedStatement stmt = conn
						.prepareStatement("INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)")) {
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, criptografarSenha(usuario.getSenha()));
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Erro ao salvar usuário: " + e.getMessage(), e);
		} finally {
			conexaoDAO.fecharConexao();
		}
	}

	@Override
	public Usuario buscarPorEmail(String email) throws DAOException {
		try (Connection conn = conexaoDAO.abrirConexao();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuarios WHERE email = ?");
				ResultSet rs = stmt.executeQuery()) {
			stmt.setString(1, email);
			if (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				return usuario;
			}
			return null;
		} catch (SQLException e) {
			throw new DAOException("Erro ao buscar usuário por e-mail: " + e.getMessage(), e);
		} finally {
			conexaoDAO.fecharConexao();
		}
	}

	private String criptografarSenha(String senha) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(senha.getBytes());
		StringBuilder hexString = new StringBuilder();
		for (byte b : hash) {
			String hex = Integer.toHexString(0xff & b);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}

	@Override
	public boolean validarLogin(String email, String senha) throws DAOException, NoSuchAlgorithmException {
		Usuario usuario = buscarPorEmail(email);
		if (usuario != null) {
			String senhaCriptografada = criptografarSenha(senha);
			return senhaCriptografada.equals(usuario.getSenha());
		}
		return false;
	}
}