package chess.common;

import java.util.Vector;

/**
 * Date: Sep 15, 2004
 * Time: 11:26:41 AM
 *
 * @author Vahid Mavaji
 * @version 1.1
 */
public abstract class ChessDie {

    protected Color color;
    protected Vector<MovementDirection> movementDirections = new Vector<MovementDirection>();
    protected String name;
    protected int value;

    public ChessDie() {
        alterMovementDirections();
        alterName();
        alterValue();
    }

    public Color getColor() {
        return color;
    }

    public Vector<MovementDirection> getMovementDirections() {
        return movementDirections;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public abstract void alterMovementDirections();

    public abstract void alterName();

    public abstract int alterValue();
}
