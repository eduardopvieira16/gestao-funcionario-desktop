package br.com.vieira.gestaofuncionarios.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vieira.gestaofuncionarios.dao.exception.DAOException;
import br.com.vieira.gestaofuncionarios.model.Funcionario;

public class FuncionarioDAO implements FuncionarioDAOInterface {

    private final ConexaoDAO conexaoDAO = ConexaoDAO.getInstancia();

    @Override
    public void salvar(Funcionario funcionario) throws DAOException {
        try (Connection conn = conexaoDAO.abrirConexao(); PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO funcionarios (nome, email, data_admissao, salario, status) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getEmail());
            stmt.setDate(3, java.sql.Date.valueOf(funcionario.getDataAdmissao()));
            stmt.setBigDecimal(4, funcionario.getSalario()); // Garantindo que salario seja BigDecimal
            stmt.setString(5, funcionario.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao salvar funcionário: " + e.getMessage(), e);
        } finally {
            conexaoDAO.fecharConexao();
        }
    }

    @Override
    public List<Funcionario> listarTodos() throws DAOException {
        List<Funcionario> funcionarios = new ArrayList<>();
        try (Connection conn = conexaoDAO.abrirConexao(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM funcionarios"); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getLong("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setDataAdmissao(rs.getDate("data_admissao").toLocalDate());
                funcionario.setSalario(rs.getBigDecimal("salario")); // Garantindo que salario seja BigDecimal
                funcionario.setStatus(rs.getString("status"));
                funcionarios.add(funcionario);
            }
            return funcionarios;
        } catch (SQLException e) {
            throw new DAOException("Erro ao listar funcionários: " + e.getMessage(), e);
        } finally {
            conexaoDAO.fecharConexao();
        }
    }
}
