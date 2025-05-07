package SistemaPersistencia;

import Herramientas.Jugador;
import Herramientas.Usuario;
import Personajes.Personaje;

import java.util.*;

public class UsersData {

    private Map <Jugador, Personaje> personajesJugadores;
    private Map <String, Usuario> usuarios;
    private Login login;
    private AlmacenDesafios almacenDesafios;
    private PriorityQueue<Jugador> ranking;

    public UsersData() {
    }

    public Map<Jugador, Personaje> getPersonajesJugadores() {
        return personajesJugadores;
    }

    public void setPersonajesJugadores(Map<Jugador, Personaje> personajesJugadores) {
        this.personajesJugadores = personajesJugadores;
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Map<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public AlmacenDesafios getAlmacenDesafios() {
        return almacenDesafios;
    }

    public void setAlmacenDesafios(AlmacenDesafios almacenDesafios) {
        this.almacenDesafios = almacenDesafios;
    }

    public PriorityQueue<Jugador> getRanking() {
        return ranking;
    }

    public void setRanking(PriorityQueue<Jugador> ranking) {
        this.ranking = ranking;
    }

    public Usuario getUsuarioByNick(String nick) {
        return usuarios.get(nick);
    }

    public Personaje getPersonajeUsuario(Jugador user) {
        return personajesJugadores.get(user);
    }

    public Login getLogin() {
        return login;
    }

    public AlmacenDesafios getDesafios() {
        return almacenDesafios;
    }


    public void addNewUser(Usuario user) {
        this.usuarios.put((user.getUserName()), user);
        if (user instanceof Jugador && ((Jugador) user).getPersonaje() != null ) {
            this.personajesJugadores.put((Jugador)user, ((Jugador) user).getPersonaje());
        }
    }

    public void mostrarJugadores(){
        for (Usuario u : usuarios.values()){
            if (u instanceof Jugador){
                System.out.println(u.getUserName());
            }
        }
    }

    public void mostrarBloqueados(){
        for (Usuario u : usuarios.values()){
            if (u instanceof Jugador j){
                if (j.isBlock())
                    System.out.println(u.getUserName());
            }
        }
    }
}