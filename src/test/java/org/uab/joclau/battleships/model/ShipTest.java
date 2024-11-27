package org.uab.joclau.battleships.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {
  // Comprova que es compleix el limit interior dels valors en posicions correctes del tauler
  @Test
  void TestisHitLimitInterior() {
    List<Cell> cells = List.of(new Cell(0,0),new Cell(2,1), new Cell(10,10));
    Ship ship = new Ship(cells, cells.size());

    assertTrue(ship.isHit(0,0));
    assertTrue(ship.isHit(10,10));
  }
  // Comprova que es compleix el limit exterior dels valors fora del tauler
  @Test
  void TestisHitLimitExterior() {
    List<Cell> cells = List.of(new Cell(0,0), new Cell(2,1), new Cell(10,10));
    Ship ship = new Ship(cells, cells.size());

    assertFalse(ship.isHit(-1, -1));
    assertFalse(ship.isHit(11,11));
  }
  // Comprovem que fem un cop a un vaixell quan la cel·la queda ocupada
  @Test
  void TestisHitOcupada() {
    List<Cell> cells = List.of(new Cell(1,1), new Cell(2,1), new Cell(10,10));
    Ship ship = new Ship(cells, cells.size());

    assertTrue(ship.isHit(1,1));
  }
  // Comprovem que la cell no ha estat ocupada
  @Test
  void TestisHitNoOcupada() {
    List<Cell> cells = List.of(new Cell(1,1), new Cell(2,1), new Cell(10,10));
    Ship ship = new Ship(cells, cells.size());

    assertFalse(ship.isHit(3,3));
  }
  // Statement Coverage
  @Test
  void TestIsHitStatementCoverage() {
    List<Cell> cells = List.of(new Cell(1,1), new Cell(2,1), new Cell(10,10));
    Ship ship = new Ship(cells, cells.size());

    assertTrue(ship.isHit(1,1)); //If true
    assertFalse(ship.isHit(3,1)); //If false
  }

  @Test
  void markHitLimitInterior() {
    Cell c1 = new Cell(0,0);
    Cell c2 = new Cell(10,10);
    List<Cell> cells = List.of(c1, c2);
    Ship ship = new Ship(cells, cells.size());

    ship.markHit(10,10);
    assertFalse(c1.isHit());
    assertTrue(c2.isHit());
  }

  @Test
  void markHitLimitExterior() {
    Cell c1 = new Cell(0,0);
    Cell c2 = new Cell(10,10);
    List<Cell> cells = List.of(c1, c2);
    Ship ship = new Ship(cells, cells.size());

    ship.markHit(-1,-1);
    ship.markHit(11,11);

    assertFalse(c1.isHit());
    assertFalse(c2.isHit());
  }

  @Test
  void markHitGolpejat() {
    Cell c1 = new Cell(2,3);
    Cell c2 = new Cell(4,6);
    List<Cell> cells = List.of(c1, c2);
    Ship ship = new Ship(cells, cells.size());

    ship.markHit(2,3);
    ship.markHit(4,6);

    assertTrue(c1.isHit());
    assertTrue(c2.isHit());
  }

  @Test
  void markHitLimitNoGolpejat() {
    Cell c1 = new Cell(2,3);
    Cell c2 = new Cell(4,6);
    List<Cell> cells = List.of(c1, c2);
    Ship ship = new Ship(cells, cells.size());

    ship.markHit(3,3);
    ship.markHit(4,7);

    assertFalse(c1.isHit());
    assertFalse(c2.isHit());
  }

  @Test
  void isSunk() {
  }
}