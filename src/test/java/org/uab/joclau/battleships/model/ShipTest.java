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

  }

  @Test
  void markHit() {
  }

  @Test
  void isSunk() {
  }
}