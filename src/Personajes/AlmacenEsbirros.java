package Personajes;

import java.util.*;

public class AlmacenEsbirros{
    private List<Esbirro> esbirros;

    public List<Esbirro> getEsbirros() {
        return this.esbirros;
    }

    public void setEsbirros(List<Esbirro> esbirros) {
        this.esbirros = esbirros;
    }

    public AlmacenEsbirros(List<Esbirro> l){
        this.esbirros = l;
    }

    public AlmacenEsbirros(){ }


    public void aniadirEsbirro(Esbirro esbirro) {

        this.esbirros.add(esbirro);


    }
    public int getSaludTotal(){
        int saludTotal = 0;
        for (Esbirro esbirro : this.esbirros) {
            saludTotal += esbirro.getSalud();
            if (esbirro instanceof Demonios) {
                saludTotal +=((Demonios) esbirro).getEsbirros().getSaludTotal();
            }
        }
        return saludTotal;
    }

}