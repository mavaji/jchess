package chess.common;

import java.awt.*;

/**
 * Date: Sep 17, 2004
 * Time: 11:59:11 AM
 *
 * @author Vahid Mavaji
 * @version 1.1
 */
public class Movement {
    public static Point A1 = new Point(7, 0);
    public static Point A2 = new Point(6, 0);
    public static Point A3 = new Point(5, 0);
    public static Point A4 = new Point(4, 0);
    public static Point A5 = new Point(3, 0);
    public static Point A6 = new Point(2, 0);
    public static Point A7 = new Point(1, 0);
    public static Point A8 = new Point(0, 0);

    public static Point B1 = new Point(7, 1);
    public static Point B2 = new Point(6, 1);
    public static Point B3 = new Point(5, 1);
    public static Point B4 = new Point(4, 1);
    public static Point B5 = new Point(3, 1);
    public static Point B6 = new Point(2, 1);
    public static Point B7 = new Point(1, 1);
    public static Point B8 = new Point(0, 1);

    public static Point C1 = new Point(7, 2);
    public static Point C2 = new Point(6, 2);
    public static Point C3 = new Point(5, 2);
    public static Point C4 = new Point(4, 2);
    public static Point C5 = new Point(3, 2);
    public static Point C6 = new Point(2, 2);
    public static Point C7 = new Point(1, 2);
    public static Point C8 = new Point(0, 2);

    public static Point D1 = new Point(7, 3);
    public static Point D2 = new Point(6, 3);
    public static Point D3 = new Point(5, 3);
    public static Point D4 = new Point(4, 3);
    public static Point D5 = new Point(3, 3);
    public static Point D6 = new Point(2, 3);
    public static Point D7 = new Point(1, 3);
    public static Point D8 = new Point(0, 3);

    public static Point E1 = new Point(7, 4);
    public static Point E2 = new Point(6, 4);
    public static Point E3 = new Point(5, 4);
    public static Point E4 = new Point(4, 4);
    public static Point E5 = new Point(3, 4);
    public static Point E6 = new Point(2, 4);
    public static Point E7 = new Point(1, 4);
    public static Point E8 = new Point(0, 4);

    public static Point F1 = new Point(7, 5);
    public static Point F2 = new Point(6, 5);
    public static Point F3 = new Point(5, 5);
    public static Point F4 = new Point(4, 5);
    public static Point F5 = new Point(3, 5);
    public static Point F6 = new Point(2, 5);
    public static Point F7 = new Point(1, 5);
    public static Point F8 = new Point(0, 5);

    public static Point G1 = new Point(7, 6);
    public static Point G2 = new Point(6, 6);
    public static Point G3 = new Point(5, 6);
    public static Point G4 = new Point(4, 6);
    public static Point G5 = new Point(3, 6);
    public static Point G6 = new Point(2, 6);
    public static Point G7 = new Point(1, 6);
    public static Point G8 = new Point(0, 6);

    public static Point H1 = new Point(7, 7);
    public static Point H2 = new Point(6, 7);
    public static Point H3 = new Point(5, 7);
    public static Point H4 = new Point(4, 7);
    public static Point H5 = new Point(3, 7);
    public static Point H6 = new Point(2, 7);
    public static Point H7 = new Point(1, 7);
    public static Point H8 = new Point(0, 7);

    public final Point from;
    public final Point to;
    public final Color who;

    public Movement(Point from, Point to, Color who) {
        this.from = from;
        this.to = to;
        this.who = who;
    }
}
