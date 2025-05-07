package SistemaPersistencia;

import Herramientas.Jugador;
import SistemaDesafios.Desafio;
import SistemaDesafios.PendienteAceptacion;
import SistemaDesafios.PendienteValidacion;

import java.util.*;


public class AlmacenDesafios {

    private Map <String, Set <Desafio>> desafios;

    public void addJugador(String clave) {
        this.desafios.put(clave, new HashSet<>());
    }

    public Map<String, Set<Desafio>> getDesafios() {
        return desafios;
    }

    public AlmacenDesafios() {

    }

    public List<Desafio> getTodosDesafios() {
        List<Desafio> arrDesafios = new LinkedList<>();
        Set<Desafio> setDesafios = new HashSet<>();
        for (String jugador : desafios.keySet()){
            for (Desafio desafio : desafios.get(jugador)){
                if (!setDesafios.contains(desafio)){
                    setDesafios.add(desafio);
                    arrDesafios.add(desafio);
                }
            }
        }
        return arrDesafios;
    }

    public List<Desafio> getDesafiosJugador(String clave) {
        LinkedList<Desafio> arrDesafios = new LinkedList<>();
        if (this.desafios.get(clave) == null){
            return null;
        }
        for (Desafio desafio : this.desafios.get(clave)){
            arrDesafios.add(desafio);
        };
        return arrDesafios;

    }

    public void setDesafios(Map<String, Set<Desafio>> desafios) {
        this.desafios = desafios;
    }



    public List<Desafio> getTodosDesafíosPendientes() {
        List<Desafio> arrDesafios = new LinkedList<>();
        Set<Desafio> setDesafios = new HashSet<>();
        for (String jugador : desafios.keySet()){
            for (Desafio desafio : desafios.get(jugador)){
                if (desafio.getEstado() instanceof PendienteValidacion && !setDesafios.contains(desafio)){
                    setDesafios.add(desafio);
                    arrDesafios.add(desafio);
                }
            }
        }
        return arrDesafios;
    }

    public List<Desafio> getDesafiosPendientesJugador(String clave) {
        List<Desafio> arrDesafiosPendientes = new LinkedList<>();
        Set<Desafio> setDesafios = new HashSet<>();
        for (Desafio desafio : desafios.get(clave)){
            if (desafio.getEstado() instanceof PendienteAceptacion && !setDesafios.contains(desafio)){
                setDesafios.add(desafio);
                arrDesafiosPendientes.add(desafio);
            }
        }
        return arrDesafiosPendientes;
    }


    public void aniadirDesafio(String clave, Desafio desafio) {
        desafios.get(clave).add(desafio);
    }



}