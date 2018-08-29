package chess.board;

import chess.common.Color;
import chess.dies.*;

import java.util.Observable;
import java.util.Observer;

import static chess.common.Color.BLACK;
import static chess.common.Color.WHITE;

/**
 * Date: Sep 15, 2004
 * Time: 12:15:08 PM
 *
 * @author Vahid Mavaji
 * @version 1.1
 */
public class Board extends Observable implements Cloneable, Observer {
    public BoardElement[][] board = new BoardElement[8][8];
    private Color bottomColor = WHITE;
    private Color topColor = BLACK;
    private boolean isWhiteBottom = true;

    public Board() {
    }

    public Board(boolean isWhiteBottom) {
        if (!isWhiteBottom) {
            isWhiteBottom = false;
            bottomColor = BLACK;
            topColor = WHITE;
        }
    }

    public void reset() {

        board[0][0] = new BoardElement(WHITE, new Rook(topColor));
        board[0][1] = new BoardElement(BLACK, new Knight(topColor));
        board[0][2] = new BoardElement(WHITE, new Bishop(topColor));
        if (topColor.equals(BLACK)) {
            board[0][3] = new BoardElement(BLACK, new Queen(topColor));
            board[0][4] = new BoardElement(WHITE, new King(topColor));
        } else {
            board[0][3] = new BoardElement(BLACK, new King(topColor));
            board[0][4] = new BoardElement(WHITE, new Queen(topColor));
        }
        board[0][5] = new BoardElement(BLACK, new Bishop(topColor));
        board[0][6] = new BoardElement(WHITE, new Knight(topColor));
        board[0][7] = new BoardElement(BLACK, new Rook(topColor));

        board[1][0] = new BoardElement(BLACK, new Pawn(topColor));
        board[1][1] = new BoardElement(WHITE, new Pawn(topColor));
        board[1][2] = new BoardElement(BLACK, new Pawn(topColor));
        board[1][3] = new BoardElement(WHITE, new Pawn(topColor));
        board[1][4] = new BoardElement(BLACK, new Pawn(topColor));
        board[1][5] = new BoardElement(WHITE, new Pawn(topColor));
        board[1][6] = new BoardElement(BLACK, new Pawn(topColor));
        board[1][7] = new BoardElement(WHITE, new Pawn(topColor));

        markEmpty(2, 5);

        board[6][0] = new BoardElement(WHITE, new Pawn(bottomColor));
        board[6][1] = new BoardElement(BLACK, new Pawn(bottomColor));
        board[6][2] = new BoardElement(WHITE, new Pawn(bottomColor));
        board[6][3] = new BoardElement(BLACK, new Pawn(bottomColor));
        board[6][4] = new BoardElement(WHITE, new Pawn(bottomColor));
        board[6][5] = new BoardElement(BLACK, new Pawn(bottomColor));
        board[6][6] = new BoardElement(WHITE, new Pawn(bottomColor));
        board[6][7] = new BoardElement(BLACK, new Pawn(bottomColor));

        board[7][0] = new BoardElement(BLACK, new Rook(bottomColor));
        board[7][1] = new BoardElement(WHITE, new Knight(bottomColor));
        board[7][2] = new BoardElement(BLACK, new Bishop(bottomColor));
        if (bottomColor.equals(WHITE)) {
            board[7][3] = new BoardElement(WHITE, new Queen(bottomColor));
            board[7][4] = new BoardElement(BLACK, new King(bottomColor));
        } else {
            board[7][3] = new BoardElement(WHITE, new King(bottomColor));
            board[7][4] = new BoardElement(BLACK, new Queen(bottomColor));
        }
        board[7][5] = new BoardElement(WHITE, new Bishop(bottomColor));
        board[7][6] = new BoardElement(BLACK, new Knight(bottomColor));
        board[7][7] = new BoardElement(WHITE, new Rook(bottomColor));
    }

    private void markEmpty(int beginRow, int endRow) {
        for (int row = beginRow; row <= endRow; row++) {
            for (int col = 0; col < 8; col++) {
                Color color = (row % 2 == 0) ? (col % 2 == 0 ? WHITE : BLACK) : (col % 2 == 0 ? BLACK : WHITE);
                board[row][col] = new BoardElement().setColor(color);
            }
        }
    }

    public boolean isWhiteBottom() {
        return isWhiteBottom;
    }

    public Object clone() {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return object;
    }

    public void update(Observable o, Object arg) {


    }
}
