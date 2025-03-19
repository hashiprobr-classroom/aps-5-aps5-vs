package br.edu.insper.desagil.aps5.insee;

public class DataTempo extends Referencia{

    private final Data data;
    private final Tempo tempo;

    public DataTempo(String observacao, Data data, Tempo tempo) {
        super(observacao);
        this.data = data;
        this.tempo = tempo;
    }

    public Data getData() {
        return data;
    }

    public Tempo getTempo() {
        return tempo;
    }

    @Override
    public int comoInteiro(){

        int totMin = 0;

        totMin += data.comoInteiro() * 1440;
        totMin += tempo.comoInteiro();

        return totMin;
    }


}
