package Observer;

import java.awt.Color;

import observer.VentanaPrincipal;
import observer.pointcut;

public aspect ColorAspect {

    private static int contadorCambios = 0;

    pointcut cambioColor(Color color, String nombreColor, VentanaPrincipal ventana) :
        execution(void observer.VentanaPrincipal.cambiarColor(Color, String)) &&
        args(color, nombreColor) &&
        this(ventana);

    after(Color color, String nombreColor, VentanaPrincipal ventana) : cambioColor(color, nombreColor, ventana) {
        contadorCambios++;

        
        ventana.getSujeto().notificar("AspectJ: El color cambió a " + nombreColor);

        
        System.out.println("AspectJ: El color cambió a " + nombreColor);
        System.out.println("Número de cambios acumulados: " + contadorCambios);

        
        ventana.actualizarContador(contadorCambios);
    }
}