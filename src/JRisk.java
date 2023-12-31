import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JRisk {

    private Polygon poly;

    public JRisk() {
        initComponents();
    }

    private void initComponents() {

        JFrame mainMap = new JFrame();
        mainMap.setResizable(false);

        mainMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
                return new Dimension(800, 600);
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
        mainMap.add(p);

        mainMap.setSize(800, 800);
        //mainMap.pack();
        mainMap.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JRisk::new);
    }
}