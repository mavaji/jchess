package chess.player;

import chess.common.Color;
import chess.common.Movement;

import java.util.Observable;

/**
 * Date: Sep 17, 2004
 * Time: 12:18:10 PM
 *
 * @author Vahid Mavaji
 * @version 1.1
 */
public abstract class Player extends Observable {
    protected Color color;

    public abstract Movement move();
}
