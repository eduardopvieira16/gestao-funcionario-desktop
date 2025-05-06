package br.com.vieira.gestaofuncionarios.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/gestao_funcionarios";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    private Connection conexao;

    private ConexaoDAO() {
        if (Holder.INSTANCE != null) {
            throw new RuntimeException("Use getInstancia() para obter a instância Singleton");
        }
    }

    private static class Holder {

        private static final ConexaoDAO INSTANCE = new ConexaoDAO();
    }

    public static ConexaoDAO getInstancia() {
        return Holder.INSTANCE;
    }

    public Connection abrirConexao() {
        try {
            Class.forName(DRIVER);
            if (conexao == null || conexao.isClosed()) {
                conexao = DriverManager.getConnection(URL, USER, PASSWORD);
                conexao.setAutoCommit(false);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados: " + e.getMessage(), e);
        }
        return conexao;
    }

    public void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.commit();
                conexao.close();
            }
        } catch (SQLException e) {
            try {
                if (conexao != null && !conexao.isClosed()) {
                    conexao.rollback();
                }
            } catch (SQLException rollbackEx) {
                throw new RuntimeException("Erro ao realizar rollback: " + rollbackEx.getMessage(), rollbackEx);
            }
            throw new RuntimeException("Erro ao fechar a conexão: " + e.getMessage(), e);
        } finally {
            conexao = null;
        }
    }
}
