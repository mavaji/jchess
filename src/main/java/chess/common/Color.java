package chess.common;

/**
 * Date: Sep 17, 2004
 * Time: 10:43:45 AM
 *
 * @author Vahid Mavaji
 * @version 1.1
 */
public enum Color {
    WHITE,
    BLACK;

    public Color opposite() {
        if (this.equals(WHITE)) {
            return BLACK;
        } else {
            return WHITE;
        }
    }
}
