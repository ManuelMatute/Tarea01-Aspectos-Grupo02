package Observer;
 import java.util.ArrayList;
import java.util.List;

public class Sujeto {
   


    private final List<Observador> observadores = new ArrayList<>();

    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    public void notificar(Color color) {
        for (Observador o : observadores) {
            o.actualizar(color);
        }
    }
}

