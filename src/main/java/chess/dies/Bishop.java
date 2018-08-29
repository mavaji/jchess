package chess.dies;

import chess.common.ChessDie;
import chess.common.Color;

import static chess.common.Color.WHITE;
import static chess.common.DieConstants.BISHOP_NAME;
import static chess.common.DieConstants.BISHOP_VALUE;
import static chess.common.MovementDirection.MOV_DIAGONAL;

/**
 * Date: Sep 15, 2004
 * Time: 11:46:34 AM
 *
 * @author Vahid Mavaji
 * @version 1.1
 */
public class Bishop extends ChessDie {
    public Bishop() {
        color = WHITE;
    }

    public Bishop(Color color) {
        this.color = color;
    }

    public void alterMovementDirections() {
        movementDirections.add(MOV_DIAGONAL);
    }

    public void alterName() {
        name = BISHOP_NAME;
    }

    public int alterValue() {
        return BISHOP_VALUE;
    }
}
