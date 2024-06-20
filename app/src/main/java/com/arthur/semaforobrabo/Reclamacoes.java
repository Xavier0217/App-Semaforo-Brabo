package com.arthur.semaforobrabo;

public class Reclamacoes {

    private int id;
    private String nomeUsuario;
    private String duvida;

    private MainActivity mainActivity;

    public Reclamacoes() {

    }

    public Reclamacoes(String nomeUsuario, String duvida) {
        this.nomeUsuario = String.valueOf(mainActivity.getEditTextUsuario());
        this.duvida = duvida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getDuvida() {
        return duvida;
    }

    public void setDuvida(String duvida) {
        this.duvida = duvida;
    }


    @Override
    public String toString() {
        return "Reclamações{" + "nomeUsuario='" + nomeUsuario + '\'' + '}';
    }
}
