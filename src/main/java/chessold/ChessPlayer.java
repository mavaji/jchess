package chessold;

import java.awt.*;
import java.util.Vector;

import static chessold.ChessEntity.*;

/**
 * @author Vahid Mavaji
 * @version 1.1
 */
public class ChessPlayer {

    public ChessPlayer() {
        init();
    }

    public void init() {
        for (int i = 0; i < 8; i++) {
            if (i == 0) {
                Board.array[i][0] = wRook;

                Board.array[i][1] = wKnight;

                Board.array[i][2] = wBishop;

                Board.array[i][3] = wKing;

                Board.array[i][4] = wQueen;

                Board.array[i][5] = wBishop;

                Board.array[i][6] = wKnight;

                Board.array[i][7] = wRook;

            } else if (i == 7) {
                Board.array[i][0] = bRook;

                Board.array[i][1] = bKnight;

                Board.array[i][2] = bBishop;

                Board.array[i][3] = bKing;

                Board.array[i][4] = bQueen;

                Board.array[i][5] = bBishop;

                Board.array[i][6] = bKnight;

                Board.array[i][7] = bRook;

            } else if (i == 1) {
                for (int j = 0; j < 8; j++) {
                    Board.array[i][j] = wPawn;
                }
            } else if (i == 6) {
                for (int j = 0; j < 8; j++) {
                    Board.array[i][j] = bPawn;
                }
            } else {
                for (int j = 0; j < 8; j++) {
                    Board.array[i][j] = nothing;
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0 || i == 1) {
                    Board.color[i][j] = white;
                } else if (i == 6 || i == 7) {
                    Board.color[i][j] = black;
                } else {
                    Board.color[i][j] = nothing;
                }
            }
        }


    }

