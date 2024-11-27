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

    public List<Ship> getShips() {
        return this.ships;
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
        //Precondicions
        assert ship != null : "El vaixell no pot ser null";
        assert ship.getTamany() > 0 : "Tamany del vaixell positiu";
        assert x >= 0 && y >= 0 : "Coordenades dins de rang";

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

        // Afegir vaixell a la llista de vaixells
        ships.add(ship);

        assert ships.contains(ship) : "El vaixell no ha estat afegir correctament";

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

        //Precondicions
        assert board != null:
            "El tauler no pot ser null";
        assert board.length == 10 && board[0].length == 10:
            "El tauler ha de mesurar 10";
        assert x >= 0 && x <= 9:
            "Les coodenades han d'estar dins del rang";
        assert y >= 0 && y <= 9:
            "Les coodenades han d'estar dins del rang";
        assert ships != null:
            "La llista de vaixes no pot estar buida";

        //Validar les coordenades
        if (x < 0 || x > 9 || y < 0 || y > 9){
            return false;
        }

        //Cell ja golpejada?

        if (board[x][y] == -1){
            return false;
        }

        //Si no ha estat golpejada
        //Marcar com golpejada
        //Es golpeja un vaixell?
        if(board[x][y] == 1){
            //Marcar el ship com a golpejat
            board[x][y] = -1;

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
            //Aigua = -1
            board[x][y] = -1;
            System.out.println("Aigua");
            return false;
        }

        assert board != null:
            "El tauler no pot ser null";
        return false;


    }

    /**
     * Checks if all ships are sunk.
     *
     * @return true if all ships are sunk, false otherwise
     */
    public boolean isAllShipsSunk() {

        //Precondicions
        assert ships != null:
            "No pot no haver-hi vaixells";
        if(ships == null){
            return false;
        }
        for(Ship ship: ships){
            //Si algun no està enfonsat
            if(!ship.isSunk()){
                return false;
            }
        }
        return true;
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
