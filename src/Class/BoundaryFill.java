package Class;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoundaryFill extends JPanel {

    static BufferedImage img;

    public BoundaryFill() {
        img = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
        paintRect();
        
        new Thread(() -> {
            long startTime = System.nanoTime();
            fill(2, 1, Color.blue, Color.black);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // Convertir a milisegundos
            System.out.println("BoundaryFill Tiempo de ejecución: " + duration + " ms");
        }).start();
    }

    public static void paintRect() {
        Graphics g = img.createGraphics();
        g.setColor(Color.black);
        g.drawRect(1, 0, 150, 150);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.add(new BoundaryFill());
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 400);
        ventana.setVisible(true);
    }

    public void fill(int x, int y, Color colornuevo, Color colorborde) {
        if (x < 0 || x >= img.getWidth() || y < 0 || y >= img.getHeight()) {
            return;
        }

        Color actual = new Color(img.getRGB(x, y), true);
        if(!actual.equals(colorborde) && !actual.equals(colornuevo)) {
            img.setRGB(x, y, colornuevo.getRGB());

            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            fill (x+1, y, colornuevo, colorborde);
            fill (x-1, y, colornuevo, colorborde);
            fill (x, y+1, colornuevo, colorborde);
            fill (x, y-1, colornuevo, colorborde);
        }
    }
}