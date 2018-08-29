package chess.dies;

import chess.common.ChessDie;
import chess.common.Color;

import static chess.common.Color.WHITE;
import static chess.common.DieConstants.QUEEN_NAME;
import static chess.common.DieConstants.QUEEN_VALUE;
import static chess.common.MovementDirection.*;


/**
 * Date: Sep 15, 2004
 * Time: 11:52:55 AM
 *
 * @author Vahid Mavaji
 * @version 1.1
 */
public class Queen extends ChessDie {
    public Queen() {
        color = WHITE;
    }

    public Queen(Color color) {
        this.color = color;
    }

    public void alterMovementDirections() {
        movementDirections.add(MOV_HORIZONTAL);
        movementDirections.add(MOV_VERTICAL);
        movementDirections.add(MOV_DIAGONAL);
    }

    public void alterName() {
        name = QUEEN_NAME;
    }

    public int alterValue() {
        return QUEEN_VALUE;
    }
}
