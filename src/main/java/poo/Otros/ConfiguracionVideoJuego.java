package poo.Otros;
import java.awt.*;
import java.awt.event.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ConfiguracionVideoJuego extends Frame implements ActionListener, ItemListener{

	private final CheckboxGroup pantalla;
	private final Checkbox sonidoActivo, musicaActivo, ventana, pantallaCompleta;
	private final Button guardar, reset;
	private final Label log = new Label("____________________________");
	private final Label titulo,pistaMusical, teclaEspacio, teclaIzq, teclaDer, teclaArriba, teclaAbajo, teclaX, teclaZ, teclaQ, teclaW, teclaEnter;
	private final Choice seleccionMusica, chTeclaQ, chTeclaW, chTeclaEspacio, chTeclaIzq, chTeclaDer, chTeclaArriba, chTeclaAbajo, chTeclaX, chTeclaZ, chTeclaEnter;
	private boolean pantallaCompletaActiva = false;
	private final String ARCHIVO_CONFIGURACION1943 = "src\\main\\resources\\conf\\configuracion1943.properties";
	private int index;

	public ConfiguracionVideoJuego(Frame v, String nombreJuego, int index) {
		
		setTitle("Configuraciones de " + nombreJuego);
		setSize(600, 600);
		setLocationRelativeTo(v);
		setLayout(new BorderLayout());
		this.index = index;
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// Acciones a realizar cuando se cierra la ventana principal
				dispose(); // Liberar recursos de la ventana
			}
		});

		// Componentes para el titulo de la ventana
		titulo = new Label("Configuracion del videojuego " + nombreJuego);
		titulo.setAlignment(Label.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setForeground(Color.white);
		add(titulo, BorderLayout.NORTH);
		setBackground(Color.black);

		// Componetes para la sección de pantalla
		pantalla = new CheckboxGroup();
		ventana = new Checkbox("Ventana", pantalla, true);
		pantallaCompleta = new Checkbox("Pantalla Completa", pantalla, false);
		ventana.addItemListener(this);
		pantallaCompleta.addItemListener(this);
	
		// Componententes para la sección de sonido
		sonidoActivo = new Checkbox("Efectos de sonido", true);
		musicaActivo = new Checkbox("Musica de fondo", true);
		sonidoActivo.addItemListener(this);
		musicaActivo.addItemListener(this);
		
		// Componentes para la sección de teclas
		teclaQ = new Label("Activar/desactivar efectos de sonido:");
		teclaW = new Label("Activar/desactivar musica de fondo:");
		teclaEspacio = new Label("Pausar/reanudar el juego:");
		teclaIzq = new Label("Izquierda:");
		teclaDer = new Label("Derecha:");
		teclaArriba = new Label("Arriba:");
		teclaAbajo = new Label("Abajo:");
		teclaX = new Label("Disparo:");
		teclaZ = new Label("Ataque especial:");
		teclaEnter = new Label("Inicar el juego:");

		// choice teclas
		chTeclaQ = new Choice();
		chTeclaQ.add("Q");
		chTeclaQ.add("O");

		chTeclaW = new Choice();
		chTeclaW.add("W");
		chTeclaW.add("I");

		chTeclaEspacio = new Choice();
		chTeclaEspacio.add("Barra espaciadora");
		chTeclaEspacio.add("P"); //Pausa

		chTeclaIzq = new Choice();
		chTeclaIzq.add("Flecha izquierda");
		chTeclaIzq.add("A");

		chTeclaDer = new Choice();
		chTeclaDer.add("Flecha derecha");
		chTeclaDer.add("D");

		chTeclaArriba = new Choice();
		chTeclaArriba.add("Flecha arriba");
		chTeclaArriba.add("W");

		chTeclaAbajo = new Choice();
		chTeclaAbajo.add("Flecha abajo");
		chTeclaAbajo.add("S");

		chTeclaX = new Choice();
		chTeclaX.add("X");
		chTeclaX.add("Barra espaciadora");

		chTeclaZ = new Choice();
		chTeclaZ.add("Z");
		chTeclaZ.add("B"); //bomba

		chTeclaEnter = new Choice();
		chTeclaEnter.add("Enter");
		chTeclaEnter.add("C"); //comenzar
		
		// Componentes para la selección de musica.
		pistaMusical = new Label("Pista musical:");
		seleccionMusica = new Choice();
		seleccionMusica.add("Tema original");
		seleccionMusica.add("Tema alternativo 1");
		seleccionMusica.add("Tema alternativo 2");
		
		// Componentes para los botones de guardar y reset
		guardar = new Button("Guardar");
		reset = new Button("Reset");
		guardar.addActionListener(this);
		reset.addActionListener(this);

		Panel panelCentral = new Panel(new GridLayout(13,1,0,0));
		panelCentral.setBackground(Color.black);
		
		//Panel ventana
		Panel configVentana = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configVentana.setBackground(Color.lightGray);
		configVentana.add(ventana);
		configVentana.add(pantallaCompleta);
		panelCentral.add(configVentana);
		
		//panel sonido
		Panel configSonido = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configSonido.setBackground(Color.lightGray);
		configSonido.add(sonidoActivo);
		configSonido.add(musicaActivo);
		configSonido.add(pistaMusical);
		configSonido.add(seleccionMusica);
		panelCentral.add(configSonido);
		
		//Panel teclas
		Panel configTeclas1 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas1.setBackground(Color.lightGray);
		configTeclas1.add(teclaQ);
		configTeclas1.add(chTeclaQ);
		panelCentral.add(configTeclas1);
		Panel configTeclas2 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas2.setBackground(Color.lightGray);
		configTeclas2.add(teclaW);
		configTeclas2.add(chTeclaW);
		panelCentral.add(configTeclas2);
		Panel configTeclas3 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas3.setBackground(Color.lightGray);
		configTeclas3.add(teclaEspacio);
		configTeclas3.add(chTeclaEspacio);
		panelCentral.add(configTeclas3);
		Panel configTeclas4 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas4.setBackground(Color.lightGray);
		configTeclas4.add(teclaIzq);
		configTeclas4.add(chTeclaIzq);
		panelCentral.add(configTeclas4);
		Panel configTeclas5 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas5.setBackground(Color.lightGray);
		configTeclas5.add(teclaDer);
		configTeclas5.add(chTeclaDer);
		panelCentral.add(configTeclas5);
		Panel configTeclas6 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas6.setBackground(Color.lightGray);
		configTeclas6.add(teclaArriba);
		configTeclas6.add(chTeclaArriba);
		panelCentral.add(configTeclas6);
		Panel configTeclas7 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas7.setBackground(Color.lightGray);
		configTeclas7.add(teclaAbajo);
		configTeclas7.add(chTeclaAbajo);
		panelCentral.add(configTeclas7);
		Panel configTeclas8 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas8.setBackground(Color.lightGray);
		configTeclas8.add(teclaX);
		configTeclas8.add(chTeclaX);
		panelCentral.add(configTeclas8);
		Panel configTeclas9 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas9.setBackground(Color.lightGray);
		configTeclas9.add(teclaZ);
		configTeclas9.add(chTeclaZ);
		panelCentral.add(configTeclas9);
		Panel configTeclas10 = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		configTeclas10.setBackground(Color.lightGray);
		configTeclas10.add(teclaEnter);
		configTeclas10.add(chTeclaEnter);
		panelCentral.add(configTeclas10);
		
		//botones
		Panel panelBotones = new Panel(new FlowLayout(FlowLayout.LEFT,5,0));
		panelBotones.setBackground(Color.lightGray);
		panelBotones.add(guardar);
		panelBotones.add(reset);
		panelBotones.add(log);
		panelCentral.add(panelBotones);
		add(panelCentral, BorderLayout.CENTER);
		pack();
		setResizable(false); // Evitar que se pueda cambiar el tamaño

		cargarConfiguracion(index);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == reset) {
			//tf.setText("Los valores se han reiniciado.");
			if (pantallaCompletaActiva) {
				pantallaCompletaActiva = false;
				pantallaCompleta.setState(false);
				ventana.setState(true);
			}
			sonidoActivo.setState(true);
			musicaActivo.setState(true);
			seleccionMusica.select(0);
			chTeclaQ.select(0);
			chTeclaW.select(0);
			chTeclaEspacio.select(0);
			chTeclaIzq.select(0);
			chTeclaDer.select(0);
			chTeclaArriba.select(0);
			chTeclaAbajo.select(0);
			chTeclaX.select(0);
			chTeclaZ.select(0);
			chTeclaEnter.select(0);
			log.setText("Valores reiniciados!");
		}

		if(e.getSource() == guardar) { // guardar las configuraciones
			try {
				Properties propiedades = new Properties();

				propiedades.setProperty("ventana", String.valueOf(ventana.getState()));
				propiedades.setProperty("pantallaCompleta", String.valueOf(pantallaCompleta.getState()));
				propiedades.setProperty("sonidoActivo", String.valueOf(sonidoActivo.getState()));
				propiedades.setProperty("musicaActiva", String.valueOf(musicaActivo.getState()));
				propiedades.setProperty("seleccionMusica", seleccionMusica.getSelectedItem());
				propiedades.setProperty("teclaActDesSonido", chTeclaQ.getSelectedItem());
				propiedades.setProperty("teclaActDesMusica", chTeclaW.getSelectedItem());
				propiedades.setProperty("teclaPausar", chTeclaEspacio.getSelectedItem());
				propiedades.setProperty("teclaMovIzq", chTeclaIzq.getSelectedItem());
				propiedades.setProperty("teclaMovDer", chTeclaDer.getSelectedItem());
				propiedades.setProperty("teclaMovArriba", chTeclaArriba.getSelectedItem());
				propiedades.setProperty("teclaMovAbajo", chTeclaAbajo.getSelectedItem());
				propiedades.setProperty("teclaDisparar", chTeclaX.getSelectedItem());
				propiedades.setProperty("teclaAtqEsp", chTeclaZ.getSelectedItem());
				propiedades.setProperty("teclaIniciar", chTeclaEnter.getSelectedItem());
				propiedades.setProperty("pantallaCompletaActiva", String.valueOf(pantallaCompletaActiva));

				propiedades.store(new FileOutputStream(ARCHIVO_CONFIGURACION1943), "Configuración del juego");
				log.setText("Guardado!");
			} catch (IOException ex) {
				ex.printStackTrace();
				log.setText("Error al guardar!");
			}
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource() == pantallaCompleta) {
			if (!pantallaCompletaActiva) {
				pantallaCompletaActiva = true; // Establecer variable de estado en true
				//tf.setText("Checkbox de pantalla completa presionado.");
			}
		} else if (e.getSource() == ventana) {
			if (pantallaCompletaActiva) {
				pantallaCompletaActiva = false; // Establecer variable de estado en false
				//tf.setText("Checkbox de ventana presionado.");
			}
		}
		
		if (e.getSource() == sonidoActivo) {
			if(e.getStateChange() == 1) {
				//tf.setText("Sonido activado.");
			} else {
				//tf.setText("Sonido desactivado.");
			}
			
		}
		
		if (e.getSource() == musicaActivo) {
			if(e.getStateChange() == 1) {
				//tf.setText("Musica activada.");
			} else {
				//tf.setText("Musica desactivada.");
			}
		}
	}
	
	public void mostrar() {
		setVisible(true);
	}

	private void cargarConfiguracion(int index) { // cargar la configuracion

		if(index == 0){
			try (FileInputStream fis = new FileInputStream(ARCHIVO_CONFIGURACION1943)) {
				Properties propiedades = new Properties();
				propiedades.load(fis);
				// Obtener los valores de las propiedades
				ventana.setState(Boolean.parseBoolean(propiedades.getProperty("ventana")));
				pantallaCompleta.setState(Boolean.parseBoolean(propiedades.getProperty("pantallaCompleta")));
				musicaActivo.setState(Boolean.parseBoolean(propiedades.getProperty("sonidoActivo")));
				sonidoActivo.setState(Boolean.parseBoolean(propiedades.getProperty("musicaActiva")));
				seleccionMusica.select(propiedades.getProperty("seleccionMusica"));
				chTeclaQ.select(propiedades.getProperty("teclaActDesSonido"));
				chTeclaW.select(propiedades.getProperty("teclaActDesMusica"));
				chTeclaEspacio.select(propiedades.getProperty("teclaPausar"));
				chTeclaIzq.select(propiedades.getProperty("teclaMovIzq"));
				chTeclaDer.select(propiedades.getProperty("teclaMovDer"));
				chTeclaArriba.select(propiedades.getProperty("teclaMovArriba"));
				chTeclaAbajo.select(propiedades.getProperty("teclaMovAbajo"));
				chTeclaX.select(propiedades.getProperty("teclaDisparar"));
				chTeclaZ.select(propiedades.getProperty("teclaAtqEsp"));
				chTeclaEnter.select(propiedades.getProperty("teclaIniciar"));
				pantallaCompletaActiva = Boolean.parseBoolean (propiedades.getProperty("pantallaCompletaActiva"));

			} catch (IOException ex) {
				ex.printStackTrace();
				log.setText("Error al cargar!");
			}
		}
	}
}
