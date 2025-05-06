package br.com.vieira.gestaofuncionarios.model;

public class Usuario extends Pessoa {

    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha) {
        super(nome, email);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
