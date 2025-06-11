package observer;
import java.util.ArrayList;
import java.util.List;

import observer.Observador;

public class Sujeto {
    private final List<Observador> observadores = new ArrayList<>();

    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    public void notificar(String mensaje) {
        for (Observador o : observadores) {
            o.actualizar(mensaje);
        }
    }
}

