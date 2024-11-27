package org.uab.joclau.battleships.model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

  @org.junit.jupiter.api.Test
  void placeShipValidSituation() {
    Board board = new Board();
      List<Cell> shipCells = List.of(new Cell(1,2), new Cell(1,3), new Cell(1,4));
      Ship ship = new Ship(shipCells, shipCells.size());

      boolean result = board.placeShip(ship, 1, 2, true);

      assertEquals(1, board.getBoard()[1][2]);
      assertEquals(1, board.getBoard()[1][3]);
      assertEquals(1, board.getBoard()[1][4]);
  }

  @org.junit.jupiter.api.Test
  void takeShot() {
  }

  @org.junit.jupiter.api.Test
  void isAllShipsSunk() {
  }

  @org.junit.jupiter.api.Test
  void isValidPlacement() {
  }

  @org.junit.jupiter.api.Test
  void isGameOver() {
  }
}