package chessold;

/**
 * @author Vahid Mavaji
 * @version 1.1
 */
public class State {
    public State() {

    }

    public State(State s) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.array[i][j] = s.array[i][j];
                this.color[i][j] = s.color[i][j];
            }
        }
    }

    public ChessEntity[][] array = new ChessEntity[8][8];
    public ChessEntity[][] color = new ChessEntity[8][8];
}
