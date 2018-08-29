package chess.player;

import chess.common.Color;
import chess.common.Movement;

import java.util.Observable;
import java.util.Observer;

/**
 * Date: Sep 17, 2004
 * Time: 12:19:29 PM
 *
 * @author Vahid Mavaji
 * @version 1.1
 */
public class ComputerPlayer extends Player implements Observer {
    public ComputerPlayer(Color color) {
        this.color = color;
    }

    public Movement move() {
        return null;
    }

    public void update(Observable o, Object arg) {
    }
}
