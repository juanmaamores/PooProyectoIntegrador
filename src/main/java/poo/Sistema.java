package poo;

import poo.Otros.ConfiguracionVideoJuego;
import poo.Otros.Ranking;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.image.*;

public class Sistema extends Frame implements ActionListener, ItemListener {

	private static String juegoSeleccionado = "1943: Battle Of Midway";
	private static final int nuevoRecord = 0;
	private static final TextField nombreJugador = new TextField("Nombre");
	private final Ranking ranking = new Ranking(this, juegoSeleccionado);
	private final ConfiguracionVideoJuego configJuego1, configJuego2, configJuego3;
	private final Label titulo, tituloJuego1, tituloJuego2, tituloJuego3, nombreJugadorLabel1, nombreJugadorLabel2;
	private final Button iniciarJuego, botonConfig, botonRanking;
	private final CheckboxGroup juegos;
	private final Checkbox checkBoxJ1, checkBoxJ2, checkBoxJ3;
	private final Vector<ConfiguracionVideoJuego> configuraciones;
	private final BufferedImage portada1, portada2, portada3;
	private final Canvas canvas1, canvas2, canvas3;
	private int index = 0;

	public Sistema() {
		configuraciones = new Vector<>();
		configJuego1 = new ConfiguracionVideoJuego(this, "1943: Battle Of Midway", 0);
		configuraciones.add(configJuego1);
		configJuego2 = new ConfiguracionVideoJuego(this, "Pacman", 1);
		configuraciones.add(configJuego2);
		configJuego3 = new ConfiguracionVideoJuego(this, "Pong", 2);
		configuraciones.add(configJuego3);
		nombreJugadorLabel1 = new Label("Ingrese su nombre");
		nombreJugadorLabel2 = new Label("");
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
		//log = new TextField("Sistema iniciado.");
		iniciarJuego = new Button("Iniciar juego");
		iniciarJuego.addActionListener(this);
		botonConfig = new Button("Configurar");
		botonConfig.addActionListener(this);
		botonRanking = new Button("Ranking");
		botonRanking.addActionListener(this);
		juegos = new CheckboxGroup();
		checkBoxJ1 = new Checkbox("", juegos, true);
		checkBoxJ2 = new Checkbox("", juegos, false);
		checkBoxJ3 = new Checkbox("", juegos, false);
		checkBoxJ1.addItemListener(this);
		checkBoxJ2.addItemListener(this);
		checkBoxJ3.addItemListener(this);
		portada1 = loadImage("src//main//resources//img//portada4.jpg");
		assert portada1 != null;
		if (portada1.getWidth() == -1) {
			System.err.println("La imagen no se cargó correctamente.");
		}
		portada2 = loadImage("src//main//resources//img//portada5.jpg");
		assert portada2 != null;
		if (portada2.getWidth() == -1) {
			System.err.println("La imagen no se cargó correctamente.");
		}
		portada3 = loadImage("src//main//resources//img//portada6.jpg");
		assert portada3 != null;
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
		p12.setLayout(new BoxLayout(p12, BoxLayout.Y_AXIS));
		p12.setBackground(Color.white);
		p12.add(nombreJugadorLabel1);
		p12.add(nombreJugador);
		p12.add(iniciarJuego);
		p12.add(nombreJugadorLabel2);
		p12.add(botonConfig);
		p12.add(botonRanking);
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
		//setResizable(false); // Evitar que se pueda cambiar el tamaño
		setVisible(true);
	}

	public static void cargarRecord(int puntajeMaximo) throws SQLException {
		Ranking.actualizarRanking(nombreJugador.getText(), puntajeMaximo, juegoSeleccionado);
	}

	public static int pasarRecordJugador() throws SQLException {
		return Ranking.obtenerRecordJugador(juegoSeleccionado, nombreJugador.getText());
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource() == checkBoxJ1) {
			index = 0;
			juegoSeleccionado = "1943: Battle Of Midway";
		}
		if (e.getSource() == checkBoxJ2) {
			index = 1;
			juegoSeleccionado = "PacMan";
		}
		if (e.getSource() == checkBoxJ3) {
			index = 2;
			juegoSeleccionado = "Pong";
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == iniciarJuego) {
			if(nombreJugador.getText().equals("Nombre")){
				nombreJugadorLabel2.setText("Por favor ingrese su nombre!");
			} else {
				this.ejecutar();
			}
		}
		if (e.getSource() == botonConfig) {
			configuraciones.get(index).mostrar();
			//log.setText("Configuraciones");
		}
		if (e.getSource() == botonRanking) {
			try {
				Ranking.cargarResultados(juegoSeleccionado);
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
			ranking.mostrar();
		}
	}

	private void ejecutar() {
		setVisible(false);
		Thread juegoThread = new Thread(() -> {
			Juego1943 game = new Juego1943();
			game.run(1.0 / 60.0);
		});
		juegoThread.start();
		setVisible(true);
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

	public static void main(String[] args) {
		Sistema sys = new Sistema();
	}
}
