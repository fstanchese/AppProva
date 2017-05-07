package com.appprova.stanchese.appprova;

import java.io.Serializable;

public class Pais implements Serializable {
    private String nome;
    private String capital;
    private String area;
    private String populacao;
    private Moeda moeda;
    private String bandeira;

    public Pais(String nome, String capital, String area, String populacao, Moeda moeda, String bandeira) {
        this.nome = nome;
        this.capital = capital;
        this.area = area;
        this.populacao = populacao;
        this.moeda = moeda;
        this.bandeira = bandeira;
    }

    public String getBandeira() { return bandeira; }

    public void setBandeira(String bandeira) { this.bandeira = bandeira; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pais pais = (Pais) o;

        if (!nome.equals(pais.nome)) return false;
        if (!capital.equals(pais.capital)) return false;
        if (!area.equals(pais.area)) return false;
        if (!populacao.equals(pais.populacao)) return false;
        return moeda.equals(pais.moeda);

    }

    @Override
    public int hashCode() {
        int result = nome.hashCode();
        result = 31 * result + capital.hashCode();
        result = 31 * result + area.hashCode();
        result = 31 * result + populacao.hashCode();
        result = 31 * result + moeda.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nome='" + nome + '\'' +
                ", capital='" + capital + '\'' +
                ", area='" + area + '\'' +
                ", populacao='" + populacao + '\'' +
                ", moeda=" + moeda +
                ", bandeira=" + bandeira +
                '}';
    }
}
