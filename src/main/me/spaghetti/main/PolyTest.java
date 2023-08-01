package main.me.spaghetti.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

// creates a Polygon using awt, and displays it with Swing
public class PolyTest {

    private Polygon poly;

    public PolyTest() {
        initComponents();
    }

    private void initComponents() {

        int[] xPoly = {150, 250, 325, 375, 450, 275, 100};
        int[] yPoly = {150, 100, 125, 225, 250, 375, 300};

        poly = new Polygon(xPoly, yPoly, xPoly.length);

        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLUE);
                g.drawPolygon(poly);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(500, 500);
            }
        };

        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);

                if (poly.contains(me.getPoint())) {
                    System.out.println("Clicked polygon");
                }

            }
        };

        p.addMouseListener(ma);//add listener to panel
        p.setBounds(0,0,500,500);
        Main.frame.add(p);
        p.setOpaque(false);
        Main.frame.update(Main.frame.getGraphics());

    }
}
