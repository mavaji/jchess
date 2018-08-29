package chessold;

/**
 * @author Vahid Mavaji
 * @version 1.1
 */
public enum ChessEntity {
    wPawn,
    wBishop,
    wKnight,
    wRook,
    wQueen,
    wKing,
    bPawn,
    bBishop,
    bKnight,
    bRook,
    bQueen,
    bKing,
    white,
    black,
    nothing;

    static int PawnValue = 1;
    static int BishopValue = 2;
    static int KnightValue = 3;
    static int RookValue = 4;
    static int QueenValue = 5;
    static int KingValue = 6;

    static int depth = 2;
}
