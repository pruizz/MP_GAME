package SistemaDesafios;

import Herramientas.Jugador;

public class Desafio {
    private EstadoDesafio estado;
    private Jugador desafiante;
    private Jugador desafiado;
    private int oroApostado;
    private Combate combate;
    private boolean validado;

    public Desafio(Jugador desafiante, Jugador desafiado, int oro) {
        this.estado = new PendienteValidacion();
        this.desafiante = desafiante;
        this.desafiado = desafiado;
        this.oroApostado = oro;
        this.validado = false;
    }

    public Desafio(){ }

    public EstadoDesafio getEstado() {
        return this.estado;
    }

    public void setEstado(EstadoDesafio estado) {
        this.estado = estado;
    }


    public void avanzarEstado() {
        this.estado.avanzarEstado(this);
    }


    public void iniciarCombate() {
        this.combate = new Combate();
        this.combate.setDesafiante(this.desafiante);
        this.combate.setDesafiado(this.desafiado);
        this.combate.empezarCombate();
    }


    public boolean isValidado() {
        return this.validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public Combate getCombate() {
        return combate;
    }

    public void setCombate(Combate combate) {
        this.combate = combate;
    }

    public int getOroApostado() {
        return oroApostado;
    }

    public Jugador getDesafiado() {

        return this.desafiado;
    }

    public Jugador getDesafiante() {

        return this.desafiante;
    }

    public void setDesafiante(Jugador desafiante) {
        this.desafiante = desafiante;
    }

    public void setDesafiado(Jugador desafiado) {
        this.desafiado = desafiado;
    }

    public void setOroApostado(int oroApostado) {
        this.oroApostado = oroApostado;
    }

    @Override
    public String toString(){
        StringBuilder desafioString = new StringBuilder();
        desafioString.append("Desafio: "+"\n");
        desafioString.append("Estado: "+this.estado.toString()+"\n");
        desafioString.append("Jugador desafiado: "+this.desafiado.getUserName()+"\n");
        desafioString.append("Jugador desafiante: "+this.desafiante.getUserName()+"\n");
        Integer oro = this.oroApostado;
        desafioString.append("Oro: "+oro+"\n");
        if (this.combate == null)
            desafioString.append("Combate: Aún por realizar");
        else if (this.getEstado() instanceof Rechazado)
            desafioString.append("Combate: sin combate, se rechazó el desafío\n");
        else
            desafioString.append("Combate: "+this.combate.toString()+"\n");
        return desafioString.toString();

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        else if (obj instanceof Desafio){
            if (obj == this)
                return true;
            else {
                if (this.combate == null)
                    return ((Desafio) obj).getDesafiante().equals(this.desafiante) && this.getDesafiado().equals(((Desafio) obj).getDesafiado());
                else
                    return ((Desafio) obj).getDesafiante().equals(this.desafiante) && this.getDesafiado().equals(((Desafio) obj).getDesafiado()) && this.combate.equals(((Desafio) obj).getCombate());
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        if (this.combate == null)
            return this.desafiante.hashCode() + this.desafiado.hashCode();
        else
            return this.desafiante.hashCode() + this.desafiado.hashCode() + this.combate.hashCode();
    }
}