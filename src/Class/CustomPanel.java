package Class;

import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class CustomPanel extends JPanel {
    private BufferedImage image;

    public CustomPanel(BufferedImage image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        repaint(); // Asegura que el panel se repinte cuando se actualice la imagen
    }
}
