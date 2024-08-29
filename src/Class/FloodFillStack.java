package Class;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class FloodFillStack {
    public void fill(BufferedImage image, int x, int y, Color targetColor, Color replacementColor) {
        int width = image.getWidth();
        int height = image.getHeight();

        if (targetColor.equals(replacementColor)) return;
        if (!new Color(image.getRGB(x, y)).equals(targetColor)) return;

        Stack<Point> stack = new Stack<>();
        stack.push(new Point(x, y));

        while (!stack.isEmpty()) {
            Point p = stack.pop();
            int px = p.x;
            int py = p.y;

            if (px < 0 || px >= width || py < 0 || py >= height) continue;
            if (!new Color(image.getRGB(px, py)).equals(targetColor)) continue;

            image.setRGB(px, py, replacementColor.getRGB());

            stack.push(new Point(px + 1, py));
            stack.push(new Point(px - 1, py));
            stack.push(new Point(px, py + 1));
            stack.push(new Point(px, py - 1));
        }
    }
}
