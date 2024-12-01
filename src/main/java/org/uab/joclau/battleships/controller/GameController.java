package org.uab.joclau.battleships.controller;

import org.uab.joclau.battleships.model.*;
import org.uab.joclau.battleships.view.BoardView;

import java.util.Scanner;

/**
 * Metode auxiliar per provar manualment el joc
 */
public class GameController {

    private Player player1;
    private Player player2;

    /**
     * Creacio dels jugadors
     */
    public GameController(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    /**
     * Situacio inicial dels vaixells als taulers
     *
     * @param player the player placing ships.
     */
    public void placeShips(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(player.getName() + ", place your ships:");

        for (int i = 1; i <= 5; i++) { // En aquest cas, posarem 5 vaixells amb longituds 1,2,3,4,5
            System.out.println("Placing ship of size " + i);

            boolean placed = false;
            while (!placed) {
                System.out.print("Enter x, y coordinates and orientation (h/v): ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                char orientation = scanner.next().charAt(0);
                boolean isHorizontal = (orientation == 'h');

                Ship ship = new Ship(BoardUtils.generateCells(x, y, i, isHorizontal), i);
                if (player.placeShips(ship, x, y, isHorizontal)) {
                    System.out.println("Ship placed successfully!");
                    placed = true;
                } else {
                    System.out.println("Invalid placement. Try again.");
                }
            }
        }
    }

    /**
     * S'encarrega de gestionar la lógica dels torns
     */
    public void playGame() {
        Player currentPlayer = player1;
        Player opponent = player2;
        Scanner scanner = new Scanner(System.in);
        BoardView boardView = new BoardView();

        while (!player1.getBoard().isGameOver() && !player2.getBoard().isGameOver()) {
            boardView.displayBoard(currentPlayer.getBoard());
            System.out.println(currentPlayer.getName() + ", it's your turn!");

            System.out.print("Enter x, y coordinates to shoot: ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            boolean hit = player1.takeTurn(opponent,x,y); //opponent.getBoard().takeShot(x, y);
            boardView.showShotResult(x,y,hit);
            // Canvi de jugadors
            Player aux = currentPlayer;
            currentPlayer = opponent;
            opponent = aux;
        }

        System.out.println("Game over! Winner: " + (player1.getBoard().isGameOver() ? player2.getName() : player1.getName()));
    }

    public Player getPlayer1() {
        return this.player1;
    }
    public Player getPlayer2() {
        return this.player2;
    }
}
