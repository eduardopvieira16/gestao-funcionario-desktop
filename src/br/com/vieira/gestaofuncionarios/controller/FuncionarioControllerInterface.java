package br.com.vieira.gestaofuncionarios.controller;

import br.com.vieira.gestaofuncionarios.model.Funcionario;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface FuncionarioControllerInterface {

    void cadastrarFuncionario(String nome, String email, LocalDate dataAdmissao, BigDecimal salario, String status)
            throws SQLException;

    List<Funcionario> listarFuncionarios() throws SQLException;
}
