package SistemaDesafios;


public class PendienteAceptacion implements EstadoDesafio {

    public PendienteAceptacion() {
    }

    @Override
    public void avanzarEstado(Desafio desafio) {
        desafio.setEstado(new EnCombate());
        desafio.iniciarCombate();
        desafio.avanzarEstado();
    }


}