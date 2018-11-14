package com.example.letal.speechcorpustext.Objetos;


/**
 * Clase que funciona como ejemplo para almacenar la información en la nube, se conforman objetos de este tipo y se guardan
 * @version v1
 * @author megamind
 * */
public class Coche {

    String marca;
    int puerta;
    int rueda;
    String dueno;

    /**
     * constructor de la clase Coche vacio
     *
     *
     * */
    public Coche()
    {

    }

    /**
     * constructor de la clase Coche
     * @param marca,puerta,rueda,dueno
     *
     * */
    public Coche(String marca, int puerta, int rueda, String dueno) {
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
     * @param marca
     *
     * */
    public void setMarca(String marca) {
        this.marca = marca;
    }


    /**
     * Método getPuerta es un método get
     * */
    public int getPuerta() {
        return puerta;
    }


    /**
     * Método setPuerta es para cambiar el valor del parámetro
     * @param puerta
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
     * @param rueda
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
     * @param dueno
     *
     * */
    public void setDueno(String dueno) {
        this.dueno = dueno;
    }
}
