package org.uab.joclau.battleships.model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
  // Cas correcte
  @org.junit.jupiter.api.Test
  void placeShipValidSituation() {
    Board board = new Board();
      List<Cell> shipCells = List.of(new Cell(1,2), new Cell(1,3), new Cell(1,4));
      Ship ship = new Ship(shipCells, shipCells.size());

      boolean result = board.placeShip(ship, 1, 2, true);

      assertTrue(result);
      assertEquals(1, board.getBoard()[1][2]);
      assertEquals(1, board.getBoard()[1][3]);
      assertEquals(1, board.getBoard()[1][4]);
  }
  // Cas fora de rang
  @org.junit.jupiter.api.Test
  void placeShipInvalidOutOfBoard() {
    Board board = new Board();
    List<Cell> shipCells = List.of(new Cell(0,9), new Cell(0,10), new Cell(0,11));
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 0, 9, true);

    assertFalse(result);
  }
  // Cas cel·les ocupades
  @org.junit.jupiter.api.Test
  void placeShipCellOccupiedBoard() {
    Board board = new Board();
    int[][] gridGame = new int[10][10];
    // Situem la cel·la 0,0 ocupada
    gridGame[0][0] = 1;
    board.setBoard(gridGame);

    List<Cell> shipCells = List.of(new Cell(0,0), new Cell(0,1), new Cell(0,2));
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 0, 0, true);

    assertFalse(result);
  }
  // Vaixell col·locat verticalment
  @org.junit.jupiter.api.Test
  void placeShipVerticalBoard() {
    Board board = new Board();

    List<Cell> shipCells = List.of(new Cell(0,0), new Cell(1,0), new Cell(2,0));
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 0, 0, false);

    assertTrue(result);
    assertEquals(1, board.getBoard()[0][0]);
    assertEquals(1, board.getBoard()[1][0]);
    assertEquals(1, board.getBoard()[2][0]);
  }
  // Cas vaixell a la vora del tauler
  @org.junit.jupiter.api.Test
  void placeShipLimitBoard() {
    Board board = new Board();

    List<Cell> shipCells = List.of(new Cell(9,9));
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 9, 9, false);

    assertTrue(result);
    assertEquals(1, board.getBoard()[9][9]);
  }
  // Vaixell Buit TODO: ACABAR
  @org.junit.jupiter.api.Test
  void placeEmptyShipBoard() {
    Board board = new Board();

    List<Cell> shipCells = List.of();
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 0, 0, true);

    assertTrue(result);
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