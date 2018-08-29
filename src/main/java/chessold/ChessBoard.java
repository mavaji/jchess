package chessold;

import java.awt.*;

/**
 * @author Vahid Mavaji
 * @version 1.1
 */
public class ChessBoard extends Frame {

    public Point realToIndex(Point p) {
        return new Point((p.x - Left) / (L + 2 * d), (p.y - Top) / (L + 2 * d));
    }

    public Point indexToReal(Point p) {
        return new Point(p.x * (2 * d + L) + Left, p.y * (2 * d + L) + Top);
    }

    public ChessBoard() {
        this.setTitle("Chess");
        this.setLayout(null);
        this.setBackground(Color.gray);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                places[i][j] = new Place();
            }
        }

        init();

    }

    public void init() {
        for (int i = 0; i < 8; i++) {
            if (i == 0) {
                places[i][0].image = ROOKO;
                places[i][0].name = "ROOKO";

                places[i][1].image = KNIGHTO;
                places[i][1].name = "KNIGHTO";

                places[i][2].image = BISHOPO;
                places[i][2].name = "BISHOPO";

                places[i][3].image = KINGO;
                places[i][3].name = "KINGO";

                places[i][4].image = QUEENO;
                places[i][4].name = "QUEENO";

                places[i][5].image = BISHOPO;
                places[i][5].name = "BISHOPO";

                places[i][6].image = KNIGHTO;
                places[i][6].name = "KNIGHTO";

                places[i][7].image = ROOKO;
                places[i][7].name = "ROOKO";
            } else if (i == 7) {
                places[i][0].image = ROOK;
                places[i][0].name = "Rook";

                places[i][1].image = KNIGHT;
                places[i][1].name = "KNIGHT";

                places[i][2].image = BISHOP;
                places[i][2].name = "BISHOP";

                places[i][3].image = KING;
                places[i][3].name = "KING";

                places[i][4].image = QUEEN;
                places[i][4].name = "QUEEN";

                places[i][5].image = BISHOP;
                places[i][5].name = "BISHOP";

                places[i][6].image = KNIGHT;
                places[i][6].name = "KNIGHT";

                places[i][7].image = ROOK;
                places[i][7].name = "Rook";
            } else if (i == 1) {
                for (int j = 0; j < 8; j++) {
                    places[i][j].image = PAWNO;
                    places[i][j].name = "PAWNO";
                }
            } else if (i == 6) {
                for (int j = 0; j < 8; j++) {
                    places[i][j].image = PAWN;
                    places[i][j].name = "PAWN";
                }
            } else {
                for (int j = 0; j < 8; j++) {
                    places[i][j].image = null;
                    places[i][j].name = null;
                }
            }
        }

        whiteL = new Label("White Moves");
        whiteL.setForeground(Color.white);
        whiteL.setBounds(460, Top - 5 * d, 80, 20);
        this.add(whiteL);
        whiteLog = new TextArea(10, 10);
        whiteLog.resize(100, 100);
        whiteLog.setBounds(450, Top - d, 100, 150);
        whiteLog.setEditable(false);
        this.add(whiteLog);

        blackL = new Label("Black Moves");
        blackL.setForeground(Color.black);
        blackL.setBounds(460, Top + 4 * (L + 2 * d) - 4 * d, 80, 20);
        this.add(blackL);
        blackLog = new TextArea(10, 10);
        blackLog.resize(100, 100);
        blackLog.setBounds(450, Top + 4 * (L + 2 * d), 100, 150);
        blackLog.setEditable(false);
        this.add(blackLog);

        player.think(new Point(0, 0), new Point(0, 0));
        move(player.from, player.to);
        whiteLog.append(String.valueOf((char) (player.from.x + 65)) + Integer.toString(8 - player.from.y) + "  "
                + String.valueOf((char) (player.to.x + 65)) + Integer.toString(8 - player.to.y) + "\n");

    }

    private Image dbImg;
    private Graphics dbg;

    public void update(Graphics g) {
        if (dbImg == null) {
            dbImg = createImage(this.getWidth(), this.getHeight());
            dbg = dbImg.getGraphics();
        }

        dbg.setColor(getBackground());
        dbg.fillRect(0, 0, getWidth(), getHeight());

        dbg.setColor(getForeground());
        paint(dbg);

        g.drawImage(dbImg, 0, 0, this);

    }

    public void paint(Graphics g) {
        g.setColor(WHITE);
        for (int y = 0; y < 8; y++) {
            if (g.getColor().equals(BLACK)) {
                g.setColor(WHITE);
            } else {
                g.setColor(BLACK);
            }
            for (int x = 0; x < 8; x++) {
                if (g.getColor().equals(BLACK)) {
                    g.setColor(WHITE);
                } else {
                    g.setColor(BLACK);
                }

                if (x == 0) {
                    g.drawString(new Integer(8 - y).toString(), Left - 4 * d, y * (2 * d + L) + Top + d + L / 2);
                }
                if (x == 7) {
                    g.drawString(new Integer(8 - y).toString(), Left + 8 * (L + 2 * d), y * (2 * d + L) + Top + d + L / 2);
                }

                if (y == 7) {
                    g.drawString(new Character((char) (x + 65)).toString(), x * (2 * d + L) - d + Left + L / 2, 8 * (2 * d + L) + Top + 2 * d);
                }
                if (y == 0) {
                    g.drawString(new Character((char) (x + 65)).toString(), x * (2 * d + L) - d + Left + L / 2, Top - 2 * d);
                }

                g.fillRect(x * (2 * d + L) + Left - d,
                        y * (2 * d + L) + Top - d,
                        L + 2 * d,
                        L + 2 * d);

                if (places[y][x].image != null) {
                    g.drawImage(places[y][x].image,
                            x * (2 * d + L) + Left,
                            y * (2 * d + L) + Top,
                            L, L, this);
                }
            }
        }
        g.setColor(Color.red);
        g.drawRect(Indicator.x, Indicator.y, L, L);

        if (Selected != null) {
            g.setColor(Color.green);
            g.drawRect(Selected.x, Selected.y, L, L);
        }

    }

    public boolean handleEvent(Event evt) {
        if (evt.id == Event.WINDOW_DESTROY) {
            System.exit(0);
        }
        return super.handleEvent(evt);
    }

    public boolean keyDown(Event evt, int i) {
        if (evt.id == Event.KEY_ACTION && i == Event.LEFT) {
            if (Indicator.x > Left) {
                Indicator.x -= L + 2 * d;
            }
            repaint();
        } else if (i == Event.RIGHT) {
            if (Indicator.x < (7 * (L + 2 * d) + Left)) {
                Indicator.x += L + 2 * d;
            }
            repaint();
        } else if (i == Event.UP) {
            if (Indicator.y > Top) {
                Indicator.y -= L + 2 * d;
            }
            repaint();
        } else if (i == Event.DOWN) {
            if (Indicator.y < (7 * (L + 2 * d) + Top)) {
                Indicator.y += L + 2 * d;
            }
            repaint();
        }

        if (evt.id == Event.KEY_PRESS && i == Event.ENTER) {
            processEnter();

        }

        return super.keyDown(evt, i);
    }

    public void processEnter() {
        if (Selected == null) {
            Selected = new Point();
            Selected.x = Indicator.x;
            Selected.y = Indicator.y;
        } else {
            Point first = realToIndex(Selected);
            Point second = realToIndex(Indicator);

            if (move(first, second)) {
                blackLog.append(String.valueOf((char) (first.x + 65)) + Integer.toString(8 - first.y) + "  "
                        + String.valueOf((char) (second.x + 65)) + Integer.toString(8 - second.y) + "\n");

                player.think(first, second);
                move(player.from, player.to);

                whiteLog.append(String.valueOf((char) (player.from.x + 65)) + Integer.toString(8 - player.from.y) + "  "
                        + String.valueOf((char) (player.to.x + 65)) + Integer.toString(8 - player.to.y) + "\n");

            }
        }

    }

    public boolean move(Point from, Point to) {

        int row = from.y;
        int col = from.x;
        if (row == to.y && col == to.x) {
            Selected = null;
            repaint();
            return false;
        }

        Image image = places[row][col].image;
        String name = places[row][col].name;

        places[row][col].image = null;
        places[row][col].name = null;

        row = to.y;
        col = to.x;

        places[row][col].image = image;
        places[row][col].name = name;

        Selected = null;


        repaint();
        return true;
    }

    public static void main(String[] args) {
        ChessBoard chess1 = new ChessBoard();
        chess1.setBounds(200, 100, 600, 500);
        chess1.setResizable(false);
        chess1.show();
    }

    private Color BLACK = Color.black;
    private Color WHITE = Color.lightGray;

    private int L = 32;
    private int d = 5;
    private int Top = 80;
    private int Left = 60;

    private Point Indicator = indexToReal(new Point(7, 7));
    private Point Selected = null;


    private String path = "/icons/";

    private Image PAWN = Toolkit.getDefaultToolkit().getImage(getClass().getResource(path + "PAWN.GIF"));
    private Image PAWNO = Toolkit.getDefaultToolkit().getImage(getClass().getResource(path + "PAWNO.GIF"));
    private Image ROOK = Toolkit.getDefaultToolkit().getImage(getClass().getResource(path + "ROOK.GIF"));
    private Image ROOKO = Toolkit.getDefaultToolkit().getImage(getClass().getResource(path + "ROOKO.GIF"));
    private Image KNIGHT = Toolkit.getDefaultToolkit().getImage(getClass().getResource(path + "KNIGHT.GIF"));
    private Image KNIGHTO = Toolkit.getDefaultToolkit().getImage(getClass().getResource(path + "KNIGHTO.GIF"));
    private Image BISHOP = Toolkit.getDefaultToolkit().getImage(getClass().getResource(path + "BISHOP.GIF"));
    private Image BISHOPO = Toolkit.getDefaultToolkit().getImage(getClass().getResource(path + "BISHOPO.GIF"));
    private Image QUEEN = Toolkit.getDefaultToolkit().getImage(getClass().getResource(path + "QUEEN.GIF"));
    private Image QUEENO = Toolkit.getDefaultToolkit().getImage(getClass().getResource(path + "QUEENO.GIF"));
    private Image KING = Toolkit.getDefaultToolkit().getImage(getClass().getResource(path + "KING.GIF"));
    private Image KINGO = Toolkit.getDefaultToolkit().getImage(getClass().getResource(path + "KINGO.GIF"));

    private Label whiteL = new Label();
    private Label blackL = new Label();
    private TextArea whiteLog = new TextArea();
    private TextArea blackLog = new TextArea();

    private Place[][] places = new Place[8][8];

    private ChessPlayer player = new ChessPlayer();
}
