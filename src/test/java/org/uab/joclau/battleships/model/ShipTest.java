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
  void markHitDecisionCoverage() {
    Cell c1 = new Cell(3,3);
    Cell c2 = new Cell(5,6);
    List<Cell> cells = List.of(c1, c2);
    Ship ship = new Ship(cells, cells.size());

    //x és true i y és true
    ship.markHit(3,3);
    //x és false i y és false
    ship.markHit(4,7);

    assertTrue(c1.isHit());
    assertFalse(c2.isHit());
  }

  @Test
  void isSunkLimitInterior() {
    //CAS QUE VAIXELL ENFONSAT
    Cell c1 = new Cell(3,3);
    Cell c2 = new Cell(3,4);
    List<Cell> cells = List.of(c1, c2);
    Ship ship = new Ship(cells, cells.size());


    ship.markHit(c1.getX(), c1.getY());

    ship.markHit(c2.getX(), c2.getY());

    assertTrue(ship.isSunk());

    //CAS QUE VAIXELL NO ENFONSAT
    Cell c3 = new Cell(3,3);
    Cell c4 = new Cell(3,4);
    List<Cell> cells1 = List.of(c3, c4);
    Ship ship1 = new Ship(cells1, cells1.size());

    ship1.markHit(c3.getX(), c3.getY());

    assertFalse(ship1.isSunk());

  }

  @Test
  void isSunkLimitExterior() {

    //NEGATIUS X
    Cell c1 = new Cell(-3,3);
    Cell c2 = new Cell(-3,4);
    List<Cell> cells = List.of(c1, c2);
    Ship ship = new Ship(cells, cells.size());

    ship.markHit(c1.getX(), c1.getY());

    ship.markHit(c2.getX(), c2.getY());

    assertFalse(ship.isSunk());

    //NEGATIUS Y
    Cell c11 = new Cell(3,-3);
    Cell c21 = new Cell(3,-4);
    List<Cell> cells11 = List.of(c11, c21);
    Ship ship11 = new Ship(cells11, cells11.size());

    ship.markHit(c11.getX(), c11.getY());

    ship.markHit(c21.getX(), c21.getY());

    assertFalse(ship11.isSunk());

    //MÉS GRANS QUE BOARD Y
    Cell c3 = new Cell(3,11);
    Cell c4 = new Cell(3,12);
    List<Cell> cells1 = List.of(c3, c4);
    Ship ship1 = new Ship(cells1, cells1.size());

    ship1.markHit(c3.getX(), c3.getY());
    ship1.markHit(c4.getX(), c4.getY());

    assertFalse(ship1.isSunk());

    //MÉS GRANS QUE BOARD X
    Cell c32 = new Cell(14,1);
    Cell c42 = new Cell(22,1);
    List<Cell> cells12 = List.of(c3, c4);
    Ship ship12 = new Ship(cells12, cells12.size());

    ship1.markHit(c32.getX(), c32.getY());
    ship1.markHit(c42.getX(), c42.getY());

    assertFalse(ship12.isSunk());
  }

  @Test
  void isSunkStatementCoverage() {

    //CAS 1: VAIXELL COMPLETAMENT ENFONSAT
    Cell c1 = new Cell(2,3);
    Cell c2 = new Cell(3,3);
    List<Cell> cells = List.of(c1, c2);
    Ship ship = new Ship(cells, cells.size());

    ship.markHit(c1.getX(), c1.getY());

    ship.markHit(c2.getX(), c2.getY());

    assertTrue(ship.isSunk());

    //CAS 2: VAIXELL PARCIALMENT ENFONSAT
    Cell c3 = new Cell(3,3);
    Cell c4 = new Cell(3,4);
    List<Cell> cells1 = List.of(c3, c4);
    Ship ship1 = new Ship(cells1, cells1.size());

    ship1.markHit(c3.getX(), c3.getY());

    assertFalse(ship1.isSunk());

    //CAS 3: VAIXELL SENSE TOCAR
    Cell c5 = new Cell (3,5);
    List<Cell> cell5 = List.of(c4,c5);
    Ship ship5 = new Ship(cell5, cell5.size());

    assertFalse(ship5.isSunk());

    //CAS 4: VAIXELL AMB UNA CELL ENFONSAT
    List<Cell> cells2 = List.of(c3);
    Ship ship2 = new Ship(cells2, cells2.size());
    assertTrue(ship2.isSunk());

    //CAS 5: VAIXELL AMB UNA CELL NO ENFONSAT
    List<Cell> cells3 = List.of(c4);
    Ship ship3 = new Ship(cells3, cells2.size());
    assertFalse(ship3.isSunk());

    //CAS 6: VAIXELL EMPTY
    Ship ship25 = new Ship(Collections.emptyList(),0);

    //Hem de comprovar que la llista es buida amb la funció isEmpty
    assertTrue(ship25.getPosicionsShip().isEmpty());
    assertFalse(ship25.isSunk());

  }

  @Test
  void isSunkDecisionCoverage(){

    // 1r IF TRUE
    Ship ship25 = new Ship(Collections.emptyList(),0);

    //Hem de comprovar que la llista es buida amb la funció isEmpty
    assertTrue(ship25.getPosicionsShip().isEmpty());
    assertFalse(ship25.isSunk());

    //1R IF FALSE 2N IF TRUE
    Cell c1 = new Cell(-3,3);
    Cell c2 = new Cell(-3,4);
    List<Cell> cells = List.of(c1, c2);
    Ship ship = new Ship(cells, cells.size());

    ship.markHit(c1.getX(), c1.getY());

    ship.markHit(c2.getX(), c2.getY());

    assertFalse(ship.isSunk());

    //1R IF FALSE 2N IF FALSE 3R IF FALSE
    Cell c3 = new Cell(3,3);
    Cell c4 = new Cell(3,4);
    List<Cell> cells1 = List.of(c3, c4);
    Ship ship1 = new Ship(cells1, cells1.size());

    ship1.markHit(c3.getX(), c3.getY());

    assertFalse(ship1.isSunk());

    //1R IF TRUE 2N IF TRUE 3R IF TRUE
    Cell c11 = new Cell(2,3);
    Cell c21 = new Cell(3,3);
    List<Cell> cells11 = List.of(c11, c21);
    Ship ship11 = new Ship(cells11, cells11.size());

    ship11.markHit(c11.getX(), c11.getY());

    ship11.markHit(c21.getX(), c21.getY());

    assertTrue(ship11.isSunk());

  }

  @Test
  void isSunkConditionCoverage(){

    // 1r IF TRUE
    Ship ship25 = new Ship(Collections.emptyList(),0);

    //Hem de comprovar que la llista es buida amb la funció isEmpty
    assertTrue(ship25.getPosicionsShip().isEmpty());
    assertFalse(ship25.isSunk());

    //1R IF FALSE 2N IF TRUE
    Cell c1 = new Cell(-3,3);
    Cell c2 = new Cell(-3,4);
    List<Cell> cells = List.of(c1, c2);
    Ship ship = new Ship(cells, cells.size());

    ship.markHit(c1.getX(), c1.getY());

    ship.markHit(c2.getX(), c2.getY());

    assertFalse(ship.isSunk());

    //1R IF FALSE 2N IF FALSE 3R IF TRUE
    Cell c3 = new Cell(3,3);
    Cell c4 = new Cell(3,4);
    List<Cell> cells1 = List.of(c3, c4);
    Ship ship1 = new Ship(cells1, cells1.size());

    ship1.markHit(c3.getX(), c3.getY());

    assertFalse(ship1.isSunk());

    //1R IF TRUE 2N IF TRUE 3R IF TRUE
    Cell c11 = new Cell(2,3);
    Cell c21 = new Cell(3,3);
    List<Cell> cells11 = List.of(c11, c21);
    Ship ship11 = new Ship(cells11, cells11.size());

    ship11.markHit(c11.getX(), c11.getY());

    ship11.markHit(c21.getX(), c21.getY());

    assertTrue(ship11.isSunk());

  }


}

