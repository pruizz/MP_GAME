package Herramientas;

import Personajes.Personaje;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Jugador extends Usuario {
    private Personaje personaje;
    private boolean block;
    private List<String> notificaciones;


    public Jugador(String name, String pass) {
        this.block = false;
        this.userName = name;
        this.password = pass;
        this.herramientas = new HerramientasDeJugador(this);
    }

    public Jugador() { }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public Personaje getPersonaje() {
        return this.personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
        ((HerramientasDeJugador) this.herramientas).getGestorEquipamiento().setPersonaje(personaje);
    }

    public List<String> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<String> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public void addNotificación(String n){
        if (this.notificaciones == null)
                this.notificaciones = new LinkedList<>();
        this.notificaciones.add(n);
    }

    public void verNotificaciones(){
        if (this.notificaciones == null)
            return;
        for (String s : this.notificaciones){
            System.out.println(s);
        }
        this.notificaciones.clear();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(userName, jugador.userName) &&
                Objects.equals(password, jugador.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Jugador){
            if (this.personaje.getOro() == ((Jugador) o).getPersonaje().getOro())
                return 0;
            else if (this.personaje.getOro() < ((Jugador) o).getPersonaje().getOro())
                return 1;
            else
                return -1;
        }
        return 0;
    }


}