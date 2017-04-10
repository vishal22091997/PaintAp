package testing;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class DrawPanel2 extends JPanel {
    private static final int PREF_W = 600;
    private static final int PREF_H = 300;
    private static final Color BG = Color.WHITE;

    // create fields that can be set in your mouse listeners
    // and used in the painting methods
    private Point p1 = null;
    private Point p2 = null;

    public DrawPanel2() {
        setBackground(BG);

        // create your mouse adapter and add as mouse and mouse motion listeners 
        MyMouse myMouse = new MyMouse();
        addMouseListener(myMouse);
        addMouseMotionListener(myMouse);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // if your points have been set,.... draw them!
        if (p1 != null && p2 != null) {
            int x1 = p1.x;
            int y1 = p1.y;
            int x2 = p2.x;
            int y2 = p2.y;

            g2.drawLine(x1, y1, x2, y2);
        }
    }

    // to set the size of the GUI
    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    // my mouse adapter inner class
    private class MyMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            p1 = e.getPoint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            p2 = e.getPoint();
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            p2 = e.getPoint();
            repaint();
        }
    }

    private static void createAndShowGui() {
        DrawPanel2 mainPanel = new DrawPanel2();

        JFrame frame = new JFrame("Draw Panel 2");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}