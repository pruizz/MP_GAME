import Herramientas.Manager;
import SistemaPersistencia.*;
import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args) {

        PersistenciaManager p = PersistenciaManager.getInstance();
        Manager m = new Manager();
        m.start();

        try {
            p.getPersistencia().saveDataInDisk();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}