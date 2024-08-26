/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Testing;

import Class.Circle;
import javax.swing.JFrame;

/**
 *
 * @author RYZEN
 */
public class CircleTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Algoritmo circulo de Bresenham");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.add(new Circle(200, 500, 100));
        frame.setVisible(true);
    }

}
