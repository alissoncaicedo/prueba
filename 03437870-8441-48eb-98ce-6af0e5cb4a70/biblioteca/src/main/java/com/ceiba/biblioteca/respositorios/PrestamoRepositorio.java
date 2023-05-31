package com.ceiba.biblioteca.respositorios;

public class PrestamoRepositorio {

    private Integer id;
    private String ISBN;
    private String identificadordeusuario;
    private Integer tipodeusuario;

    public PrestamoRepositorio() {

    }

    public PrestamoRepositorio(Integer id, String ISBN, String identificadordeusuario, Integer tipodeusuario) {
        this.id = id;
        this.ISBN = ISBN;
        this.identificadordeusuario = identificadordeusuario;
        this.tipodeusuario = tipodeusuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getIdentificadordeusuario() {
        return identificadordeusuario;
    }

    public void setIdentificadordeusuario(String identificadordeusuario) {
        this.identificadordeusuario = identificadordeusuario;
    }

    public Integer getTipodeusuario() {
        return tipodeusuario;
    }

    public void setTipodeusuario(Integer tipodeusuario) {
        this.tipodeusuario = tipodeusuario;
    }
}