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
    @Test
    void playGame() {
    }
}