package org.uab.joclau.battleships.model;

import org.junit.jupiter.api.Test;

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
  // i = 0
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
  // i = 1
  @org.junit.jupiter.api.Test
  void placeShipSecondCell() {
    Board board = new Board();

    List<Cell> shipCells = List.of(new Cell(0,0), new Cell(0,1), new Cell(0,2));
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 0, 0, true);
    // Comprovem que la cell i = 1  esta correctament validat
    assertTrue(board.getBoard()[0][1] == 1);
    assertTrue(result);
  }
  // i = shipSize - 2
  @org.junit.jupiter.api.Test
  void placeShipPenultimateCell() {
    Board board = new Board();

    List<Cell> shipCells = List.of(new Cell(0,0), new Cell(0,1), new Cell(0,2));
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 0, 0, true);
    // Comprovem que la cell i = shipsize - 2  esta correctament validat
    assertTrue(board.getBoard()[0][1] == 1);
    assertTrue(result);
  }
  // i = shipSize - 1
  @org.junit.jupiter.api.Test
  void placeShipLastCell() {
    Board board = new Board();

    List<Cell> shipCells = List.of(new Cell(0,0), new Cell(0,1), new Cell(0,2));
    Ship ship = new Ship(shipCells, shipCells.size());

    boolean result = board.placeShip(ship, 0, 0, true);
    // Comprovem que la cell i = shipsize - 1  esta correctament validat
    assertTrue(board.getBoard()[0][2] == 1);
    assertTrue(result);
  }

  @org.junit.jupiter.api.Test
  void takeShotLimitInterior() {

    //Valor 00
    Board board = new Board();
    Cell c1 = new Cell(0,0);

    List<Cell> cells = List.of(c1);
    Ship ship = new Ship(cells, cells.size());

    board.placeShip(ship, 0,0,true);
    assertTrue(board.takeShot(0,0));

    //Valor 9 9
    Cell c2 = new Cell(9,9);

    List<Cell> cells1 = List.of(c2);
    Ship ship1 = new Ship(cells1, cells.size());

    board.placeShip(ship1, 9,9,true);
    assertTrue(board.takeShot(9,9));

    //Valor 5 5
    Cell c3 = new Cell(5,5);

    List<Cell> cells2 = List.of(c3);
    Ship ship2 = new Ship(cells2, cells.size());

    board.placeShip(ship2, 5,5,true);
    assertTrue(board.takeShot(5,5));

    //Valor sense vaixell
    assertFalse(board.takeShot(3,4));

  }

  @org.junit.jupiter.api.Test
  void takeShotLimitExterior() {
    //Valor -1
    Board board = new Board();

    assertFalse(board.takeShot(-1,-1));

    //Valor 9 9

    assertFalse(board.takeShot(10,10));
  }

  @Test
  void takeShotJaColpejada(){
    Board board = new Board();

    //Doble colpejada aigua
    board.takeShot(5,6);
    assertFalse(board.takeShot(5,6));

    //Doble colpejada vaixell
    Cell c1 = new Cell(0,0);

    List<Cell> cells = List.of(c1);
    Ship ship = new Ship(cells, cells.size());

    board.placeShip(ship, 0,0,true);
    board.takeShot(0,0);
    assertFalse(board.takeShot(0,0));

  }

  @Test
  void takeShotCellAigua(){
    Board board = new Board();

    assertFalse(board.takeShot(5,6));
  }

  @Test
  void takeShotCellVaixell(){
    Board board = new Board();
    Cell c1 = new Cell(0,0);

    List<Cell> cells = List.of(c1);
    Ship ship = new Ship(cells, cells.size());

    board.placeShip(ship, 0,0,true);
    assertTrue(board.takeShot(0,0));

  }

  @org.junit.jupiter.api.Test
  void takeShotStatementCoverage() {

    Board board = new Board();

    //Fora dels límits
    assertFalse(board.takeShot(-1,-1));
    assertFalse(board.takeShot(10,10));

    //Ja colpejat
    //Doble colpejada aigua
    board.takeShot(5,6);
    assertFalse(board.takeShot(5,6));

    //Doble colpejada vaixell
    Cell c1 = new Cell(0,0);

    List<Cell> cells = List.of(c1);
    Ship ship = new Ship(cells, cells.size());

    board.placeShip(ship, 0,0,true);
    board.takeShot(0,0);
    assertFalse(board.takeShot(0,0));

    //Aigua
    assertFalse(board.takeShot(4,4));

    //Colpejat vaixell
    Cell c2 = new Cell(2,2);

    List<Cell> cells1 = List.of(c2);
    Ship ship1 = new Ship(cells1, cells.size());

    board.placeShip(ship1, 2,2,true);
    assertTrue(board.takeShot(2,2));
  }

  @Test
  void takeShotPathCoverage(){

    Board board = new Board();

    //Fora dels límits
    assertFalse(board.takeShot(-1,-1));
    assertFalse(board.takeShot(10,10));

    //Ja colpejat
    //Doble colpejada aigua
    board.takeShot(5,6);
    assertFalse(board.takeShot(5,6));

    //Doble colpejada vaixell
    Cell c1 = new Cell(0,0);

    List<Cell> cells = List.of(c1);
    Ship ship = new Ship(cells, cells.size());

    board.placeShip(ship, 0,0,true);
    board.takeShot(0,0);
    assertFalse(board.takeShot(0,0));

    //Aigua
    assertFalse(board.takeShot(4,4));

    //Colpejat vaixell
    Cell c2 = new Cell(2,2);

    List<Cell> cells1 = List.of(c2);
    Ship ship1 = new Ship(cells1, cells.size());

    board.placeShip(ship1, 2,2,true);
    assertTrue(board.takeShot(2,2));

    //No colpejat al vaixell
    assertFalse(board.takeShot(3,3));
  }

  @Test
  void takeShotSimpleLoop(){
    Board board = new Board();

    Cell c1 = new Cell(0,0);
    List<Cell> cells = List.of(c1);
    Ship ship = new Ship(cells, cells.size());

    Cell c2 = new Cell(4,5);
    List<Cell> cells1 = List.of(c2);
    Ship ship1 = new Ship(cells1, cells.size());

    Cell c3 = new Cell(8,8);
    List<Cell> cells2 = List.of(c3);
    Ship ship2 = new Ship(cells2, cells.size());

    Cell c4 = new Cell(6,7);
    List<Cell> cells3 = List.of(c4);
    Ship ship3 = new Ship(cells3, cells.size());

    Cell c5 = new Cell(9,9);
    List<Cell> cells4 = List.of(c5);
    Ship ship4 = new Ship(cells4, cells.size());

    board.placeShip(ship, 0,0,true);
    board.placeShip(ship1, 4,5,true);
    board.placeShip(ship2, 8,8,true);
    board.placeShip(ship3, 6,7,true);
    board.placeShip(ship4, 9,9,true);


    //Primer valor
    assertTrue(board.takeShot(0,0));
    //Segon
    assertTrue(board.takeShot(4,5));
    //Penúltim
    assertTrue(board.takeShot(6,7));
    //últim
    assertTrue(board.takeShot(9,9));

  }

  @org.junit.jupiter.api.Test
  void isAllShipsSunkLimitInterior() {
    //Tots enfonsats
    Board board = new Board();

    Ship ship1 = new Ship(List.of(new Cell(0, 0)), 1);

    Ship ship2 = new Ship(List.of(new Cell(5, 1)), 1);

    board.placeShip(ship1, 0, 0, true);
    board.placeShip(ship2, 5, 1, true);

    board.takeShot(0,0);
    board.takeShot(5,1);

    assertTrue(board.isAllShipsSunk());

    //Cap enfonsat
    Board board1 = new Board();

    Ship ship11 = new Ship(List.of(new Cell(0, 0)), 1);

    Ship ship21 = new Ship(List.of(new Cell(5, 1)), 1);

    board.placeShip(ship1, 0, 0, true);
    board.placeShip(ship2, 5, 1, true);

    assertFalse(board1.isAllShipsSunk());
  }

  @org.junit.jupiter.api.Test
  void isAllShipsSunkLimitExterior() {
    //Cap vaixell
    Board board = new Board();

    assertFalse(board.isAllShipsSunk());
  }

  @org.junit.jupiter.api.Test
  void isValidPlacement() {
  }

  @org.junit.jupiter.api.Test
  void isGameOver() {
  }
}