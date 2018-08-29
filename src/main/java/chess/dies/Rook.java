package chess.dies;

import chess.common.ChessDie;
import chess.common.Color;

import static chess.common.Color.WHITE;
import static chess.common.DieConstants.ROOK_NAME;
import static chess.common.DieConstants.ROOK_VALUE;
import static chess.common.MovementDirection.MOV_HORIZONTAL;
import static chess.common.MovementDirection.MOV_VERTICAL;


/**
 * Date: Sep 15, 2004
 * Time: 11:51:02 AM
 *
 * @author Vahid Mavaji
 * @version 1.1
 */
public class Rook extends ChessDie {
    public Rook() {
        color = WHITE;
    }

    public Rook(Color color) {
        this.color = color;
    }

    public void alterMovementDirections() {
        movementDirections.add(MOV_HORIZONTAL);
        movementDirections.add(MOV_VERTICAL);
    }

    public void alterName() {
        name = ROOK_NAME;
    }

    public int alterValue() {
        return ROOK_VALUE;
    }
}
