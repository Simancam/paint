package Class;

import java.awt.Color;
import java.awt.Graphics;

public class Circle {

    private int xc, yc, r;

    public Circle(int xc, int yc, int r) {
        this.xc = xc;
        this.yc = yc;
        this.r = r;
    }

    public void draw(Graphics g) {
        DibujarCirculo(g, xc, yc, r);
    }

    private void DibujarCirculo(Graphics g, int xc, int yc, int r) {
        int x = 0;
        int y = r;
        int d = 3 - 2 * r;

        dibujarPuntosSimetricos(g, xc, yc, x, y);
        while (y >= x) {
            x++;

            if (d > 0) {
                y--;
                d = d + 4 * (x - y) + 10;
            } else {
                d = d + 4 * x + 6;
            }

            dibujarPuntosSimetricos(g, xc, yc, x, y);
        }
    }

    private void dibujarPuntosSimetricos(Graphics g, int xc, int yc, int x, int y) {
        g.setColor(Color.black);
        g.drawLine(xc + x, yc + y, xc + x, yc + y);
        g.drawLine(xc - x, yc + y, xc - x, yc + y);
        g.drawLine(xc + x, yc - y, xc + x, yc - y);
        g.drawLine(xc - x, yc - y, xc - x, yc - y);
        g.drawLine(xc + y, yc + x, xc + y, yc + x);
        g.drawLine(xc - y, yc + x, xc - y, yc + x);
        g.drawLine(xc + y, yc - x, xc + y, yc - x);
        g.drawLine(xc - y, yc - x, xc - y, yc - x);
    }
}
