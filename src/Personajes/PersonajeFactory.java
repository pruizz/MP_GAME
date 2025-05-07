package Personajes;

import SistemaPersistencia.Equipamiento;
import SistemaPersistencia.PersistenciaManager;
import SistemaPersistencia.RegistroEquipamiento;

import java.util.*;

public abstract class PersonajeFactory {

    public abstract Personaje crearPersonaje();


    public void solicitarDatos(Personaje personaje,Scanner scanner) {
        Random random = new Random();
        System.out.println("¡Bienvenido a la creación de personaje!");
        System.out.println("Introduzca el nombre del personaje: ");
        String nombre = scanner.nextLine();
        while (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío. Introduzca el nombre de nuevo:");
            nombre = scanner.nextLine().trim();
        }
        personaje.setNombre(nombre);

        System.out.println("Por la estabilidad del juego, el valor de poder se asignarán aleatoriamente, "
                + "así como el oro tendrá un valor inicial.");
        System.out.println("Oro inicial: " + "100" + " monedas brillantes");
        System.out.println("Salud inicial: 5 puntos (entre 1 y 5)");
        System.out.println("Su personaje obtendra aleatoriamente un numero aleatorio de esbirros que podran ser de diferentes tipos");

        AlmacenEsbirros almacen = new AlmacenEsbirros(new ArrayList<Esbirro>());
        int maxEsbirros = 5;
        Esbirro esbirro = this.generarEsbirro(random);
        maxEsbirros--;
        almacen.aniadirEsbirro(esbirro);

        while (esbirro instanceof Demonios && maxEsbirros>0) {
            AlmacenEsbirros almacenDemonio = ((Demonios) esbirro).getEsbirros();
            esbirro = generarEsbirro(random);
            maxEsbirros--;
            almacenDemonio.aniadirEsbirro(esbirro);

         }
        personaje.setEsbirros(almacen);

        personaje.setEquipo(new Equipo());
        personaje.getEquipo().setArmaduras(new HashMap<String, Armadura>());
        personaje.getEquipo().setArmas(new HashMap<String, Arma>());

        RegistroEquipamiento equipamientoDisponible =PersistenciaManager.getInstance().getPersistencia().getGameData().getEquipamiento();
        Map<String, Arma> armasPersonaje = personaje.getEquipo().getArmas();
        Map<String, Armadura> armadurasPersonaje = personaje.getEquipo().getArmaduras();

        insertarArmas(personaje, equipamientoDisponible, scanner, armasPersonaje);
        insertarArmaduras(personaje, equipamientoDisponible, scanner, armadurasPersonaje);

    }

    private void insertarArmaduras(Personaje personaje, RegistroEquipamiento equipamientoDisponible, Scanner scanner, Map<String, Armadura> armadurasPersonaje) {
        TreeSet<String> equipPicked = new TreeSet<>();
        int i = 0;
        while (equipPicked.size() < 2) {
            System.out.println("Seleccione una armadura para su personaje:");
            equipamientoDisponible.mostrarArmaduras();
            String idArmadura = scanner.nextLine();
            Equipamiento armadura = equipamientoDisponible.getById(idArmadura);
            if (armadura == null || equipPicked.contains(idArmadura)) {
                System.out.println("Pieza de equipo no válida, elija otra vez");
            } else {
                equipPicked.add(idArmadura);
                armadurasPersonaje.put(idArmadura, (Armadura) armadura);
                if (i == 0) {
                    personaje.getEquipo().setNombreArmaduraActiva(idArmadura);
                    System.out.println("Ha seleccionado su armadura activa");
                } else  {
                    System.out.println("Ha seleccionado su armadura secundaria");
                }
                i++;
            }
        }
    }

    private void insertarArmas(Personaje personaje, RegistroEquipamiento equipamientoDisponible, Scanner scanner, Map<String, Arma> armasPersonaje) {
        TreeSet<String> equipPicked = new TreeSet<>();
        int i = 0;
        while (equipPicked.size() < 2) {
            System.out.println("Seleccione un arma para su personaje:");
            equipamientoDisponible.mostrarArmas();
            String idArma = scanner.nextLine();
            Equipamiento arma = equipamientoDisponible.getById(idArma);
            if (arma == null || equipPicked.contains(idArma)){
                System.out.println("Pieza de equipo no válida, elija otra vez");
            } else {
                equipPicked.add(idArma);
                armasPersonaje.put(idArma, (Arma) arma);
                if (i == 0) {
                    personaje.getEquipo().setNombreArmaActiva(idArma);
                    System.out.println("Ha seleccionado su arma activa");
                }
                else {
                    System.out.println("Ha seleccionado su arma secundaria");
                }
                i++;
            }

        }
    }


    private Esbirro generarEsbirro(Random random) {
        int tipoEsbirro = random.nextInt(3);
        Esbirro e;
        switch (tipoEsbirro){
            case 0: e = new Humanos();
                    e.initialize();
                    break;
            case 1: e = new Demonios();
                    e.initialize();
                    break;
            case 2: e = new Ghouls();
                    e.initialize();
                    break;
            default: throw new IllegalStateException("Tipo de esbirro desconocido: " + tipoEsbirro);
        }
        return e;
    }

}