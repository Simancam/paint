package Class;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FloodFill extends JPanel {

    static BufferedImage img;

    public FloodFill() {
        img = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
        paintRect();
        
        new Thread(() -> {
            long startTime = System.nanoTime();
            fill(2, 1, Color.red, new Color(img.getRGB(11, 11), true));
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // Convertir a milisegundos
            System.out.println("FloodFill Tiempo de ejecución: " + duration + " ms");
        }).start();
    }

    public static void paintRect() {
        Graphics g = img.createGraphics();
        g.setColor(Color.black);
        g.drawRect(1, 0, 50, 50);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.add(new FloodFill());
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 400);
        ventana.setVisible(true);
    }

    public void fill(int x, int y, Color colornuevo, Color coloranterior) {
        if (x < 0 || x >= img.getWidth() || y < 0 || y >= img.getHeight()) {
            return;
        }

        repaint();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (new Color(img.getRGB(x, y), true).equals(coloranterior)) {
            img.setRGB(x, y, colornuevo.getRGB());
            fill(x+1, y, colornuevo, coloranterior);
            fill(x-1, y, colornuevo, coloranterior);
            fill(x, y+1, colornuevo, coloranterior);
            fill(x, y-1, colornuevo, coloranterior);
        }
    }
}