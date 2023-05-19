package poo.Sistema;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class ConfiguracionVideoJuego extends Frame implements ActionListener, ItemListener{
	
	private CheckboxGroup pantalla;
	private Checkbox sonidoActivo, musicaActivo, ventana, pantallaCompleta;
	private Choice seleccionMusica, seleccionPersonaje;
	private Button guardar, reset;
	private Label titulo, personajeLabel, pistaMusical;
	private Label teclaEspacio, teclaIzq, teclaDer, teclaArriba, teclaAbajo, teclaX, teclaZ, teclaQ, teclaW, teclaEnter;
	private TextField tf, tfTeclaQ, tfTeclaW, tfTeclaEspacio, tfTeclaIzq, tfTeclaDer, tfTeclaArriba, tfTeclaAbajo, tfTeclaX, tfTeclaZ, tfTeclaEnter;
	private boolean pantallaCompletaActiva = false;
	
	public ConfiguracionVideoJuego(Frame v, String nombreJuego) {
		
		setTitle("Configuraciones de " + nombreJuego);
		setSize(600, 600);
		setLocationRelativeTo(v);
		setLayout(new BorderLayout());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// Acciones a realizar cuando se cierra la ventana principal
				dispose(); // Liberar recursos de la ventana
			}
		});

		// Componentes para el titulo de la ventana
		titulo = new Label("Configuración del videojuego " + nombreJuego);
		titulo.setAlignment(Label.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setForeground(Color.white);
		add(titulo, BorderLayout.NORTH);
		setBackground(Color.black);

		tf = new TextField("...............................");
		// tf.setSize(200,100); no funciona.
		
		// Componetes para la sección de pantalla
		pantalla = new CheckboxGroup();
		ventana = new Checkbox("Ventana", pantalla, true);
		pantallaCompleta = new Checkbox("Pantalla Completa", pantalla, false);
		ventana.addItemListener(this);
		pantallaCompleta.addItemListener(this);
	
		// Componententes para la sección de sonido
		sonidoActivo = new Checkbox("Efectos de sonido", true);
		musicaActivo = new Checkbox("Música de fondo", true);
		sonidoActivo.addItemListener(this);
		musicaActivo.addItemListener(this);
		
		// Componentes para la sección de teclas
		teclaQ = new Label("Activar/desactivar efectos de sonido:");
		teclaW = new Label("Activar/desactivar música de fondo.");
		teclaEspacio = new Label("Pausar/reanudar el juego.");
		teclaIzq = new Label("Izquierda.");
		teclaDer = new Label("Derecha.");
		teclaArriba = new Label("Arriba.");
		teclaAbajo = new Label("Abajo.");
		teclaX = new Label("Disparo.");
		teclaZ = new Label("Ataque especial.");
		teclaEnter = new Label("Inicar el juego.");
		// Textfield teclas
		tfTeclaQ = new TextField("Q");
		tfTeclaW = new TextField("W");
		tfTeclaEspacio = new TextField("Barra espaciadora");
		tfTeclaIzq = new TextField("Flecha Izquierda");
		tfTeclaDer = new TextField("Flecha derecha");
		tfTeclaArriba = new TextField("Flecha arriba");
		tfTeclaAbajo = new TextField("Flecha abajo");
		tfTeclaX = new TextField("X");
		tfTeclaZ = new TextField("Z");
		tfTeclaEnter = new TextField("Enter");
		
		// Componentes para la selección de musica.
		pistaMusical = new Label("Pista musical:");
		seleccionMusica = new Choice();
		seleccionMusica.add("Tema original");
		seleccionMusica.add("Tema alternativo 1");
		seleccionMusica.add("Tema alternativo 2");
		
		// Componentes para la seleccion de personaje.
		personajeLabel = new Label("Personaje:");
		seleccionPersonaje = new Choice();
		seleccionPersonaje.add("Original");
		seleccionPersonaje.add("Personaje 2");
		seleccionPersonaje.add("Personaje 3");
		
		// Componentes para los botones de guardar y reset
		guardar = new Button("Guardar");
		reset = new Button("Reset");
		guardar.addActionListener(this);
		reset.addActionListener(this);

		Panel panelCentral = new Panel(new GridLayout(14,1,0,0));
		panelCentral.setBackground(Color.black);
		
		//Panel ventana
		Panel configVentana = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configVentana.setBackground(Color.red);
		configVentana.add(ventana);
		configVentana.add(pantallaCompleta);
		panelCentral.add(configVentana);
		
		//panel sonido
		Panel configSonido = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configSonido.setBackground(Color.yellow);
		configSonido.add(sonidoActivo);
		configSonido.add(musicaActivo);
		configSonido.add(pistaMusical);
		configSonido.add(seleccionMusica);
		panelCentral.add(configSonido);
		
		//Panel teclas
		Panel configTeclas1 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas1.setBackground(Color.orange);
		configTeclas1.add(teclaQ);
		configTeclas1.add(tfTeclaQ);
		panelCentral.add(configTeclas1);
		Panel configTeclas2 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas2.setBackground(Color.orange);
		configTeclas2.add(teclaW);
		configTeclas2.add(tfTeclaW);
		panelCentral.add(configTeclas2);
		Panel configTeclas3 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas3.setBackground(Color.orange);
		configTeclas3.add(teclaEspacio);
		configTeclas3.add(tfTeclaEspacio);
		panelCentral.add(configTeclas3);
		Panel configTeclas4 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas4.setBackground(Color.orange);
		configTeclas4.add(teclaIzq);
		configTeclas4.add(tfTeclaIzq);
		panelCentral.add(configTeclas4);
		Panel configTeclas5 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas5.setBackground(Color.orange);
		configTeclas5.add(teclaDer);
		configTeclas5.add(tfTeclaDer);
		panelCentral.add(configTeclas5);
		Panel configTeclas6 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas6.setBackground(Color.orange);
		configTeclas6.add(teclaArriba);
		configTeclas6.add(tfTeclaArriba);
		panelCentral.add(configTeclas6);
		Panel configTeclas7 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas7.setBackground(Color.orange);
		configTeclas7.add(teclaAbajo);
		configTeclas7.add(tfTeclaAbajo);
		panelCentral.add(configTeclas7);
		Panel configTeclas8 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas8.setBackground(Color.orange);
		configTeclas8.add(teclaX);
		configTeclas8.add(tfTeclaX);
		panelCentral.add(configTeclas8);
		Panel configTeclas9 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas9.setBackground(Color.orange);
		configTeclas9.add(teclaZ);
		configTeclas9.add(tfTeclaZ);
		panelCentral.add(configTeclas9);
		Panel configTeclas10 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas10.setBackground(Color.orange);
		configTeclas10.add(teclaEnter);
		configTeclas10.add(tfTeclaEnter);
		panelCentral.add(configTeclas10);
		
		//panel personaje
		Panel configPersonaje = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configPersonaje.setBackground(Color.cyan);
		configPersonaje.add(personajeLabel);
		configPersonaje.add(seleccionPersonaje);
		panelCentral.add(configPersonaje);
		
		//botones
		Panel panelBotones = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		panelBotones.setBackground(Color.magenta);
		panelBotones.add(guardar);
		panelBotones.add(reset);
		panelBotones.add(tf);
		panelCentral.add(panelBotones);
		add(panelCentral, BorderLayout.CENTER);
		pack();
		setResizable(false); // Evitar que se pueda cambiar el tamaño
	}
	
	/*public static void main(String[] args) {
		
		// Crear una instancia de ejercicios.ConfiguracionVideoJuego
	    ejercicios.ConfiguracionVideoJuego configuracion = new ejercicios.ConfiguracionVideoJuego();

	    // Configurar la ventana
	    configuracion.setSize(800, 450);
	    configuracion.setLocationRelativeTo(null); // Centrar la ventana
	    configuracion.setResizable(false); // Evitar que se pueda cambiar el tamaño
	    configuracion.setVisible(true); // Hacer la ventana visible
	    
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == reset) {
			tf.setText("Los valores se han reiniciado.");
			if (pantallaCompletaActiva) {
				pantallaCompletaActiva = false;
				pantallaCompleta.setState(false);
				ventana.setState(true);
			}
			
			sonidoActivo.setState(true);
			musicaActivo.setState(true);
			seleccionMusica.select(0);
			seleccionPersonaje.select(0);
			
			tfTeclaQ.setText("Q");
			tfTeclaW.setText("W");
			tfTeclaEspacio.setText("Barra espaciadora");
			tfTeclaIzq.setText("Flecha izquierda");
			tfTeclaDer.setText("Flecha derecha");
			tfTeclaArriba.setText("Flecha arriba");
			tfTeclaAbajo.setText("Flecha abajo");
			tfTeclaX.setText("X");
			tfTeclaZ.setText("Z");
			tfTeclaEnter.setText("Enter");
		}
		
		if(e.getSource() == guardar) {
			tf.setText("Los valores se han guardado.");
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource() == pantallaCompleta) {
			if (!pantallaCompletaActiva) {
				pantallaCompletaActiva = true; // Establecer variable de estado en true
				tf.setText("Checkbox de pantalla completa presionado.");
			}
		} else if (e.getSource() == ventana) {
			if (pantallaCompletaActiva) {
				pantallaCompletaActiva = false; // Establecer variable de estado en false
				tf.setText("Checkbox de ventana presionado.");
			}
		}
		
		if (e.getSource() == sonidoActivo) {
			if(e.getStateChange() == 1) {
				tf.setText("Sonido activado.");
			} else {
				tf.setText("Sonido desactivado.");
			}
			
		}
		
		if (e.getSource() == musicaActivo) {
			if(e.getStateChange() == 1) {
				tf.setText("Musica activada.");
			} else {
				tf.setText("Musica desactivada.");
			}
		}
	}
	
	public void mostrar() {
		setVisible(true);
	}

}
