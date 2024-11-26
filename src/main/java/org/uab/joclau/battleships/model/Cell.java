package org.uab.joclau.battleships.model;

/**
 * Represents a cell on the game board.
 * A cell can be occupied and hit during the game.
 */
public class Cell {

  /**
   * The x-coordinate of the cell.
   */
  private int x;

  /**
   * The y-coordinate of the cell.
   */
  private int y;

  /**
   * True if the cell has been hit, false otherwise.
   */
  private boolean tocat;

  /**
   * True if the cell is occupied, false otherwise.
   */
  private boolean ocupada;

  public Cell(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }


  /**
   * Marks the cell as occupied.
   */
  public void occupy() {
    ocupada = true;
  }

  /**
   * Marks the cell as hit.
   */
  public void hit() {
    tocat = true;
  }

  /**
   * Checks if the cell is occupied.
   *
   * @return true if the cell is occupied, false otherwise
   */
  public boolean isOccupied() {
    return ocupada;
  }

  /**
   * Checks if the cell has been hit.
   *
   * @return true if the cell has been hit, false otherwise
   */
  public boolean isHit() {
    return tocat;
  }
}
