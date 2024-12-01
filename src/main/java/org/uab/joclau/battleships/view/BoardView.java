package org.uab.joclau.battleships.view;

import org.uab.joclau.battleships.model.Board;

/**
 * Visualización de la interfaz del tablero de juego.
 */
public class BoardView {

  /**
   * Muestra el tablero en la vista.
   *
   * @param board El tablero que se va a mostrar.
   */
  public void displayBoard(final Board board) {
    // Lógica para mostrar el tablero
    int[][] tauler = board.getBoard();
    System.out.print("  ");
    System.out.println("Situació del teu Tauler de Joc:");
    System.out.print("  ");

    for (int i = 0; i < 10; i++) {
      System.out.print(i + " ");
    }
    System.out.println();

    // Imprime las filas del tablero
    for (int i = 0; i < 10; i++) {
      System.out.print(i + " ");  // Imprime la fila
      for (int j = 0; j < 10; j++) {
        char cellDisplay;
        // Determina el contenido de cada celda
        switch (tauler[i][j]) {
          case 0:
            cellDisplay = '.'; // Agua o celda vacía
            break;
          case 1:
            cellDisplay = 'B'; // Barco
            break;
          case -1:
            cellDisplay = 'X'; // Disparo fallido
            break;
          default:
            cellDisplay = ' '; // En caso de otros valores
            break;
        }
        System.out.print(cellDisplay + " ");
      }
      System.out.println(); // Salto de línea por cada fila
    }
  }

  /**
   * Muestra el resultado de un disparo.
   *
   * @param x la coordenada X del disparo.
   * @param y la coordenada Y del disparo.
   * @param hit Indica si el disparo fue un impacto.
   */
  public void showShotResult(final int x, final int y, final boolean hit) {
    // Lógica para mostrar el resultado del disparo
    if (hit) {
      System.out.println("¡Impacto en (" + x + ", " + y + ")!");
    } else {
      System.out.println("¡Fallaste en (" + x + ", " + y + ")!");
    }
  }
}
