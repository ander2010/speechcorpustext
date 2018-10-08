package com.example.letal.speechcorpustext.Objetos;

public class Coche {

    String marca;
    int puerta;
    int rueda;
    String dueno;


    public Coche()
    {

    }
    public Coche(String marca, int puerta, int rueda, String dueno) {
        this.marca = marca;
        this.puerta = puerta;
        this.rueda = rueda;
        this.dueno = dueno;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPuerta() {
        return puerta;
    }

    public void setPuerta(int puerta) {
        this.puerta = puerta;
    }

    public int getRueda() {
        return rueda;
    }

    public void setRueda(int rueda) {
        this.rueda = rueda;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }
}
