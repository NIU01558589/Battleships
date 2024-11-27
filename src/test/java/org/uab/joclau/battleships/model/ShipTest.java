package org.uab.joclau.battleships.model;

import org.junit.jupiter.api.Test;

import java.util.Collections;
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
  void markHitStatementCoverage() {

    //Cordenades coincideixen
    Cell c1 = new Cell(2,3);
    Cell c2 = new Cell(4,6);
    List<Cell> cells = List.of(c1, c2);
    Ship ship = new Ship(cells, cells.size());

    ship.markHit(2,3);
    ship.markHit(4,7);

    assertTrue(c1.isHit());
    assertFalse(c2.isHit());

    //Coordenades no coincideixen
    Cell c3 = new Cell(1,3);
    Cell c4 = new Cell(5,6);
    List<Cell> cells1 = List.of(c1, c2);
    Ship ship1 = new Ship(cells1, cells1.size());

    ship1.markHit(3,3);

    assertFalse(c3.isHit());
    assertFalse(c4.isHit());

    //Sense cells
    //Creem un ship buit
    Ship ship2 = new Ship(Collections.emptyList(),0);

    ship2.markHit(3,3);
    //Hem de comprovar que la llista es buida amb la funció isEmpty
    assertTrue(ship2.getPosicionsShip().isEmpty());

    //Més d'una Cell coincideix
    Cell c5 = new Cell(1,3);
    Cell c6 = new Cell(1,3);
    List<Cell> cells2 = List.of(c5, c6);
    Ship ship3 = new Ship(cells2, cells2.size());

    ship3.markHit(1,3);

    assertTrue(c5.isHit());
    assertFalse(c6.isHit());


  }

  @Test
  void markHitConditionCoverage() {
    Cell c1 = new Cell(2,3);
    Cell c2 = new Cell(4,6);
    List<Cell> cells = List.of(c1, c2);
    Ship ship = new Ship(cells, cells.size());

    //x és false i y és true
    ship.markHit(3,3);
    //x és true i y és false
    ship.markHit(4,7);

    assertFalse(c1.isHit());
    assertFalse(c2.isHit());
  }

  @Test
  void isSunk() {
  }
}