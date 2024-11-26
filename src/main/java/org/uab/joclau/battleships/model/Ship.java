package org.uab.joclau.battleships.model;

import java.util.List;

/**
 * Represents a ship in the game.
 * A ship occupies multiple cells on the game board and can be hit and sunk.
 */
public class Ship {

  /**
   * The list of cells occupied by the ship.
   */
  private final List<Cell> posicionsShip;

  /**
   * The size of the ship.
   */
  private final int tamany;

  /**
   * True if the ship is sunk, false otherwise.
   */
  private boolean enfonsat;

  /**
   * Constructor for the Ship class.
   *
   * @param posicionsShipInput the list of cells to be occupied by the ship.
   * @param tamanyInput the size of the ship.
   */
  public Ship(final List<Cell> posicionsShipInput, final int tamanyInput) {
    this.posicionsShip = posicionsShipInput;
    this.tamany = tamanyInput;
    this.enfonsat = false;
  }

  /**
   * Checks if the ship has been hit at the given coordinates.
   *
   * @param x the x-coordinate of the shot.
   * @param y the y-coordinate of the shot.
   * @return true if the ship is hit at the
   * specified coordinates, false otherwise.
   */
  public boolean isHit(final int x, final int y) {
    return false;  // Implement logic
    // to check if the ship is hit at the specified coordinates
  }

  /**
   * Marks the ship as hit at the given coordinates.
   *
   * @param x the x-coordinate of the hit.
   * @param y the y-coordinate of the hit.
   */
  public void markHit(final int x, final int y) {
    // Implement logic to mark the ship as hit at the specified coordinates
  }

  /**
   * Checks if the ship is sunk.
   *
   * @return true if the ship is sunk, false otherwise.
   */
  public boolean isSunk() {
    return false;  // Implement logic to check if the ship is sunk
  }

  /**
   * Gets the positions of the ship.
   *
   * @return the list of cells occupied by the ship. uqyuldqiawHDFIhawfauifqauwhfqauihfauihfqluibhquilhfquihfquihqluihiqlh
   */
  public List<Cell> getPosicionsShip() {
    return posicionsShip;
  }

  /**
   * Gets the size of the ship.
   *
   * @return the size of the ship.
   */
  public int getTamany() {
    return tamany;
  }

  /**
   * Checks if the ship is sunk.
   *
   * @return true if the ship is sunk, false otherwise.
   */
  public boolean isEnfonsat() {
    return enfonsat;
  }

  /**
   * Marks the ship as sunk.
   *
   * @param enfonsatInput true if the ship is sunk, false otherwise.
   */
  public void setEnfonsat(final boolean enfonsatInput) {
    this.enfonsat = enfonsatInput;
  }
}
