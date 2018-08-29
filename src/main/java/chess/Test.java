package chess;

import chess.board.Board;
import chess.common.Color;
import chess.player.ComputerPlayer;
import chess.player.HumanPlayer;

import static chess.common.Color.BLACK;
import static chess.common.Color.WHITE;


/**
 * Date: Sep 15, 2004
 * Time: 12:49:04 PM
 *
 * @author Vahid Mavaji
 * @version 1.1
 */
public class Test {
    public void f() {
        Board board = new Board();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(((board.board[i][j].getChessDie() != null) ?
                        (board.board[i][j].getChessDie().getName()) : "")
                        + " " +
                        (board.board[i][j].getColor() == Color.BLACK ? "BLACK" : "WHITE")
                        + "\t");
            }
            System.out.println();
        }
        System.out.println("*****************************************");

        board = new Board(false);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(((board.board[i][j].getChessDie() != null) ?
                        (board.board[i][j].getChessDie().getName()) : "")
                        + " " +
                        (board.board[i][j].getColor() == Color.BLACK ? "BLACK" : "WHITE")
                        + "\t");
            }
            System.out.println();
        }

    }


    public void g() {
        chess.common.Color color = WHITE;
        System.out.println(color + " " + color.opposite());
        color = BLACK;
        System.out.println(color + " " + color.opposite());
    }

    public void h() {
        Board board = new Board();
        board.reset();
        Board board1 = (Board) board.clone();
        board1.reset();
        System.out.println(board == board1);
        System.out.println(board.getClass() == board1.getClass());
        System.out.println(board.board[0][0].getColor().equals(board1.board[0][0].getColor()));


    }

    public void x() {
        Board board = new Board();
        HumanPlayer humanPlayer = new HumanPlayer(BLACK);
        ComputerPlayer computerPlayer = new ComputerPlayer(WHITE);

        board.addObserver(humanPlayer);
        board.addObserver(computerPlayer);
        humanPlayer.addObserver(board);
        computerPlayer.addObserver(board);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.x();
    }
}
