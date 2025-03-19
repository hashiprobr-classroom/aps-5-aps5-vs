package br.edu.insper.desagil.aps5.isail;

import java.time.LocalDateTime;

public class Lance {
    private Comprador comprador;
    private double oferta;
    private LocalDateTime momento;

    public Lance(Comprador comprador, double oferta, LocalDateTime momento) {
        this.comprador = comprador;
        this.oferta = oferta;
        this.momento = momento;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public double getOferta() {
        return oferta;
    }

    public LocalDateTime getMomento() {
        return momento;
    }

    @Override
    public String toString() {
        return comprador + " ofereceu " + oferta + " em " + momento;
    }
}