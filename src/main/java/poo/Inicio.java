package poo;

import poo.Sistema.Pantalla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class Inicio extends Pantalla {
    private Panel panel;
    private String nombreJugador;
    private TextField insertarNombre;
    private Label l1;
    private BufferedImage bfPortada;
    private Canvas cPortada;

    public Inicio(Frame v){

        l1 = new Label("Presione enter para jugar");
        insertarNombre = new TextField();
        insertarNombre.setPreferredSize(new Dimension(200,24));
        insertarNombre.setText("nombre");
        insertarNombre.addActionListener(this);

        //portada
        bfPortada = loadImage("src//main//resources//img//portada.png");
                //panel
        panel = new Panel(new GridBagLayout());
        panel.setBackground(Color.lightGray);
        GridBagConstraints gbc = new GridBagConstraints();

        cPortada = new Canvas() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.drawImage(bfPortada, 0, 0, null);
            }
        };
        cPortada.setSize(493,265);

        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets.bottom = 10; // Espacio entre los componentes

        gbc.gridy = 0;
        panel.add(cPortada,gbc);
        gbc.gridy++;
        panel.add(l1,gbc);
        gbc.gridy++;
        panel.add(insertarNombre,gbc);
        add(panel);

        // Configuración de la inicio

        setTitle("1943: The Battle of Midway");
        setSize(800, 600);
        setBackground(Color.black);
        setLocationRelativeTo(v);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo la ventana Inicio
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Acciones a realizar cuando se cierra la ventana principal
                dispose(); // Liberar recursos de la ventana
            }
        });
        setResizable(false); // Evitar que se pueda cambiar el tamaño
        setVisible(true);
    }

    private BufferedImage loadImage(String fileName) {
        try {
            Image image = Toolkit.getDefaultToolkit().getImage(fileName);
            MediaTracker tracker = new MediaTracker(this);
            tracker.addImage(image, 0);
            tracker.waitForAll();
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bufferedImage.createGraphics();
            g2d.drawImage(image, 0, 0, null);
            g2d.dispose();
            return bufferedImage;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == insertarNombre){
            setVisible(false);
            nombreJugador = insertarNombre.getText();
            System.out.println("El nombre del jugador es: "+nombreJugador);
            Thread juegoThread = new Thread(() -> {
                Juego1943 game = new Juego1943();
                game.run(1.0 / 60.0);
            });
            juegoThread.start();
        }
    }
}
