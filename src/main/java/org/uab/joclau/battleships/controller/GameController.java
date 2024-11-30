package org.uab.joclau.battleships.controller;

import org.uab.joclau.battleships.model.Player;

public class GameController {

    private Player player1;
    private Player player2;

    public GameController(String name1, String name2) {
        player1 = new Player(name1);
    }
}
