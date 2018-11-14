package com.example.letal.speechcorpustext.Objetos;


/**
 * Clase que funciona como ejemplo para almacenar la información en la nube, se conforman objetos de este tipo y se guardan
 * @version v1
 * @author megamind
 * */
public class corpus {

    String titulo;
    String descripcion;
    String operacion;


    /**
     * constructor de la clase corpus
     * @param titulo,descripcion,operacion
     *
     * */
    public corpus(String titulo, String descripcion, String operacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.operacion = operacion;
    }
    /**
     * constructor de la clase corpus vacio
     *
     *
     * */
    public corpus()
    {}


    /**
     * Método getTitulo es un método get
     * */
    public String getTitulo() {
        return titulo;
    }


    /**
     * Método setTitulo es para cambiar el valor del parámetro
     * @param titulo
     *
     * */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Método getDescripcion es un método get
     * */

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método setDescripcion es para cambiar el valor del parámetro
     * @param descripcion
     *
     * */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método getOperacion es un método get
     * */
    public String getOperacion() {
        return operacion;
    }


    /**
     * Método setOperacion es para cambiar el valor del parámetro
     * @param operacion
     *
     * */
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
}
