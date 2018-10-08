package com.example.letal.speechcorpustext.Objetos;

public class corpus {

    String titulo;
    String descripcion;
    String operacion;


    public corpus(String titulo, String descripcion, String operacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.operacion = operacion;
    }

    public corpus()
    {}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
}
