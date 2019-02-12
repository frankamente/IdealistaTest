package com.example.demo;

public class AnuncioParaRest {
    private Anuncio anuncio;
    private double puntuacion;

    public AnuncioParaRest() {
    }

    public AnuncioParaRest(Anuncio anuncio, double puntuacion) {
        this.anuncio = anuncio;
        this.puntuacion = puntuacion;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }
}
