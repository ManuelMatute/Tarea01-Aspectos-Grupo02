package observer;

import java.awt.Color;

public aspect ColorAspect {

    private static int contadorCambios = 0;

    pointcut cambioColor(Color color, String nombreColor, VentanaPrincipal ventana) :
        execution(void observer.VentanaPrincipal.cambiarColor(Color, String)) &&
        args(color, nombreColor) &&
        this(ventana);

    after(Color color, String nombreColor, VentanaPrincipal ventana) : cambioColor(color, nombreColor, ventana) {
        contadorCambios++;

        // Notificar a observadores
        ventana.getSujeto().notificar("AspectJ: El color cambió a " + nombreColor);

        // Imprimir en consola
        System.out.println("AspectJ: El color cambió a " + nombreColor);
        System.out.println("Número de cambios acumulados: " + contadorCambios);

        // Actualizar contador en la GUI de forma segura
        javax.swing.SwingUtilities.invokeLater(() -> {
            ventana.actualizarContador(contadorCambios);
        });
    }
}