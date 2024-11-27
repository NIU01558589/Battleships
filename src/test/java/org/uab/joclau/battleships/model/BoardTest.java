package org.uab.joclau.battleships.model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

  @org.junit.jupiter.api.Test
  void placeShip() {
      Board board = new Board();
      int[][] gridGame = new int[10][10];
      board.setBoard(gridGame);

      List<Cell> shipCells = List.of(new Cell(0,0), new Cell(0,1), new Cell(0,2));
      Ship ship = new Ship(shipCells, shipCells.size());

      board.placeShip(ship, 0, 0, true);

      assertEquals(1, board.getBoard()[0][0]);
      assertEquals(1, board.getBoard()[0][1]);
      assertEquals(1, board.getBoard()[0][2]);
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