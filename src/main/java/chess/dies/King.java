package chess.dies;

import chess.common.ChessDie;
import chess.common.Color;

import static chess.common.Color.WHITE;
import static chess.common.DieConstants.KING_NAME;
import static chess.common.DieConstants.KING_VALUE;
import static chess.common.MovementDirection.MOV_KING;

/**
 * Date: Sep 15, 2004
 * Time: 12:02:43 PM
 *
 * @author Vahid Mavaji
 * @version 1.1
 */
public class King extends ChessDie {
    public King() {
        color = WHITE;
    }

    public King(Color color) {
        this.color = color;
    }

    public void alterMovementDirections() {
        movementDirections.add(MOV_KING);
    }

    public void alterName() {
        name = KING_NAME;
    }

    public int alterValue() {
        return KING_VALUE;
    }
}
