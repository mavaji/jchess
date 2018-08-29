package chess.dies;

import chess.common.ChessDie;
import chess.common.Color;

import static chess.common.Color.WHITE;
import static chess.common.DieConstants.PAWN_NAME;
import static chess.common.DieConstants.PAWN_VALUE;
import static chess.common.MovementDirection.MOV_PAWN;


/**
 * Date: Sep 15, 2004
 * Time: 11:33:39 AM
 *
 * @author Vahid Mavaji
 * @version 1.1
 */
public class Pawn extends ChessDie {
    public Pawn() {
        color = WHITE;
    }

    public Pawn(Color color) {
        this.color = color;
    }

    public void alterMovementDirections() {
        movementDirections.add(MOV_PAWN);
    }

    public void alterName() {
        name = PAWN_NAME;
    }

    public int alterValue() {
        return PAWN_VALUE;
    }
}
