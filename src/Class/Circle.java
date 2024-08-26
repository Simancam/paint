package Class;

import java.awt.*;
import javax.swing.*;

public class Circle extends JPanel {

    private int xc, yc, r;

    public Circle(int xc, int yc, int r) {
        this.xc = xc;
        this.yc = yc;
        this.r = r;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        DibujarPlano(g);
        DibujarCirculo(g, xc, yc, r);
    }

    private void DibujarPlano(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        // Ejes X y Y
        g.setColor(Color.BLACK);
        g.drawLine(0, height / 2, width, height / 2);  // Eje X
        g.drawLine(width / 2, 0, width / 2, height);   // Eje Y

        // Dibujar marcas en los ejes
        for (int i = 0; i < width; i += 50) {
            g.drawLine(i, height / 2 - 5, i, height / 2 + 5);  // Marcas en el eje X
        }
        for (int i = 0; i < height; i += 50) {
            g.drawLine(width / 2 - 5, i, width / 2 + 5, i);   // Marcas en el eje Y
        }
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
