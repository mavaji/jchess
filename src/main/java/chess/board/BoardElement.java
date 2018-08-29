package chess.board;

import chess.common.ChessDie;
import chess.common.Color;

import static chess.common.Color.WHITE;

/**
 * Date: Sep 15, 2004
 * Time: 12:09:56 PM
 *
 * @author Vahid Mavaji
 * @version 1.1
 */
public class BoardElement {
    private Color color;
    private ChessDie chessDie;

    public BoardElement() {
        color = WHITE;
        chessDie = null;
    }

    public BoardElement(Color color, ChessDie chessDie) {
        this.color = color;
        this.chessDie = chessDie;
    }

    public Color getColor() {
        return color;
    }

    public BoardElement setColor(Color color) {
        this.color = color;
        return this;
    }

    public ChessDie getChessDie() {
        return chessDie;
    }

    public BoardElement alterChessDie(ChessDie chessDie) {
        this.chessDie = chessDie;
        return this;
    }
}
