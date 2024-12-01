package org.uab.joclau.battleships.controller;

import org.junit.jupiter.api.Test;
import org.uab.joclau.battleships.model.BoardUtils;
import org.uab.joclau.battleships.model.Player;
import org.uab.joclau.battleships.model.Ship;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    // Cas interior de la board
    @Test
    void TestPlaceShipsWithValidInputs() {
        GameController gameController = new GameController("Player1", "Player2");
        Player player1 = gameController.getPlayer1();

        Ship validShip = new Ship(BoardUtils.generateCells(0,0,3,true),3);
        assertTrue(player1.placeShips(validShip,0,0,true));
    }
    // Cas exterior a una posicio inexistent del tauler
    @Test
    void TestPlaceShipsWithInvalidCoordinates() {
        GameController gameController = new GameController("Player1", "Player2");
        Player player1 = gameController.getPlayer1();

        Ship invalidShip = new Ship(BoardUtils.generateCells(11,11,3,true),3);
        assertFalse(player1.placeShips(invalidShip,11,11,true));
    }
    // Frontera del tauler
    @Test
    void TestPlaceShipsAtBounds() {
        GameController gameController = new GameController("Player1", "Player2");
        Player player1 = gameController.getPlayer1();
        // Limit superior esquerre tauler
        Ship posicioZeroZero = new Ship(BoardUtils.generateCells(0,0,3,true),3);
        assertTrue(player1.placeShips(posicioZeroZero,0,0,true));
        // Limit inferior dret tauler
        Ship posicioInferiorDreta = new Ship(BoardUtils.generateCells(9,7,3,true),3);
        assertTrue(player1.placeShips(posicioInferiorDreta,9,7,true));
    }
    // PATH COVERAGE
    @Test
    void testPathCoveragePlaceShips() {
        GameController gameController = new GameController("Player1", "Player2");
        Player player1 = gameController.getPlayer1();

        // Cami 1: Colocacio exitosa
        Ship pathSuccess =new Ship(BoardUtils.generateCells(0, 0, 2, true), 2);
        assertTrue(player1.placeShips(pathSuccess, 0, 0, true));

        // Cami 2: Coordenades fora de limit
        Ship pathErrorPosition = new Ship(BoardUtils.generateCells(10, 10, 2, true), 2);
        assertFalse(player1.placeShips(pathErrorPosition, 10, 10, true));

        // Cami 3: Solapament amb altre vaixell
        Ship pathAux = new Ship(BoardUtils.generateCells(0, 0, 2, true), 2);
        Ship pathOccupiedPosition = new Ship(BoardUtils.generateCells(0, 1, 3, true), 3);
        player1.placeShips(pathAux,0,0,true);
        assertFalse(player1.placeShips(pathOccupiedPosition, 1, 10, true));

        //Cami 4: Dimensions del vaixell surten dels limits
        Ship dimensionsForaLimit =new Ship(BoardUtils.generateCells(0, 0, 2, true), 2);
        assertTrue(player1.placeShips(dimensionsForaLimit, 0, 0, true));
    }
    // LOOP ANIUAT
    @Test
    void playGame() {
    }
}