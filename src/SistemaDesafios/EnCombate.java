package SistemaDesafios;

public class EnCombate implements EstadoDesafio {

    public void avanzarEstado(Desafio desafio) {
        desafio.setEstado(new Finalizado());
        desafio.avanzarEstado();
    }

}