package Testing;

import Class.Line;
import Class.LineType;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class LineTest extends JPanel {

    private Line basicLine, intermediateLine, advancedLine, bresenhamLine;

    public LineTest() {
        basicLine = getLine(Color.RED, LineType.basica);

        intermediateLine = getLine(Color.GREEN, LineType.intermedia);

        advancedLine = getLine(Color.BLUE, LineType.avanzada);

        bresenhamLine = getLine(Color.MAGENTA, LineType.bresenham);
    }

    private Line getLine(Color color, LineType lineType) {
        try {
            int x1, x2, y1, y2;

            x1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el x del primer punto de la linea " + lineType));

            y1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el y del primer punto de la linea " + lineType));

            x2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el x del segundo punto de la linea " + lineType));

            y2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el y del segundo punto de la linea " + lineType));

            return new Line(x1, y1, x2, y2, color);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe ser un numero valido");
            return getLine(color, lineType);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar el plano cartesiano
        drawCartesianPlane(g);

        // Dibujar las líneas usando los diferentes algoritmos
        basicLine.trazarLineaBasico(g);
        intermediateLine.trazarLineaIntermedio(g);
        advancedLine.trazarLineaAvanzado(g);
        bresenhamLine.trazarLineaBresenham(g);
    }

    private void drawCartesianPlane(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        // Mover el origen (0,0) al centro del JPanel
        g.translate(width / 2, height / 2);

        // Dibujar los ejes X e Y
        g.setColor(Color.BLACK);
        g.drawLine(-width / 2, 0, width / 2, 0);  // Eje X
        g.drawLine(0, -height / 2, 0, height / 2); // Eje Y

        // Dibujar marcas en los ejes
        for (int i = -width / 2; i <= width / 2; i += 20) {
            g.drawLine(i, -5, i, 5); // Marcas en el eje X
        }
        for (int i = -height / 2; i <= height / 2; i += 20) {
            g.drawLine(-5, i, 5, i); // Marcas en el eje Y
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Plano Cartesiano con Líneas");
        LineTest panel = new LineTest();
        frame.add(panel);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        SwingUtilities.invokeLater(() -> {
            long startTime, endTime;

            // Medir TrazarLineaBasico
            startTime = System.nanoTime();
            panel.basicLine.trazarLineaBasico(panel.getGraphics());
            endTime = System.nanoTime();
            System.out.println("TrazarLineaBasico: " + (endTime - startTime) + " nanosegundos.");

            // Medir TrazarLineaIntermedio
            startTime = System.nanoTime();
            panel.intermediateLine.trazarLineaIntermedio(panel.getGraphics());
            endTime = System.nanoTime();
            System.out.println("TrazarLineaIntermedio: " + (endTime - startTime) + " nanosegundos.");

            // Medir TrazarLineaAvanzado
            startTime = System.nanoTime();
            panel.advancedLine.trazarLineaAvanzado(panel.getGraphics());
            endTime = System.nanoTime();
            System.out.println("TrazarLineaAvanzado: " + (endTime - startTime) + " nanosegundos.");

            // Medir TrazarLineaBresenham
            startTime = System.nanoTime();
            panel.bresenhamLine.trazarLineaBresenham(panel.getGraphics());
            endTime = System.nanoTime();
            System.out.println("TrazarLineaBresenham: " + (endTime - startTime) + " nanosegundos.");

            panel.repaint();
        });
    }
}