    public Vector makeMove(State s, ChessEntity color) {
        Vector v = new Vector();
        State temp = new State();

        if (color == white) {
            boolean checked = isChecked(s, white);

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (s.array[i][j]) {
                        case wPawn:
                            if (i == 1) {
                                if (s.array[i + 2][j] == nothing && s.array[i + 1][j] == nothing) {
                                    temp = new State(s);

                                    temp.array[i + 2][j] = wPawn;
                                    temp.array[i][j] = nothing;
                                    temp.color[i + 2][j] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i < 7) {
                                if (s.array[i + 1][j] == nothing) {
                                    temp = new State(s);

                                    temp.array[i + 1][j] = wPawn;
                                    temp.array[i][j] = nothing;
                                    temp.color[i + 1][j] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (j > 0 && i < 7) {
                                if (s.color[i + 1][j - 1] == black) {
                                    temp = new State(s);

                                    temp.array[i + 1][j - 1] = wPawn;
                                    temp.array[i][j] = nothing;
                                    temp.color[i + 1][j - 1] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (j < 7 && i < 7) {
                                if (s.color[i + 1][j + 1] == black) {
                                    temp = new State(s);

                                    temp.array[i + 1][j + 1] = wPawn;
                                    temp.array[i][j] = nothing;
                                    temp.color[i + 1][j + 1] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }

                            break;

                        case wBishop:
                            int ii = i, jj = j;
                            while (ii < 7 && jj > 0) {
                                ii++;
                                jj--;
                                if (s.color[ii][jj] != white) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = wBishop;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == black) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (ii < 7 && jj < 7) {
                                ii++;
                                jj++;
                                if (s.color[ii][jj] != white) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = wBishop;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == black) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (ii > 0 && jj > 0) {
                                ii--;
                                jj--;
                                if (s.color[ii][jj] != white) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = wBishop;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == black) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (ii > 0 && jj < 7) {
                                ii--;
                                jj++;
                                if (s.color[ii][jj] != white) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = wBishop;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == black) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }


                            break;

                        case wKnight:
                            if (i + 2 <= 7 && j - 1 >= 0) {
                                if (s.color[i + 2][j - 1] != white) {
                                    temp = new State(s);

                                    temp.array[i + 2][j - 1] = wKnight;
                                    temp.array[i][j] = nothing;
                                    temp.color[i + 2][j - 1] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i + 2 <= 7 && j + 1 <= 7) {
                                if (s.color[i + 2][j + 1] != white) {
                                    temp = new State(s);

                                    temp.array[i + 2][j + 1] = wKnight;
                                    temp.array[i][j] = nothing;
                                    temp.color[i + 2][j + 1] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i - 2 >= 0 && j - 1 >= 0) {
                                if (s.color[i - 2][j - 1] != white) {
                                    temp = new State(s);

                                    temp.array[i - 2][j - 1] = wKnight;
                                    temp.array[i][j] = nothing;
                                    temp.color[i - 2][j - 1] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i - 2 >= 0 && j + 1 <= 7) {
                                if (s.color[i - 2][j + 1] != white) {
                                    temp = new State(s);

                                    temp.array[i - 2][j + 1] = wKnight;
                                    temp.array[i][j] = nothing;
                                    temp.color[i - 2][j + 1] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i - 1 >= 0 && j - 2 >= 0) {
                                if (s.color[i - 1][j - 2] != white) {
                                    temp = new State(s);

                                    temp.array[i - 1][j - 2] = wKnight;
                                    temp.array[i][j] = nothing;
                                    temp.color[i - 1][j - 2] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i + 1 <= 7 && j - 2 >= 0) {
                                if (s.color[i + 1][j - 2] != white) {
                                    temp = new State(s);

                                    temp.array[i + 1][j - 2] = wKnight;
                                    temp.array[i][j] = nothing;
                                    temp.color[i + 1][j - 2] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i - 1 >= 0 && j + 2 <= 7) {
                                if (s.color[i - 1][j + 2] != white) {
                                    temp = new State(s);

                                    temp.array[i - 1][j + 2] = wKnight;
                                    temp.array[i][j] = nothing;
                                    temp.color[i - 1][j + 2] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i + 1 <= 7 && j + 2 <= 7) {
                                if (s.color[i + 1][j + 2] != white) {
                                    temp = new State(s);

                                    temp.array[i + 1][j + 2] = wKnight;
                                    temp.array[i][j] = nothing;
                                    temp.color[i + 1][j + 2] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }

                            break;

                        case wRook:
                            ii = i;
                            jj = j;
                            while (ii < 7) {
                                ii++;
                                if (s.color[ii][jj] != white) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = wRook;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == black) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (ii > 0) {
                                ii--;
                                if (s.color[ii][jj] != white) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = wRook;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == black) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (jj < 7) {
                                jj++;
                                if (s.color[ii][jj] != white) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = wRook;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == black) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (jj > 0) {
                                jj--;
                                if (s.color[ii][jj] != white) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = wRook;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == black) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            break;

                        case wQueen:
                            ii = i;
                            jj = j;
                            while (ii < 7) {
                                ii++;
                                if (s.color[ii][jj] != white) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = wQueen;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == black) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (ii > 0) {
                                ii--;
                                if (s.color[ii][jj] != white) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = wQueen;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == black) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (jj < 7) {
                                jj++;
                                if (s.color[ii][jj] != white) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = wQueen;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == black) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (jj > 0) {
                                jj--;
                                if (s.color[ii][jj] != white) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = wQueen;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == black) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (ii < 7 && jj > 0) {
                                ii++;
                                jj--;
                                if (s.color[ii][jj] != white) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = wQueen;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == black) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (ii < 7 && jj < 7) {
                                ii++;
                                jj++;
                                if (s.color[ii][jj] != white) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = wQueen;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == black) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (ii > 0 && jj > 0) {
                                ii--;
                                jj--;
                                if (s.color[ii][jj] != white) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = wQueen;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == black) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (ii > 0 && jj < 7) {
                                ii--;
                                jj++;
                                if (s.color[ii][jj] != white) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = wQueen;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == black) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            break;

                        case wKing:
                            if (i > 0) {
                                if (s.color[i - 1][j] != white) {
                                    temp = new State(s);

                                    temp.array[i - 1][j] = wKing;
                                    temp.array[i][j] = nothing;
                                    temp.color[i - 1][j] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i < 7) {
                                if (s.color[i + 1][j] != white) {
                                    temp = new State(s);

                                    temp.array[i + 1][j] = wKing;
                                    temp.array[i][j] = nothing;
                                    temp.color[i + 1][j] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (j > 0) {
                                if (s.color[i][j - 1] != white) {
                                    temp = new State(s);

                                    temp.array[i][j - 1] = wKing;
                                    temp.array[i][j] = nothing;
                                    temp.color[i][j - 1] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (j < 7) {
                                if (s.color[i][j + 1] != white) {
                                    temp = new State(s);

                                    temp.array[i][j + 1] = wKing;
                                    temp.array[i][j] = nothing;
                                    temp.color[i][j + 1] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i > 0 && j > 0) {
                                if (s.color[i - 1][j - 1] != white) {
                                    temp = new State(s);

                                    temp.array[i - 1][j - 1] = wKing;
                                    temp.array[i][j] = nothing;
                                    temp.color[i - 1][j - 1] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i > 0 && j < 7) {
                                if (s.color[i - 1][j + 1] != white) {
                                    temp = new State(s);

                                    temp.array[i - 1][j + 1] = wKing;
                                    temp.array[i][j] = nothing;
                                    temp.color[i - 1][j + 1] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i < 7 && j > 0) {
                                if (s.color[i + 1][j - 1] != white) {
                                    temp = new State(s);

                                    temp.array[i + 1][j - 1] = wKing;
                                    temp.array[i][j] = nothing;
                                    temp.color[i + 1][j - 1] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i < 7 && j < 7) {
                                if (s.color[i + 1][j + 1] != white) {
                                    temp = new State(s);

                                    temp.array[i + 1][j + 1] = wKing;
                                    temp.array[i][j] = nothing;
                                    temp.color[i + 1][j + 1] = white;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, white) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            break;
                    }
                }
            }
        } else {
            boolean checked = isChecked(s, black);

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (s.array[i][j]) {
                        case bPawn:
                            if (i == 6) {
                                if (s.array[i - 2][j] == nothing && s.array[i - 1][j] == nothing) {
                                    temp = new State(s);

                                    temp.array[i - 2][j] = bPawn;
                                    temp.array[i][j] = nothing;
                                    temp.color[i - 2][j] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i > 0) {
                                if (s.array[i - 1][j] == nothing) {
                                    temp = new State(s);

                                    temp.array[i - 1][j] = bPawn;
                                    temp.array[i][j] = nothing;
                                    temp.color[i - 1][j] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (j > 0 && i > 0) {
                                if (s.color[i - 1][j - 1] == white) {
                                    temp = new State(s);

                                    temp.array[i - 1][j - 1] = bPawn;
                                    temp.array[i][j] = nothing;
                                    temp.color[i - 1][j - 1] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (j < 7 && i > 0) {
                                if (s.color[i - 1][j + 1] == white) {
                                    temp = new State(s);

                                    temp.array[i - 1][j + 1] = bPawn;
                                    temp.array[i][j] = nothing;
                                    temp.color[i - 1][j + 1] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }

                            break;

                        case bBishop:
                            int ii = i, jj = j;
                            while (ii < 7 && jj > 0) {
                                ii++;
                                jj--;
                                if (s.color[ii][jj] != black) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = bBishop;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == white) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (ii < 7 && jj < 7) {
                                ii++;
                                jj++;
                                if (s.color[ii][jj] != black) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = bBishop;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == white) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (ii > 0 && jj > 0) {
                                ii--;
                                jj--;
                                if (s.color[ii][jj] != black) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = bBishop;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == white) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (ii > 0 && jj < 7) {
                                ii--;
                                jj++;
                                if (s.color[ii][jj] != black) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = bBishop;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == white) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }


                            break;

                        case bKnight:
                            if (i + 2 <= 7 && j - 1 >= 0) {
                                if (s.color[i + 2][j - 1] != black) {
                                    temp = new State(s);

                                    temp.array[i + 2][j - 1] = bKnight;
                                    temp.array[i][j] = nothing;
                                    temp.color[i + 2][j - 1] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i + 2 <= 7 && j + 1 <= 7) {
                                if (s.color[i + 2][j + 1] != black) {
                                    temp = new State(s);

                                    temp.array[i + 2][j + 1] = bKnight;
                                    temp.array[i][j] = nothing;
                                    temp.color[i + 2][j + 1] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i - 2 >= 0 && j - 1 >= 0) {
                                if (s.color[i - 2][j - 1] != black) {
                                    temp = new State(s);

                                    temp.array[i - 2][j - 1] = bKnight;
                                    temp.array[i][j] = nothing;
                                    temp.color[i - 2][j - 1] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i - 2 >= 0 && j + 1 <= 7) {
                                if (s.color[i - 2][j + 1] != black) {
                                    temp = new State(s);

                                    temp.array[i - 2][j + 1] = bKnight;
                                    temp.array[i][j] = nothing;
                                    temp.color[i - 2][j + 1] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i - 1 >= 0 && j - 2 >= 0) {
                                if (s.color[i - 1][j - 2] != black) {
                                    temp = new State(s);

                                    temp.array[i - 1][j - 2] = bKnight;
                                    temp.array[i][j] = nothing;
                                    temp.color[i - 1][j - 2] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i + 1 <= 7 && j - 2 >= 0) {
                                if (s.color[i + 1][j - 2] != black) {
                                    temp = new State(s);

                                    temp.array[i + 1][j - 2] = bKnight;
                                    temp.array[i][j] = nothing;
                                    temp.color[i + 1][j - 2] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i - 1 >= 0 && j + 2 <= 7) {
                                if (s.color[i - 1][j + 2] != black) {
                                    temp = new State(s);

                                    temp.array[i - 1][j + 2] = bKnight;
                                    temp.array[i][j] = nothing;
                                    temp.color[i - 1][j + 2] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i + 1 <= 7 && j + 2 <= 7) {
                                if (s.color[i + 1][j + 2] != black) {
                                    temp = new State(s);

                                    temp.array[i + 1][j + 2] = bKnight;
                                    temp.array[i][j] = nothing;
                                    temp.color[i + 1][j + 2] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }

                            break;

                        case bRook:
                            ii = i;
                            jj = j;
                            while (ii < 7) {
                                ii++;
                                if (s.color[ii][jj] != black) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = bRook;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == white) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (ii > 0) {
                                ii--;
                                if (s.color[ii][jj] != black) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = bRook;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == white) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (jj < 7) {
                                jj++;
                                if (s.color[ii][jj] != black) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = bRook;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == white) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (jj > 0) {
                                jj--;
                                if (s.color[ii][jj] != black) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = bRook;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == white) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            break;

                        case bQueen:
                            ii = i;
                            jj = j;
                            while (ii < 7) {
                                ii++;
                                if (s.color[ii][jj] != black) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = bQueen;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == white) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (ii > 0) {
                                ii--;
                                if (s.color[ii][jj] != black) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = bQueen;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == white) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (jj < 7) {
                                jj++;
                                if (s.color[ii][jj] != black) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = bQueen;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == white) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (jj > 0) {
                                jj--;
                                if (s.color[ii][jj] != black) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = bQueen;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == white) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (ii < 7 && jj > 0) {
                                ii++;
                                jj--;
                                if (s.color[ii][jj] != black) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = bQueen;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == white) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (ii < 7 && jj < 7) {
                                ii++;
                                jj++;
                                if (s.color[ii][jj] != black) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = bQueen;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == white) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (ii > 0 && jj > 0) {
                                ii--;
                                jj--;
                                if (s.color[ii][jj] != black) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = bQueen;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == white) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            ii = i;
                            jj = j;
                            while (ii > 0 && jj < 7) {
                                ii--;
                                jj++;
                                if (s.color[ii][jj] != black) {
                                    temp = new State(s);

                                    temp.array[ii][jj] = bQueen;
                                    temp.array[i][j] = nothing;
                                    temp.color[ii][jj] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == true) {
                                            continue;
                                        }
                                    }
                                    v.add(temp);
                                    if (s.color[ii][jj] == white) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            break;

                        case bKing:
                            if (i > 0) {
                                if (s.color[i - 1][j] != black) {
                                    temp = new State(s);

                                    temp.array[i - 1][j] = bKing;
                                    temp.array[i][j] = nothing;
                                    temp.color[i - 1][j] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i < 7) {
                                if (s.color[i + 1][j] != black) {
                                    temp = new State(s);

                                    temp.array[i + 1][j] = bKing;
                                    temp.array[i][j] = nothing;
                                    temp.color[i + 1][j] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (j > 0) {
                                if (s.color[i][j - 1] != black) {
                                    temp = new State(s);

                                    temp.array[i][j - 1] = bKing;
                                    temp.array[i][j] = nothing;
                                    temp.color[i][j - 1] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (j < 7) {
                                if (s.color[i][j + 1] != black) {
                                    temp = new State(s);

                                    temp.array[i][j + 1] = bKing;
                                    temp.array[i][j] = nothing;
                                    temp.color[i][j + 1] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i > 0 && j > 0) {
                                if (s.color[i - 1][j - 1] != black) {
                                    temp = new State(s);

                                    temp.array[i - 1][j - 1] = bKing;
                                    temp.array[i][j] = nothing;
                                    temp.color[i - 1][j - 1] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i > 0 && j < 7) {
                                if (s.color[i - 1][j + 1] != black) {
                                    temp = new State(s);

                                    temp.array[i - 1][j + 1] = bKing;
                                    temp.array[i][j] = nothing;
                                    temp.color[i - 1][j + 1] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i < 7 && j > 0) {
                                if (s.color[i + 1][j - 1] != black) {
                                    temp = new State(s);

                                    temp.array[i + 1][j - 1] = bKing;
                                    temp.array[i][j] = nothing;
                                    temp.color[i + 1][j - 1] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            if (i < 7 && j < 7) {
                                if (s.color[i + 1][j + 1] != black) {
                                    temp = new State(s);

                                    temp.array[i + 1][j + 1] = bKing;
                                    temp.array[i][j] = nothing;
                                    temp.color[i + 1][j + 1] = black;
                                    temp.color[i][j] = nothing;

                                    if (checked == true) {
                                        if (isChecked(temp, black) == false) {
                                            v.add(temp);
                                        }
                                    } else {
                                        v.add(temp);
                                    }
                                }
                            }
                            break;
                    }
                }
            }

        }
        return v;
    }

    public int eval(State s) {
        int b = 0;
        int w = 0;
        int d = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessEntity element = s.array[i][j];
                ChessEntity color = s.color[i][j];
                switch (element) {
                    case wPawn:
                        if (i < 7 && j > 0) {
                            if (s.color[i + 1][j - 1] != white) {
                                w += PawnValue;
                            }
                        }
                        if (i < 7 && j < 7) {
                            if (s.color[i + 1][j + 1] != white) {
                                w += PawnValue;
                            }
                        }

                        break;
                    case bPawn:
                        if (i > 0 && j > 0) {
                            if (s.color[i - 1][j - 1] != black) {
                                b += PawnValue;
                            }
                        }
                        if (i > 0 && j < 7) {
                            if (s.color[i - 1][j + 1] != black) {
                                b += PawnValue;
                            }
                        }

                        break;

                    case wBishop:
                    case bBishop:
                        int ii = i;
                        int jj = j;
                        while (ii > 0 && jj > 0) {
                            ii--;
                            jj--;

                            if (color == white) {
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                                w += BishopValue;
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                            }
                            if (color == black) {
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                                b += BishopValue;
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                            }
                        }

                        ii = i;
                        jj = j;
                        while (ii > 0 && jj < 7) {
                            ii--;
                            jj++;

                            if (color == white) {
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                                w += BishopValue;
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                            }
                            if (color == black) {
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                                b += BishopValue;
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                            }
                        }

                        ii = i;
                        jj = j;
                        while (ii < 7 && jj > 0) {
                            ii++;
                            jj--;

                            if (color == white) {
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                                w += BishopValue;
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                            }
                            if (color == black) {
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                                b += BishopValue;
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                            }
                        }

                        ii = i;
                        jj = j;
                        while (ii < 7 && jj < 7) {
                            ii++;
                            jj++;

                            if (color == white) {
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                                w += BishopValue;
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                            }
                            if (color == black) {
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                                b += BishopValue;
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                            }
                        }
                        break;

                    case wKnight:
                    case bKnight:
                        if (i + 2 <= 7 && j - 1 >= 0) {
                            if (color == white) {
                                if (s.color[i + 2][j - 1] != white) {
                                    w += KnightValue;
                                }
                            }
                            if (color == black) {
                                if (s.color[i + 2][j - 1] != black) {
                                    b += KnightValue;
                                }
                            }
                        }

                        if (i + 2 <= 7 && j + 1 <= 7) {
                            if (color == white) {
                                if (s.color[i + 2][j + 1] != white) {
                                    w += KnightValue;
                                }
                            }
                            if (color == black) {
                                if (s.color[i + 2][j + 1] != black) {
                                    b += KnightValue;
                                }
                            }
                        }

                        if (i - 2 >= 0 && j - 1 >= 0) {
                            if (color == white) {
                                if (s.color[i - 2][j - 1] != white) {
                                    w += KnightValue;
                                }
                            }
                            if (color == black) {
                                if (s.color[i - 2][j - 1] != black) {
                                    b += KnightValue;
                                }
                            }
                        }

                        if (i - 2 >= 0 && j + 1 <= 7) {
                            if (color == white) {
                                if (s.color[i - 2][j + 1] != white) {
                                    w += KnightValue;
                                }
                            }
                            if (color == black) {
                                if (s.color[i - 2][j + 1] != black) {
                                    b += KnightValue;
                                }
                            }
                        }

                        if (i - 1 >= 0 && j - 2 >= 0) {
                            if (color == white) {
                                if (s.color[i - 1][j - 2] != white) {
                                    w += KnightValue;
                                }
                            }
                            if (color == black) {
                                if (s.color[i - 1][j - 2] != black) {
                                    b += KnightValue;
                                }
                            }
                        }

                        if (i + 1 <= 7 && j - 2 >= 0) {
                            if (color == white) {
                                if (s.color[i + 1][j - 2] != white) {
                                    w += KnightValue;
                                }
                            }
                            if (color == black) {
                                if (s.color[i + 1][j - 2] != black) {
                                    b += KnightValue;
                                }
                            }
                        }

                        if (i - 1 >= 0 && j + 2 <= 7) {
                            if (color == white) {
                                if (s.color[i - 1][j + 2] != white) {
                                    w += KnightValue;
                                }
                            }
                            if (color == black) {
                                if (s.color[i - 1][j + 2] != black) {
                                    b += KnightValue;
                                }
                            }
                        }

                        if (i + 1 <= 7 && j + 2 <= 7) {
                            if (color == white) {
                                if (s.color[i + 1][j + 2] != white) {
                                    w += KnightValue;
                                }
                            }
                            if (color == black) {
                                if (s.color[i + 1][j + 2] != black) {
                                    b += KnightValue;
                                }
                            }
                        }

                        break;

                    case wRook:
                    case bRook:
                        ii = i;
                        jj = j;
                        while (jj > 0) {
                            jj--;

                            if (color == white) {
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                                w += RookValue;
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                            }
                            if (color == black) {
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                                b += RookValue;
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                            }
                        }
                        ii = i;
                        jj = j;
                        while (jj < 7) {
                            jj++;

                            if (color == white) {
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                                w += RookValue;
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                            }
                            if (color == black) {
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                                b += RookValue;
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                            }
                        }

                        ii = i;
                        jj = j;
                        while (ii > 0) {
                            ii--;

                            if (color == white) {
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                                w += RookValue;
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                            }
                            if (color == black) {
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                                b += RookValue;
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                            }
                        }

                        ii = i;
                        jj = j;
                        while (ii < 7) {
                            ii++;

                            if (color == white) {
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                                w += RookValue;
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                            }
                            if (color == black) {
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                                b += RookValue;
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                            }
                        }


                        break;

                    case wQueen:
                    case bQueen:
                        ii = i;
                        jj = j;
                        while (ii > 0 && jj > 0) {
                            ii--;
                            jj--;

                            if (color == white) {
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                                w += QueenValue;
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                            }
                            if (color == black) {
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                                b += QueenValue;
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                            }
                        }

                        ii = i;
                        jj = j;
                        while (ii > 0 && jj < 7) {
                            ii--;
                            jj++;

                            if (color == white) {
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                                w += QueenValue;
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                            }
                            if (color == black) {
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                                b += QueenValue;
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                            }
                        }

                        ii = i;
                        jj = j;
                        while (ii < 7 && jj > 0) {
                            ii++;
                            jj--;

                            if (color == white) {
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                                w += QueenValue;
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                            }
                            if (color == black) {
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                                b += QueenValue;
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                            }
                        }

                        ii = i;
                        jj = j;
                        while (ii < 7 && jj < 7) {
                            ii++;
                            jj++;

                            if (color == white) {
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                                w += QueenValue;
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                            }
                            if (color == black) {
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                                b += QueenValue;
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                            }
                        }

                        ii = i;
                        jj = j;
                        while (jj > 0) {
                            jj--;

                            if (color == white) {
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                                w += QueenValue;
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                            }
                            if (color == black) {
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                                b += QueenValue;
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                            }
                        }

                        ii = i;
                        jj = j;
                        while (jj < 7) {
                            jj++;

                            if (color == white) {
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                                w += QueenValue;
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                            }
                            if (color == black) {
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                                b += QueenValue;
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                            }
                        }

                        ii = i;
                        jj = j;
                        while (ii > 0) {
                            ii--;

                            if (color == white) {
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                                w += QueenValue;
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                            }
                            if (color == black) {
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                                b += QueenValue;
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                            }
                        }

                        ii = i;
                        jj = j;
                        while (ii < 7) {
                            ii++;

                            if (color == white) {
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                                w += QueenValue;
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                            }
                            if (color == black) {
                                if (s.color[ii][jj] == black) {
                                    break;
                                }
                                b += QueenValue;
                                if (s.color[ii][jj] == white) {
                                    break;
                                }
                            }
                        }


                        break;

                    case wKing:
                    case bKing:
                        if (j - 1 >= 0) {
                            if (color == white) {
                                if (s.color[i][j - 1] != white) {
                                    w += KingValue;
                                }
                            }
                            if (color == black) {
                                if (s.color[i][j - 1] != black) {
                                    b += KingValue;
                                }
                            }
                        }
                        if (j + 1 <= 7) {
                            if (color == white) {
                                if (s.color[i][j + 1] != white) {
                                    w += KingValue;
                                }
                            }
                            if (color == black) {
                                if (s.color[i][j + 1] != black) {
                                    b += KingValue;
                                }
                            }
                        }
                        if (i - 1 >= 0) {
                            if (color == white) {
                                if (s.color[i - 1][j] != white) {
                                    w += KingValue;
                                }
                            }
                            if (color == black) {
                                if (s.color[i - 1][j] != black) {
                                    b += KingValue;
                                }
                            }
                        }
                        if (i + 1 <= 7) {
                            if (color == white) {
                                if (s.color[i + 1][j] != white) {
                                    w += KingValue;
                                }
                            }
                            if (color == black) {
                                if (s.color[i + 1][j] != black) {
                                    b += KingValue;
                                }
                            }
                        }
                        if (i - 1 >= 0 && j - 1 >= 0) {
                            if (color == white) {
                                if (s.color[i - 1][j - 1] != white) {
                                    w += KingValue;
                                }
                            }
                            if (color == black) {
                                if (s.color[i - 1][j - 1] != black) {
                                    b += KingValue;
                                }
                            }
                        }
                        if (i - 1 >= 0 && j + 1 <= 7) {
                            if (color == white) {
                                if (s.color[i - 1][j + 1] != white) {
                                    w += KingValue;
                                }
                            }
                            if (color == black) {
                                if (s.color[i - 1][j + 1] != black) {
                                    b += KingValue;
                                }
                            }
                        }
                        if (i + 1 <= 7 && j - 1 >= 0) {
                            if (color == white) {
                                if (s.color[i + 1][j - 1] != white) {
                                    w += KingValue;
                                }
                            }
                            if (color == black) {
                                if (s.color[i + 1][j - 1] != black) {
                                    b += KingValue;
                                }
                            }
                        }
                        if (i + 1 <= 7 && j + 1 <= 7) {
                            if (color == white) {
                                if (s.color[i + 1][j + 1] != white) {
                                    w += KingValue;
                                }
                            }
                            if (color == black) {
                                if (s.color[i + 1][j + 1] != black) {
                                    b += KingValue;
                                }
                            }
                        }

                        break;
                }
            }
        }

        d = w - b;
        return d;
    }

    public boolean isChecked(State s, ChessEntity color) {
        int i = 0;
        int j = 0;
        boolean flag = false;
        if (color == white) {
            for (i = 0; i < 8; i++) {
                for (j = 0; j < 8; j++) {
                    if (s.array[i][j] == wKing) {
                        flag = true;
                        break;
                    }
                }
                if (flag == true) {
                    break;
                }
            }

            int ii = i;
            int jj = j;

            while (jj > 0) {
                jj--;
                if (s.color[ii][jj] != white) {
                    if (s.array[ii][jj] == bRook || s.array[ii][jj] == bQueen) {
                        return true;
                    }
                } else {
                    break;
                }
            }

            ii = i;
            jj = j;
            while (jj < 7) {
                jj++;
                if (s.color[ii][jj] != white) {
                    if (s.array[ii][jj] == bRook || s.array[ii][jj] == bQueen) {
                        return true;
                    }
                } else {
                    break;
                }
            }

            ii = i;
            jj = j;
            while (ii > 0) {
                ii--;
                if (s.color[ii][jj] != white) {
                    if (s.array[ii][jj] == bRook || s.array[ii][jj] == bQueen) {
                        return true;
                    }
                } else {
                    break;
                }
            }

            ii = i;
            jj = j;
            while (ii < 7) {
                ii++;
                if (s.color[ii][jj] != white) {
                    if (s.array[ii][jj] == bRook || s.array[ii][jj] == bQueen) {
                        return true;
                    }
                } else {
                    break;
                }
            }

            ii = i;
            jj = j;
            while (ii > 0 && jj > 0) {
                ii--;
                jj--;
                if (s.color[ii][jj] != white) {
                    if (s.array[ii][jj] == bBishop || s.array[ii][jj] == bQueen) {
                        return true;
                    }
                } else {
                    break;
                }
            }

            ii = i;
            jj = j;
            while (ii > 0 && jj < 7) {
                ii--;
                jj++;
                if (s.color[ii][jj] != white) {
                    if (s.array[ii][jj] == bBishop || s.array[ii][jj] == bQueen) {
                        return true;
                    }
                } else {
                    break;
                }
            }

            ii = i;
            jj = j;
            while (ii < 7 && jj > 0) {
                ii++;
                jj--;
                if (s.color[ii][jj] != white) {
                    if (s.array[ii][jj] == bBishop || s.array[ii][jj] == bQueen) {
                        return true;
                    }
                } else {
                    break;
                }
            }

            ii = i;
            jj = j;
            while (ii < 7 && jj < 7) {
                ii++;
                jj++;
                if (s.color[ii][jj] != white) {
                    if (s.array[ii][jj] == bBishop || s.array[ii][jj] == bQueen) {
                        return true;
                    }
                } else {
                    break;
                }
            }

            if (i + 2 <= 7 && j - 1 >= 0) {
                if (s.array[i + 2][j - 1] == bKnight) {
                    return true;
                }
            }
            if (i + 2 <= 7 && j + 1 <= 7) {
                if (s.array[i + 2][j + 1] == bKnight) {
                    return true;
                }
            }
            if (i - 2 >= 0 && j - 1 >= 0) {
                if (s.array[i - 2][j - 1] == bKnight) {
                    return true;
                }
            }
            if (i - 2 >= 0 && j + 1 <= 7) {
                if (s.array[i - 2][j + 1] == bKnight) {
                    return true;
                }
            }
            if (i - 1 >= 0 && j - 2 >= 0) {
                if (s.array[i - 1][j - 2] == bKnight) {
                    return true;
                }
            }
            if (i + 1 <= 7 && j - 2 >= 0) {
                if (s.array[i + 1][j - 2] == bKnight) {
                    return true;
                }
            }
            if (i - 1 >= 0 && j + 2 <= 7) {
                if (s.array[i - 1][j + 2] == bKnight) {
                    return true;
                }
            }
            if (i + 1 <= 7 && j + 2 <= 7) {
                if (s.array[i + 1][j + 2] == bKnight) {
                    return true;
                }
            }

            if (i + 1 <= 7 && j - 1 >= 0) {
                if (s.array[i + 1][j - 1] == bPawn) {
                    return true;
                }
            }
            if (i + 1 <= 7 && j + 1 <= 7) {
                if (s.array[i + 1][j + 1] == bPawn) {
                    return true;
                }
            }

            return false;
        } else {
            for (i = 0; i < 8; i++) {
                for (j = 0; j < 8; j++) {
                    if (s.array[i][j] == bKing) {
                        flag = true;
                        break;
                    }
                }
                if (flag == true) {
                    break;
                }
            }

            int ii = i;
            int jj = j;

            while (jj > 0) {
                jj--;
                if (s.color[ii][jj] != black) {
                    if (s.array[ii][jj] == wRook || s.array[ii][jj] == wQueen) {
                        return true;
                    }
                } else {
                    break;
                }
            }

            ii = i;
            jj = j;
            while (jj < 7) {
                jj++;
                if (s.color[ii][jj] != black) {
                    if (s.array[ii][jj] == wRook || s.array[ii][jj] == wQueen) {
                        return true;
                    }
                } else {
                    break;
                }
            }

            ii = i;
            jj = j;
            while (ii > 0) {
                ii--;
                if (s.color[ii][jj] != black) {
                    if (s.array[ii][jj] == wRook || s.array[ii][jj] == wQueen) {
                        return true;
                    }
                } else {
                    break;
                }
            }

            ii = i;
            jj = j;
            while (ii < 7) {
                ii++;
                if (s.color[ii][jj] != black) {
                    if (s.array[ii][jj] == wRook || s.array[ii][jj] == wQueen) {
                        return true;
                    }
                } else {
                    break;
                }
            }

            ii = i;
            jj = j;
            while (ii > 0 && jj > 0) {
                ii--;
                jj--;
                if (s.color[ii][jj] != black) {
                    if (s.array[ii][jj] == wBishop || s.array[ii][jj] == wQueen) {
                        return true;
                    }
                } else {
                    break;
                }
            }

            ii = i;
            jj = j;
            while (ii > 0 && jj < 7) {
                ii--;
                jj++;
                if (s.color[ii][jj] != black) {
                    if (s.array[ii][jj] == wBishop || s.array[ii][jj] == wQueen) {
                        return true;
                    }
                } else {
                    break;
                }
            }

            ii = i;
            jj = j;
            while (ii < 7 && jj > 0) {
                ii++;
                jj--;
                if (s.color[ii][jj] != black) {
                    if (s.array[ii][jj] == wBishop || s.array[ii][jj] == wQueen) {
                        return true;
                    }
                } else {
                    break;
                }
            }

            ii = i;
            jj = j;
            while (ii < 7 && jj < 7) {
                ii++;
                jj++;
                if (s.color[ii][jj] != black) {
                    if (s.array[ii][jj] == wBishop || s.array[ii][jj] == wQueen) {
                        return true;
                    }
                } else {
                    break;
                }
            }

            if (i + 2 <= 7 && j - 1 >= 0) {
                if (s.array[i + 2][j - 1] == wKnight) {
                    return true;
                }
            }
            if (i + 2 <= 7 && j + 1 <= 7) {
                if (s.array[i + 2][j + 1] == wKnight) {
                    return true;
                }
            }
            if (i - 2 >= 0 && j - 1 >= 0) {
                if (s.array[i - 2][j - 1] == wKnight) {
                    return true;
                }
            }
            if (i - 2 >= 0 && j + 1 <= 7) {
                if (s.array[i - 2][j + 1] == wKnight) {
                    return true;
                }
            }
            if (i - 1 >= 0 && j - 2 >= 0) {
                if (s.array[i - 1][j - 2] == wKnight) {
                    return true;
                }
            }
            if (i + 1 <= 7 && j - 2 >= 0) {
                if (s.array[i + 1][j - 2] == wKnight) {
                    return true;
                }
            }
            if (i - 1 >= 0 && j + 2 <= 7) {
                if (s.array[i - 1][j + 2] == wKnight) {
                    return true;
                }
            }
            if (i + 1 <= 7 && j + 2 <= 7) {
                if (s.array[i + 1][j + 2] == wKnight) {
                    return true;
                }
            }

            if (i - 1 >= 0 && j - 1 >= 0) {
                if (s.array[i - 1][j - 1] == wPawn) {
                    return true;
                }
            }
            if (i - 1 >= 0 && j + 1 <= 7) {
                if (s.array[i - 1][j + 1] == wPawn) {
                    return true;
                }
            }

            return false;
        }

    }

    public int minimax(State s, ChessEntity color, int d) {
        if (d == depth) {
            return eval(s);
        }

        Vector v = new Vector();
        State temp = new State();
        int max;
        int min;
        if (color == white) {
            v = makeMove(s, white);
            temp = new State((State) v.remove(0));
            max = minimax(temp, black, d + 1);
            if (d == 0) {
                newBoard = new State(temp);
            }
            while (v.isEmpty() == false) {
                temp = new State((State) v.remove(0));
                int m = minimax(temp, black, d + 1);
                if (m > max) {
                    max = m;
                    if (d == 0) {
                        newBoard = new State(temp);
                    }
                }
            }
            return max;
        } else {
            v = makeMove(s, black);
            temp = new State((State) v.remove(0));
            min = minimax(temp, white, d + 1);
            while (v.isEmpty() == false) {
                temp = new State((State) v.remove(0));
                int m = minimax(temp, white, d + 1);
                if (m < min) {
                    min = m;
                }
            }
            return min;
        }

    }

    public void doMove() {
        from = new Point();
        to = new Point();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Board.color[i][j] != newBoard.color[i][j]) {
                    if (newBoard.color[i][j] == nothing) {
                        from.x = j;
                        from.y = i;
                    }
                    if (newBoard.color[i][j] == white) {
                        to.x = j;
                        to.y = i;
                    }
                }
            }
        }
        Board = new State(newBoard);


    }

    public void think(Point first, Point second) {
        Board.array[second.y][second.x] = Board.array[first.y][first.x];
        Board.color[second.y][second.x] = Board.color[first.y][first.x];

        Board.array[first.y][first.x] = nothing;
        Board.color[first.y][first.x] = nothing;

        minimax(Board, white, 0);
        doMove();
    }

    private State Board = new State();
    private State newBoard = new State();

    public Point from = new Point();
    public Point to = new Point();
}
