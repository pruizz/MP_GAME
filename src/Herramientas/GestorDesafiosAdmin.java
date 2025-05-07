package Herramientas;

import SistemaDesafios.Desafio;
import SistemaDesafios.PendienteValidacion;
import SistemaPersistencia.PersistenciaManager;

import java.util.List;


public class GestorDesafiosAdmin {

    private List<Desafio> desafios;
    private List<Desafio> desafiosPendientesValidacion;

    public GestorDesafiosAdmin() {
        this.desafios = PersistenciaManager.getInstance().getPersistencia().getUsersData().getDesafios().getTodosDesafios();
        this.desafiosPendientesValidacion = PersistenciaManager.getInstance().getPersistencia().getUsersData().getDesafios().getTodosDesafíosPendientes();
    }

    public void setDesafios(List<Desafio> l){
        this.desafios = l;
    }

    public void setDesafiosPendientesValidacion(List<Desafio> desafiosPendientesValidacion) {
        this.desafiosPendientesValidacion = desafiosPendientesValidacion;
    }

    public void validarDesafio(Desafio desafio) {
        if (desafio.getEstado() instanceof PendienteValidacion){
            desafio.avanzarEstado();
        }
    }

    public Desafio getDesafio(int desafioIndex){
        return desafios.get(desafioIndex);
    }

    public Desafio getDesafioPendiente(int desafioIndex){return desafiosPendientesValidacion.get(desafioIndex);}

    public void mostrarDesafios() {
        int i = 0;
        for (Desafio desafio : desafios) {
            System.out.println(i);
            System.out.println(desafio.toString());
            i++;
        }
    }

    public void mostrarPendientesValidacion() {
        int i;
        for (Desafio desafio : desafiosPendientesValidacion) {
            i = desafiosPendientesValidacion.indexOf(desafio);
            System.out.println(i);
            System.out.println(desafio.toString());
        }
    }

    public int getNumPendientesValidacion() {
        return desafiosPendientesValidacion.size();
    }

}