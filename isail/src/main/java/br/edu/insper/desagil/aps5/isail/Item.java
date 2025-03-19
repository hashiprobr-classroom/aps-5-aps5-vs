package br.edu.insper.desagil.aps5.isail;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Item {
    private String nome;
    private double minimo;
    private List<Lance> lances;

    public Item(String nome, double minimo) {
        this.nome = nome;
        this.minimo = minimo;
        this.lances = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void fazLance(Comprador comprador, double oferta) {
        if (oferta < minimo) {
            return;
        }

        if (!lances.isEmpty()) {
            Lance melhor = lances.get(0);
            for (Lance lance : lances) {
                if (lance.getOferta() < melhor.getOferta()) {
                    melhor = lance;
                }
            }
            if (oferta <= melhor.getOferta()) {
                return;
            }
        }

        // Cria um novo lance com o momento atual
        Lance novoLance = new Lance(comprador, oferta, LocalDateTime.now());
        lances.add(novoLance);
        comprador.incrementa();
    }

    public void imprimeMelhorLance() {
        if (lances.isEmpty()) {
            System.out.println("Nenhum lance foi feito ainda!");
        } else {
            Lance melhor = lances.get(0);
            for (Lance lance : lances) {
                if (lance.getOferta() > melhor.getOferta()) {
                    melhor = lance;
                }
            }
            System.out.println(melhor);
        }
    }
}