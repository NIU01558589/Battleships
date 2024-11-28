package org.uab.joclau.battleships.model;

/**
 * Represents a player in the game.
 * A player has a game board and can place ships and take turns.
 */
public class Player {

  /**
   * The player's game board.
   */
  private Board board;

  /**
   * Places the player's ships on the board.
   */
  public boolean placeShips(Ship ship, int x, int y, boolean isHorizontal) {
    return board.placeShip(ship, x, y, isHorizontal);
  }

  /**
   * Takes a turn against an opponent.
   *
   * @param opponent the opponent player.
   * @return true if the turn was successfully completed, false otherwise.
   */
  public boolean takeTurn(final Player opponent, int x, int y) {
    return opponent.getBoardPlayer().takeShot(x,y);
  }

  /**
   * Checks if the player has lost the game.
   *
   * @return true if the player has lost, false otherwise.
   */
  public boolean hasLost() {
    return false;  // Implement loss-check logic
  }

  /**
   * Returns the player's board.
   *
   * @return the player's board.
   */
  public Board getBoardPlayer() {
    return board;
  }
}
