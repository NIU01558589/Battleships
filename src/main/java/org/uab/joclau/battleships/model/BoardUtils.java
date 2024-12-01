package org.uab.joclau.battleships.model;

import java.util.ArrayList;
import java.util.List;

public class BoardUtils {

    /**
     * Situació automatica del vaixell depenent de la posicio incial indicada
     *
     * @param x             The starting row (x) of the ship.
     * @param y             The starting column (y) of the ship.
     * @param size          The size of the ship.
     * @param isHorizontal  True if the ship is placed horizontally, false for vertical placement.
     * @return A list of Cell objects representing the positions occupied by the ship.
     */
    public static List<Cell> generateCells(int x, int y, int size, boolean isHorizontal) {
        List<Cell> cells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (isHorizontal) {
                // genera les celles en cas de ser un vaixell horitzontal
                cells.add(new Cell(x, y + i));
            } else {
                // genera les celles en cas de ser un vaixell vertical
                cells.add(new Cell(x + i, y));
            }
        }

        return cells;
    }
}
