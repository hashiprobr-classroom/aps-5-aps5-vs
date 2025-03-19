package br.edu.insper.desagil.aps5.insee;

import java.util.HashMap;

public class Data extends Referencia{
    private Integer ano = 1970;
    private Integer mes = 1;
    private Integer dia = 1;
    private HashMap<Integer, Integer> limites;

    public Data(String observacao) {
        super(observacao);
        this.limites = new HashMap<Integer, Integer>();
        limites.put(1, 31);
        limites.put(2, 28);
        limites.put(3, 31);
        limites.put(4, 30);
        limites.put(5, 31);
        limites.put(6, 30);
        limites.put(7, 31);
        limites.put(8, 31);
        limites.put(9, 30);
        limites.put(10, 31);
        limites.put(11, 30);
        limites.put(12, 31);
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public void atualiza(int dia, int mes, int ano){
        if (ano < 1970) {
            this.ano = 1970;
        } else {
            this.ano = ano;
        }

        if (mes < 1) {
            this.mes = 1;
        } else if (mes > 12) {
            this.mes = 12;
        } else {
            this.mes = mes;
        }

        int limite = limites.get(this.mes);
        if (dia < 1) {
            this.dia = 1;
        } else if (dia > limite) {
            this.dia = limite;
        } else {
            this.dia = dia;
        }
    }

    @Override
    public int comoInteiro(){

        int totalDias = 0;

        for (int i = 1970; i < ano; i++) {
            totalDias += 365;
        }

        for (int i = 1; i < mes; i++) {
            totalDias += limites.get(i);
        }

        totalDias += (dia - 1);

        return totalDias;
    }

}
