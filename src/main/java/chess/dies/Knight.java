package chess.dies;

import chess.common.ChessDie;
import chess.common.Color;

import static chess.common.Color.WHITE;
import static chess.common.DieConstants.KNIGHT_NAME;
import static chess.common.DieConstants.KNIGHT_VALUE;
import static chess.common.MovementDirection.MOV_KNIGHT;


/**
 * Date: Sep 15, 2004
 * Time: 11:48:45 AM
 *
 * @author Vahid Mavaji
 * @version 1.1
 */
public class Knight extends ChessDie {

    public Knight() {
        color = WHITE;
    }

    public Knight(Color color) {
        this.color = color;
    }

    public void alterMovementDirections() {
        movementDirections.add(MOV_KNIGHT);
    }

    public void alterName() {
        name = KNIGHT_NAME;
    }

    public int alterValue() {
        return KNIGHT_VALUE;
    }
}
