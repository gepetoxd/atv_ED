package entities;

import interfaces.Imprimivel;

import java.io.Serializable;

public class Cliente implements Imprimivel{
    private String cpf;
    private String  nome;
    private String email;


    public Cliente(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getCabecalho() {
        return "Cpf | Nome | Email ";
    }

    @Override
    public String getDadosFormatados() {
        return cpf + " | "+ nome  + " | " + email;
    }
}
