package br.com.vieira.gestaofuncionarios.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {

    private LocalDate dataAdmissao;
    private BigDecimal salario;
    private String status;

    public Funcionario() {
    }

    public Funcionario(String nome, String email, LocalDate dataAdmissao, BigDecimal salario, String status) {
        super(nome, email);
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;
        this.status = status;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
