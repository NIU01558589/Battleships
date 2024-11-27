package org.uab.joclau.battleships.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the game board for Battleships.
 */
public class Board {

    /**
     * The game board grid.
     */
    private int[][] board;

    /**
     * All the ships in the game.
     */
    private List<Ship> ships;

    public Board() {
        this.board = new int[10][10];
        this.ships = new ArrayList<Ship>();
    }

    public void setBoard(int[][] boardInput) {
        this.board = boardInput;
    }

    public int[][] getBoard() {
        return this.board;
    }
    /**
     * Places a ship on the board.
     *
     * @param ship         the ship to place
     * @param x            the x-coordinate
     * @param y            the y-coordinate
     * @param isHorizontal true if the ship is placed
     *                     horizontally, false otherwise
     */
    public boolean placeShip(Ship ship, int x,
                          int y, boolean isHorizontal) {
        int shipSize = ship.getTamany();

        // Validar que el vaixell no surti dels límits
        if((isHorizontal && (y + shipSize > board[0].length))
                ||(!isHorizontal &&(x+shipSize > board.length))) {
            return false;
        }

        // Validar que les cel·les no estiguin ocupades
        List<Cell> llistaPosShip = ship.getPosicionsShip();
        for (int i = 0; i < shipSize; i++) {
            Cell cell = llistaPosShip.get(i);
            if(cell.getX() >= board.length
                    || cell.getY() >= board[0].length
                        || board[cell.getX()][cell.getY()] == 1) {
                return false;
            }
        }
        // Afegir el vaixell
        for (int i = 0; i < shipSize; i++) {
            Cell cell = llistaPosShip.get(i);
            board[cell.getX()][cell.getY()] = 1;
        }

        // Añadir barco a la lista de barcos
        ships.add(ship);

        // Cas existós
        return true;
    }

    /**
     * Registers a shot at the specified position.
     *
     * @param x the x-coordinate of the shot
     * @param y the y-coordinate of the shot
     * @return true if a ship was hit, false otherwise
     */
    public boolean takeShot(int x, int y) {
        return false;
    }

    /**
     * Checks if all ships are sunk.
     *
     * @return true if all ships are sunk, false otherwise
     */
    public boolean isAllShipsSunk() {
        return false;
    }

    /**
     * Validates the placement of a ship on the board.
     *
     * @param ship         the ship to validate
     * @param x            the x-coordinate of the placement
     * @param y            the y-coordinate of the placement
     * @param isHorizontal true if the ship is placed horizontally
     * @return true if the placement is valid, false otherwise
     */
    public boolean isValidPlacement(Ship ship, int x,
                                    int y, boolean isHorizontal) {
        return isHorizontal;
    }

    /**
     * Checks if the game is over.
     *
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        return false;
    }
}
