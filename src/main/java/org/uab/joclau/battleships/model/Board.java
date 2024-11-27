package org.uab.joclau.battleships.model;

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

    /**
     * Places a ship on the board.
     *
     * @param ship         the ship to place
     * @param x            the x-coordinate
     * @param y            the y-coordinate
     * @param isHorizontal true if the ship is placed
     *                     horizontally, false otherwise
     */
    public void placeShip(Ship ship, int x,
                          int y, boolean isHorizontal) {
        // Implementation here
    }

    /**
     * Registers a shot at the specified position.
     *
     * @param x the x-coordinate of the shot
     * @param y the y-coordinate of the shot
     * @return true if a ship was hit, false otherwise
     */
    public boolean takeShot(int x, int y) {
        /*
        //Validar les coordenades
        if (x < 0 || x > 10 || y < 0 || y > 10){
            return false;
        }

        //Cell ja golpejada?
        Cell cell = new Cell(x,y);
        if (cell.isHit()){
            return false;
        }

        //Si no ha estat golpejada
        //Marcar com golpejada
        cell.hit();

        //Es golpeja un vaixell?
        if(cell.isOccupied()){
            for(Ship ship: ships){
                if(ship.isHit(x,y)){
                    //Golpejem el vaixell
                    ship.markHit(x,y);
                    System.out.println("Vaixell tocat");
                    return true;
                }
            }
        }else {

            //Si no es golpeja un vaixell --> aigua
            System.out.println("Aigua");
            return false;
        }
*/

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
