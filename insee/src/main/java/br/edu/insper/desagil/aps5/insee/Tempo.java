package br.edu.insper.desagil.aps5.insee;

public class Tempo extends Referencia {

    private Integer hora = 0;
    private Integer minuto = 0;

    public Tempo(String observacao) {
        super(observacao);
    }

    public Integer getHora() {
        return hora;
    }

    public Integer getMinuto() {
        return minuto;
    }

    public void atualiza(int hora, int minuto) {
        if (hora < 0) {
            this.hora = 0;
        } else if (hora > 23) {
            this.hora = 23;
        } else {
            this.hora = hora;
        }

        if (minuto < 0) {
            this.minuto = 0;
        } else if (minuto > 59) {
            this.minuto = 59;
        } else {
            this.minuto = minuto;
        }
    }

    @Override
    public int comoInteiro(){

        int totMin = 0;

        for (int i = 0; i <= hora; i++){
            totMin += 60;
            }

        totMin += minuto;

        return totMin;
    }

}


