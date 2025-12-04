package entities;

import interfaces.Imprimivel;

import java.io.Serializable;

public class Produto implements Imprimivel {
    private String codigo;
    private String nome;
    private Double precoUnitario;

    public Produto(String codigo, String nome, Double precoUnitario) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    @Override
    public String getCabecalho() {
        return "Codigo | Nome | Preço ";
    }

    @Override
    public String getDadosFormatados() {
        return codigo + " | " + nome + " | R$ " + precoUnitario;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", precoUnitario=" + precoUnitario +
                '}';
    }
}
