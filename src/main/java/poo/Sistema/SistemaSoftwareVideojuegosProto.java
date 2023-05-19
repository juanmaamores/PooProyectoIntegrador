package poo.Sistema;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.awt.image.*;

@SuppressWarnings("serial")
public class SistemaSoftwareVideojuegosProto extends Frame implements ActionListener, ItemListener {

	private ConfiguracionVideoJuego configJuego1, configJuego2, configJuego3;
	private Label titulo, tituloJuego1, tituloJuego2, tituloJuego3;
	private TextField log;
	private Button iniciarJuego, botonConfig;
	private CheckboxGroup juegos;
	private Checkbox checkBoxJ1, checkBoxJ2, checkBoxJ3;
	private Vector<ConfiguracionVideoJuego> configuraciones;
	private int index = 0;
	private BufferedImage portada1;
	private BufferedImage portada2;
	private BufferedImage portada3;
	private Canvas canvas1;
	private Canvas canvas2;
	private Canvas canvas3;

	public SistemaSoftwareVideojuegosProto() {

		configuraciones = new Vector<ConfiguracionVideoJuego>();
		configJuego1 = new ConfiguracionVideoJuego(this, "1943: Battle of Midway");
		configuraciones.add(configJuego1);
		configJuego2 = new ConfiguracionVideoJuego(this, "Pacman");
		configuraciones.add(configJuego2);
		configJuego3 = new ConfiguracionVideoJuego(this, "Pong");
		configuraciones.add(configJuego3);

		// Configuración de la ventana principal
		setTitle("Sistema de videojuegos");
		setBackground(Color.black);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { // Agregar un WindowListener
				// Acciones a realizar cuando se cierra la ventana principal
				dispose(); // Liberar recursos de la ventana
				System.exit(0); // Cerrar la aplicación
			}
		});

		titulo = new Label("Sistema de videojuegos");
		titulo.setAlignment(Label.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setForeground(Color.white);
		add(titulo, BorderLayout.NORTH);
		tituloJuego1 = new Label("1943: Batalla de Midway", 1);
		tituloJuego2 = new Label("Pacman", 1);
		tituloJuego3 = new Label("Pong original", 1);
		log = new TextField("Sistema iniciado.");
		iniciarJuego = new Button("Iniciar juego");
		iniciarJuego.addActionListener(this);
		botonConfig = new Button("Configurar");
		botonConfig.addActionListener(this);
		juegos = new CheckboxGroup();
		checkBoxJ1 = new Checkbox("", juegos, true);
		checkBoxJ2 = new Checkbox("", juegos, false);
		checkBoxJ3 = new Checkbox("", juegos, false);
		checkBoxJ1.addItemListener(this);
		checkBoxJ2.addItemListener(this);
		checkBoxJ3.addItemListener(this);

		portada1 = loadImage("src//main//resources//img//portada4.jpg");
		if (portada1.getWidth() == -1) {
			System.err.println("La imagen no se cargó correctamente.");
		}
		portada2 = loadImage("src//main//resources//img//portada5.jpg");
		if (portada2.getWidth() == -1) {
			System.err.println("La imagen no se cargó correctamente.");
		}
		portada3 = loadImage("src//main//resources//img//portada6.jpg");
		if (portada3.getWidth() == -1) {
			System.err.println("La imagen no se cargó correctamente.");
		}

		Panel panelCentral = new Panel(new GridLayout(3, 4, 5, 5));
		Panel p1 = new Panel(new FlowLayout());
		p1.setBackground(Color.red);
		canvas1 = new Canvas() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				g.drawImage(portada1, 0, 0, null);
			}
		};
		canvas1.setSize(100,100);
		p1.add(tituloJuego1);
		p1.add(checkBoxJ1);
		p1.add(canvas1);

		Panel p2 = new Panel(new FlowLayout());
		p2.setBackground(Color.green);
		canvas2 = new Canvas() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				g.drawImage(portada2, 0, 0, null);
			}
		};
		canvas2.setSize(100,100);
		p2.add(tituloJuego2);
		p2.add(checkBoxJ2);
		p2.add(canvas2);

		Panel p3 = new Panel(new FlowLayout());
		p3.setBackground(Color.blue);
		canvas3 = new Canvas() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				g.drawImage(portada3, 0, 0, null);
			}
		};
		canvas3.setSize(100,100);
		p3.add(tituloJuego3);
		p3.add(checkBoxJ3);
		p3.add(canvas3);

		Panel p4 = new Panel();
		p4.setBackground(Color.gray);
		Panel p5 = new Panel();
		p5.setBackground(Color.gray);
		Panel p6 = new Panel();
		p6.setBackground(Color.gray);
		Panel p7 = new Panel();
		p7.setBackground(Color.gray);
		Panel p8 = new Panel();
		p8.setBackground(Color.gray);
		Panel p9 = new Panel();
		p9.setBackground(Color.gray);
		Panel p10 = new Panel();
		p10.setBackground(Color.gray);
		Panel p11 = new Panel();
		p11.setBackground(Color.gray);
		Panel p12 = new Panel();
		p12.setBackground(Color.white);
		p12.add(log);
		p12.add(iniciarJuego);
		p12.add(botonConfig);
		panelCentral.add(p1);
		panelCentral.add(p2);
		panelCentral.add(p3);
		panelCentral.add(p4);
		panelCentral.add(p5);
		panelCentral.add(p6);
		panelCentral.add(p7);
		panelCentral.add(p8);
		panelCentral.add(p9);
		panelCentral.add(p10);
		panelCentral.add(p11);
		panelCentral.add(p12);
		add(panelCentral, BorderLayout.CENTER);
		pack();
		setSize(750, 500);
		setLocationRelativeTo(null); // Centrar la ventana
		setResizable(false); // Evitar que se pueda cambiar el tamaño
		setVisible(true);
	}


	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource() == checkBoxJ1) {
			index = 0;
		}
		if (e.getSource() == checkBoxJ2) {
			index = 1;
		}
		if (e.getSource() == checkBoxJ3) {
			index = 2;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == iniciarJuego) {
			this.ejecutar();
		}
		if (e.getSource() == botonConfig) {
			configuraciones.get(index).mostrar();
			//log.setText("Configuraciones");
		}
	}

	public static void main(String[] args) {

		SistemaSoftwareVideojuegosProto sys = new SistemaSoftwareVideojuegosProto();
	}

	private void ejecutar() {

		log.setText("Juego iniciado");
	}

	// Carga la imagen desde el archivo y la convierte en un BufferedImage
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

}