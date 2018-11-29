package com.example.letal.speechcorpustext.Objetos;


/**
 * Clase que funciona como ejemplo para almacenar la información en la nube, se conforman objetos de este tipo y se guardan
 * @version v1
 * @author megamind
 * */
public class datos {

    String marca;
    int puerta;
    int rueda;
    String dueno;

    /**
     * constructor de la clase datos vacio
     *
     *
     * */
    public datos()
    {

    }

    /**
     * constructor de la clase datos
     * @param marca,puerta,rueda,dueno esta información ahora no se utiliza, más adelante se estará utilizando en otras informaciones a almacenar en la base de datos
     *                                 de firebase
     *
     *
     * */
    public datos(String marca, int puerta, int rueda, String dueno) {
        this.marca = marca;
        this.puerta = puerta;
        this.rueda = rueda;
        this.dueno = dueno;
    }


    /**
     * Método getTitulo es un método get
     * */

    public String getMarca() {
        return marca;
    }



    /**
     * Método setMarca es para cambiar el valor del parámetro
     * @param marca es la marca  de voz
     *
     * */
    public void setMarca(String marca) {
        this.marca = marca;
    }


    /**
     * Método getPuerta es un método get
     *
     * */
    public int getPuerta() {
        return puerta;
    }


    /**
     * Método setPuerta es para cambiar el valor del parámetro
     * @param puerta la puerta de entrada o enlace por ahora no se utiliza
     *
     * */
    public void setPuerta(int puerta) {
        this.puerta = puerta;
    }


    /**
     * Método getRueda es un método get
     * */
    public int getRueda() {
        return rueda;
    }


    /**
     * Método setRueda es para cambiar el valor del parámetro
     * @param rueda esta información se utilizó para guardar el espacion entero en la base de datos
     *
     * */
    public void setRueda(int rueda) {
        this.rueda = rueda;
    }


    /**
     * Método getDueno es un método get
     * */
    public String getDueno() {
        return dueno;
    }


    /**
     * Método setDueno es para cambiar el valor del parámetro
     * @param dueno es el nombre de la persona que esta almacenando los datos
     *
     * */
    public void setDueno(String dueno) {
        this.dueno = dueno;
    }
}
