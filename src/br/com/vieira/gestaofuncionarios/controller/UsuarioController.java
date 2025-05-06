package br.com.vieira.gestaofuncionarios.controller;

import br.com.vieira.gestaofuncionarios.dao.UsuarioDAO;
import br.com.vieira.gestaofuncionarios.model.Usuario;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class UsuarioController implements UsuarioControllerInterface {

    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    @Override
    public void cadastrarUsuario(String nome, String email, String senha)
            throws SQLException, NoSuchAlgorithmException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        if (senha == null || senha.trim().isEmpty() || senha.length() < 6) {
            throw new IllegalArgumentException("Senha deve ter pelo menos 6 caracteres");
        }

        Usuario usuario = new Usuario(nome, email, senha);
        usuarioDAO.salvar(usuario);
    }

    @Override
    public boolean realizarLogin(String email, String senha) throws SQLException, NoSuchAlgorithmException {
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("Senha é obrigatória");
        }

        return usuarioDAO.validarLogin(email, senha);
    }
}
