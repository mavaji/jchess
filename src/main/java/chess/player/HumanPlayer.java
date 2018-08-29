package chess.player;

import chess.common.Color;
import chess.common.Movement;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Date: Sep 17, 2004
 * Time: 12:19:18 PM
 *
 * @author Vahid Mavaji
 * @version 1.1
 */
public class HumanPlayer extends Player implements Observer {
    public Point from;
    public Point to;

    public HumanPlayer(Color color) {
        this.color = color;
    }

    public Movement move() {
        return new Movement(from, to, color);
    }

    public void update(Observable o, Object arg) {

    }
}
