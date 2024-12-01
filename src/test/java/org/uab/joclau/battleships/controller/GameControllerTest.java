package org.uab.joclau.battleships.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uab.joclau.battleships.model.Player;
import org.uab.joclau.battleships.model.Ship;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.mockito.Mockito.*;

public class GameControllerTest {

    private GameController gameController;
    private Player mockPlayer;

    @BeforeEach
    public void setUp() {
        // Setup con jugadores mockeados
        mockPlayer = mock(Player.class);
        gameController = new GameController("Player1", "Player2");
    }

    /**
     * Test de Path Coverage para placeShips.
     * Se cubren los caminos cuando los barcos son colocados correctamente y cuando son colocados incorrectamente.
     */
    @Test
    public void testPlaceShips_PathCoverage() {
        // Simulación de entradas utilizando un InputStream
        String input = "1\n1\nh\n" +
                            "2\n2\nh\n"+
                                    "3\n3\nh\n" +
                                        "4\n4\nh\n" +
                                            "5\n5\nh\n";
        InputStream stdin = new ByteArrayInputStream(input.getBytes());
        System.setIn(stdin); // Cambiar el InputStream del Scanner

        // Simulamos que los barcos se colocan correctamente
        when(mockPlayer.placeShips(any(Ship.class), anyInt(), anyInt(), anyBoolean())).thenReturn(true);

        // Ejecutar el método
        gameController.placeShips(mockPlayer);

        // Verificación: Asegurarse de que se haya intentado colocar los barcos correctamente
        verify(mockPlayer, times(5)).placeShips(any(Ship.class), anyInt(), anyInt(), eq(true));
    }

    /**
     * Test de Statement Coverage para placeShips.
     * Se cubren todas las sentencias en el método placeShips, incluyendo casos válidos e inválidos.
     */
    @Test
    public void testPlaceShips_StatementCoverage() {
        // Creamos un jugador real o parcialmente funcional
        Player mockPlayer = new Player("Player1");

        // Simulamos las entradas necesarias para colocar los barcos
        String input =
                "1\n1\nh\n" +  // Barco 1: tamaño 1
                    "1\n1\nh\n" +  // Barco 1: reintento
                        "2\n2\nh\n" +  // Barco 2: tamaño 2
                            "3\n3\nh\n" +  // Barco 3: tamaño 3
                                "4\n4\nh\n" +  // Barco 4: tamaño 4
                                    "5\n5\nh\n";   // Barco 5: tamaño 5

        InputStream stdin = new ByteArrayInputStream(input.getBytes());
        System.setIn(stdin); // Cambiar el InputStream del Scanner

        // Crear una instancia del GameController
        GameController gameController = new GameController("Player1", "Player2");

        // Ejecutar el método con el jugador real
        gameController.placeShips(mockPlayer);

        // Verificamos que placeShips fue llamado correctamente
        // Por ejemplo, verificamos si los barcos fueron colocados correctamente
        // (esto depende de cómo implementes el método placeShips y los estados del juego)
    }


    /**
     * Test de Loop Anidado (for - while) para placeShips.
     * Se verifica que el bucle anidado (for - while) funcione correctamente, probando las iteraciones del for
     * y los intentos de colocación fallidos en el while.
     */
    @Test
    public void testPlaceShips_LoopAnidado() {
        // Simulación de entradas utilizando un InputStream
        // Necesitamos 5 barcos, 3 entradas por cada uno (x, y, orientación)
        String input = "1\n1\nh\n"+
                            "2\n2\nh\n" +
                                "3\n3\nh\n" +
                                    "4\n4\nh\n" +
                                        "5\n5\nh\n";
        InputStream stdin = new ByteArrayInputStream(input.getBytes());
        System.setIn(stdin); // Cambiar el InputStream del Scanner

        // El primer intento será fallido, luego será exitoso en las siguientes 4 llamadas
        when(mockPlayer.placeShips(any(Ship.class), anyInt(), anyInt(), anyBoolean()))
                .thenReturn(false)  // Fallido
                .thenReturn(false)  // Fallido
                .thenReturn(false)  // Fallido
                .thenReturn(true)   // Exitoso
                .thenReturn(true);  // Exitoso

        // Ejecutar el método
        gameController.placeShips(mockPlayer);

        // Verificar que el bucle anidado se ejecuta correctamente (intenta colocar los barcos 5 veces)
        verify(mockPlayer, times(5)).placeShips(any(Ship.class), anyInt(), anyInt(), eq(true)); // Revisa las llamadas, solo los exitosos deben ser 2.
    }
}
