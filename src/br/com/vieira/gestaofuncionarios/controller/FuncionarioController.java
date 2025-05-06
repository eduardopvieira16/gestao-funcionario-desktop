package br.com.vieira.gestaofuncionarios.controller;

import br.com.vieira.gestaofuncionarios.dao.FuncionarioDAO;
import br.com.vieira.gestaofuncionarios.model.Funcionario;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class FuncionarioController implements FuncionarioControllerInterface {

    private FuncionarioDAO funcionarioDAO;

    public FuncionarioController() {
        this.funcionarioDAO = new FuncionarioDAO();
    }

    @Override
    public void cadastrarFuncionario(String nome, String email, LocalDate dataAdmissao, BigDecimal salario,
            String status) throws SQLException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        if (dataAdmissao == null) {
            throw new IllegalArgumentException("Data de admissão é obrigatória");
        }
        if (salario == null || salario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Salário deve ser maior que zero");
        }
        if (status == null || (!status.equals("ativo") && !status.equals("inativo"))) {
            throw new IllegalArgumentException("Status deve ser 'ativo' ou 'inativo'");
        }

        Funcionario funcionario = new Funcionario(nome, email, dataAdmissao, salario, status);
        funcionarioDAO.salvar(funcionario);
    }

    @Override
    public List<Funcionario> listarFuncionarios() throws SQLException {
        return funcionarioDAO.listarTodos();
    }
}
