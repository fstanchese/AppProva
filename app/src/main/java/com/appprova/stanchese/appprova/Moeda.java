package com.appprova.stanchese.appprova;

import java.io.Serializable;

public class Moeda implements Serializable{
    private String codigo;
    private String nome;
    private String simbolo;

    public Moeda(String codigo, String nome, String simbolo) {
        this.codigo = codigo;
        this.nome = nome;
        this.simbolo = simbolo;
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

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Moeda moedas = (Moeda) o;

        if (!codigo.equals(moedas.codigo)) return false;
        if (!nome.equals(moedas.nome)) return false;
        return simbolo.equals(moedas.simbolo);

    }

    @Override
    public int hashCode() {
        int result = codigo.hashCode();
        result = 31 * result + nome.hashCode();
        result = 31 * result + simbolo.hashCode();
        return result;
    }


}
