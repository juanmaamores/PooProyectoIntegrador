package poo.Otros;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ranking extends Frame {
    private static final List rankingList = new List();

    public Ranking(Frame v, String juegoSeleccionado) {
        setTitle("Ranking de " + juegoSeleccionado);
        setSize(600, 600);
        setLocationRelativeTo(v);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose(); // Liberar recursos de la ventana
            }
        });
        add(rankingList);
    }

    public static void actualizarRanking(String nombreJugador, int nuevoRecord, String juegoSeleccionado) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:ranking.db");
        Statement statement = connection.createStatement();

        String selectQuery = "SELECT nombre, record FROM jugadores WHERE nombre = '" + nombreJugador + "'";
        ResultSet resultSet = statement.executeQuery(selectQuery);

        if (resultSet.next()) {
            int recordExistente = resultSet.getInt("record");
            if (nuevoRecord > recordExistente) {
                String updateQuery = "UPDATE jugadores SET record = " + nuevoRecord + " WHERE nombre = '" + nombreJugador + "' AND juego = '" + juegoSeleccionado + "'";
                statement.executeUpdate(updateQuery);
            }
        } else {
            String insertQuery = "INSERT INTO jugadores (nombre, record, juego) VALUES ('" + nombreJugador + "', " + nuevoRecord + ", '" + juegoSeleccionado + "')";
            statement.executeUpdate(insertQuery);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void cargarResultados(String juegoSeleccionado) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:ranking.db");
        Statement statement = connection.createStatement();

        // Obtener el ranking actualizado ordenado en forma descendente por "record"
        String selectRankingQuery = "SELECT nombre, record FROM jugadores WHERE juego = '" + juegoSeleccionado + "' ORDER BY record DESC";
        ResultSet resultSet = statement.executeQuery(selectRankingQuery);

        rankingList.removeAll(); // Limpiar la lista antes de actualizarla

        while (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            int record = resultSet.getInt("record");
            rankingList.add(nombre + ", " + record);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }


    public static int obtenerRecordJugador(String juegoSeleccionado, String nombreJugador) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:ranking.db");
        Statement statement = connection.createStatement();

        String selectRankingQuery = "SELECT record FROM jugadores WHERE nombre = '" + nombreJugador + "' AND juego = '" + juegoSeleccionado + "'";
        ResultSet resultSet = statement.executeQuery(selectRankingQuery);

        int aux = 0;
        if (resultSet.next()) {
            aux = resultSet.getInt("record");
        }

        resultSet.close();
        statement.close();
        connection.close();

        return aux;
    }


    public void mostrar() {
        setVisible(true);
    }
}

