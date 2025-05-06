package br.com.vieira.gestaofuncionarios.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public interface UsuarioControllerInterface {

    void cadastrarUsuario(String nome, String email, String senha) throws SQLException, NoSuchAlgorithmException;

    boolean realizarLogin(String email, String senha) throws SQLException, NoSuchAlgorithmException;
}
