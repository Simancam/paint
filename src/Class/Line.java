package Class;

import java.awt.Color;
import java.awt.Graphics;

public class Line {
    private int x1, y1, x2, y2;
    private Color color;

    public Line(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    // Algoritmo Básico
    public void trazarLineaBasico(Graphics g) {
        g.setColor(color);
        float y;
        for (int x = x1; x <= x2; x++) {
            y = y1 + (x - x1) * (y2 - y1) / (float) (x2 - x1);
            g.drawLine(x, Math.round(y), x, Math.round(y));
        }
    }

    // Algoritmo Intermedio
    public void trazarLineaIntermedio(Graphics g) {
        g.setColor(color);
        int dx = x2 - x1;
        int dy = y2 - y1;
        float m = (float) dy / dx;
        float y = y1 + 0.5f;
        for (int x = x1; x <= x2; x++) {
            g.drawLine(x, (int) Math.floor(y), x, (int) Math.floor(y));
            y += m;
        }
    }

    // Algoritmo Avanzado
    public void trazarLineaAvanzado(Graphics g) {
        g.setColor(color);
        int dx = x2 - x1;
        int dy = y2 - y1;
        int pasos = Math.max(Math.abs(dx), Math.abs(dy));
        float xIncremento = dx / (float) pasos;
        float yIncremento = dy / (float) pasos;
        float x = x1;
        float y = y1;
        for (int k = 0; k <= pasos; k++) {
            g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y));
            x += xIncremento;
            y += yIncremento;
        }
    }

    // Algoritmo de Bresenham
    public void trazarLineaBresenham(Graphics g) {
        g.setColor(color);

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;

        int err = dx - dy;

        int x = x1;
        int y = y1;

        while (true) {
            g.drawLine(x, y, x, y);

            if (x == x2 && y == y2) break;

            int e2 = 2 * err;

            if (e2 > -dy) {
                err -= dy;
                x += sx;
            }
            if (e2 < dx) {
                err += dx;
                y += sy;
            }
        }
    }
}
