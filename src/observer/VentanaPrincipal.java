package observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    private final Sujeto sujeto;
    private JLabel labelContador = new JLabel("Cambios: 0");

    public VentanaPrincipal(Sujeto sujeto) {
        this.sujeto = sujeto;

        setTitle("Cambio de Color");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton btnRojo = new JButton("Rojo");
        JButton btnVerde = new JButton("Verde");
        JButton btnAzul = new JButton("Azul");

        add(btnRojo);
        add(btnVerde);
        add(btnAzul);
        add(labelContador);  // contador

        btnRojo.addActionListener(e -> cambiarColor(Color.RED, "Rojo"));
        btnVerde.addActionListener(e -> cambiarColor(Color.GREEN, "Verde"));
        btnAzul.addActionListener(e -> cambiarColor(Color.BLUE, "Azul"));
    }

    public void cambiarColor(Color color, String nombreColor) {
        getContentPane().setBackground(color);
        
    }

    public void actualizarContador(int valor) {
        labelContador.setText("Cambios: " + valor);
    }

    public Sujeto getSujeto() {
        return sujeto;
    }

    public static void main(String[] args) {
        Sujeto sujeto = new Sujeto();
        sujeto.agregarObservador(mensaje -> System.out.println("Observador recibió: " + mensaje));

        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal(sujeto);
            ventana.setVisible(true);
        });
    }
}