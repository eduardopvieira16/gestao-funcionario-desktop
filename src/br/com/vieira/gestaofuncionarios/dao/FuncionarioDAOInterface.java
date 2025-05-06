package br.com.vieira.gestaofuncionarios.dao;

import br.com.vieira.gestaofuncionarios.model.Funcionario;
import java.sql.SQLException;
import java.util.List;

public interface FuncionarioDAOInterface {

    void salvar(Funcionario funcionario) throws SQLException;

    List<Funcionario> listarTodos() throws SQLException;
}
