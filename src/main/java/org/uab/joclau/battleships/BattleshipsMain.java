package org.uab.joclau.battleships;

import org.uab.joclau.battleships.controller.GameController;

import java.util.Scanner;

public class BattleshipsMain {

    public static void main(String[] args) {
        // Main in order to test
        Scanner scanner = new Scanner(System.in);

        // Inicia los jugadores
        System.out.print("Enter name for Player 1: ");
        String player1Name = scanner.nextLine();

        System.out.print("Enter name for Player 2: ");
        String player2Name = scanner.nextLine();

        // Inicia el controlador del juego
        GameController gameController = new GameController(player1Name, player2Name);

        // Fase de colocación de barcos
        System.out.println("\n=== Placement Phase ===");
        gameController.placeShips(gameController.getPlayer1());
        gameController.placeShips(gameController.getPlayer2());

        // Comienza el juego
        System.out.println("\n=== Battle Phase ===");
        gameController.playGame();
    }
}
