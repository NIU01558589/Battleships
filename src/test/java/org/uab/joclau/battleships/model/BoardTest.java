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
  // Vaixell Buit
  @org.junit.jupiter.api.Test
  void placeEmptyShipBoard() {
    Board board = new Board();

    List<Cell> shipCells = List.of();
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 0, 0, true);

    assertTrue(result);
  }
  // STATEMENT COVERAGE
  //Limits horizontals erronis per no complir l'if
  @org.junit.jupiter.api.Test
  void placeShipBoundHorizontalBoard() {
    Board board = new Board();

    List<Cell> shipCells = List.of(new Cell(0,8), new Cell(0,9), new Cell(0,10));
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 0, 8, true);

    assertFalse(result);
  }
  //Limits verticals erronis per no complir l'if
  @org.junit.jupiter.api.Test
  void placeShipBoundVerticalBoard() {
    Board board = new Board();

    List<Cell> shipCells = List.of(new Cell(8,0), new Cell(9,0), new Cell(10,0));
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 8, 0, false);

    assertFalse(result);
  }
  // Cel·les ocupada
  @org.junit.jupiter.api.Test
  void placeShipOccupiedCellsBoard() {
    Board board = new Board();

    List<Cell> shipCells = List.of(new Cell(0,0), new Cell(0,1), new Cell(0,2));
    Ship ship = new Ship(shipCells, shipCells.size());

    List<Cell> shipCells1 = List.of(new Cell(0,1), new Cell(0,2), new Cell(0,3));
    Ship ship1 = new Ship(shipCells1, shipCells.size());

    boolean result = board.placeShip(ship, 0, 0, true);
    boolean result1 = board.placeShip(ship1, 0,1,true);
    assertFalse(result1);
  }
  // Introduïm cel·les
  @org.junit.jupiter.api.Test
  void placeShipSuccessBoard() {
    Board board = new Board();

    List<Cell> shipCells = List.of(new Cell(0,0), new Cell(0,1), new Cell(0,2));
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 0, 0, true);
    assertTrue(result);
    assertEquals(1, board.getBoard()[0][0]);
    assertEquals(1, board.getBoard()[0][1]);
    assertEquals(1, board.getBoard()[0][2]);
  }
  // DECISION COVERAGE
  // PRIMER IF (true, false)
  @org.junit.jupiter.api.Test
  void placeShipDecisionFirstCaseBoard() {
    Board board = new Board();

    List<Cell> shipCells = List.of(new Cell(0,8), new Cell(0,9), new Cell(0,10));
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 0, 8, true);
    assertFalse(result);
  }
  // SEGON IF (false, true)
  @org.junit.jupiter.api.Test
  void placeShipDecisionSecondCaseBoard() {
    Board board = new Board();

    List<Cell> shipCells = List.of(new Cell(8,0), new Cell(9,0), new Cell(10,0));
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 0, 8, false);
    assertFalse(result);
  }
  // CONDITION COVERAGE
  // PRIMER IF A TRUE, SEGON A FALSE
  @org.junit.jupiter.api.Test
  void placeShipConditionFirstCaseBoard() {
    Board board = new Board();

    List<Cell> shipCells = List.of(new Cell(0,8), new Cell(0,9), new Cell(0,10));
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 0, 8, true);
    assertFalse(result);
  }
  // PRIMER IF A FALSE, SEGON A TRUE
  @org.junit.jupiter.api.Test
  void placeShipConditionSecondCaseBoard() {
    Board board = new Board();

    List<Cell> shipCells = List.of(new Cell(8,0), new Cell(9,0), new Cell(10,0));
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 8, 0, true);
    assertFalse(result);
  }
  // PRIMER IF A FALSE, SEGON A FALSE
  @org.junit.jupiter.api.Test
  void placeShipConditionThirdCaseBoard() {
    Board board = new Board();

    List<Cell> shipCells = List.of(new Cell(0,0), new Cell(0,1), new Cell(0,2));
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 0, 0, true);
    assertTrue(result);
  }
  // PRIMER IF A TRUE, SEGON A TRUE
  @org.junit.jupiter.api.Test
  void placeShipConditionFourthCaseBoard() {
    Board board = new Board();

    List<Cell> shipCells = List.of(new Cell(8,8), new Cell(9,8), new Cell(10,8));
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 8, 8, true);
    assertFalse(result);
  }
  // LOOP SIMPLE
  @org.junit.jupiter.api.Test
  void placeShipFirstCell() {
    Board board = new Board();

    List<Cell> shipCells = List.of(new Cell(0,0), new Cell(0,1), new Cell(0,2));
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 0, 0, true);
    // Comprovem que la cell i = 0  esta correctament validat
    assertTrue(board.getBoard()[0][0] == 1);
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