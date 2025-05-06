package br.com.vieira.gestaofuncionarios.dao;

import br.com.vieira.gestaofuncionarios.model.Usuario;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public interface UsuarioDAOInterface {

    void salvar(Usuario usuario) throws SQLException, NoSuchAlgorithmException;

    Usuario buscarPorEmail(String email) throws SQLException;

    boolean validarLogin(String email, String senha) throws SQLException, NoSuchAlgorithmException;
}
