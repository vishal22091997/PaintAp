package testing;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Painting extends JFrame{
	private int curType = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Painting();
	}

	/**
	 * Create the application.
	 */
	public Painting() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 589, 441);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		
		JPanel newPanel = new JPanel();
		
		JButton btnLine = new JButton("Line");
		 
		newPanel.add(btnLine);
		
		btnLine.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				curType = 1;
			}
		});
		 
		
		JButton btnNewButton_1 = new JButton("rectagle");
		newPanel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				curType = 2;
			}
		});
		
		JButton btnNewButton_2 = new JButton("ellipse");
		newPanel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				curType = 3;
			}
		});
		JButton circle = new JButton("Circle");
		newPanel.add(circle);
		circle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				curType = 4;
			}
		});
		this.add(newPanel, BorderLayout.NORTH);
		this.add(new DrawStuff(),BorderLayout.CENTER);
		
		this.setVisible(true);
		
	}
	
	private class DrawStuff extends JPanel{
		ArrayList<Shape> shape = new ArrayList<Shape>();
		ArrayList<Point> start = new ArrayList<Point>();
		ArrayList<Integer> type = new ArrayList<Integer>();
		public DrawStuff(){
			this.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent m) {
					// TODO Auto-generated method stub
					//1. line 2. rectangle 3. ellipse
					Point p = new Point(m.getPoint());
					Point startp = start.get((start.size()-1));
					if(curType==1){
						
						Shape line2 = new Line2D.Double(startp.getX(), startp.getY(), p.getX(),p.getY());
						shape.add(line2);
					}else if(curType==2){
						 
						Shape rect = makeRect(startp.getX(), startp.getY(), p.getX(), p.getY());
						shape.add(rect);
					}else if(curType==3){
						 
						Shape elip = makeEllipse(startp.getX(), startp.getY(), p.getX(), p.getY());
						shape.add(elip);
					}else if(curType == 4){
						Shape circle = makeCircle(startp.getX(),startp.getY(),p.getX(),p.getY());
						shape.add(circle);
					}
					type.add(curType);
					repaint();
				}
				
				private Ellipse2D makeCircle(double x1, double y1, double x2, double y2) {
					// TODO Auto-generated method stub
					double x = Math.min(x1, x2);
					double y = Math.min(y1, y2);
					double width = Math.max(x1-x2, x2);
				
					return new Ellipse2D.Double(x1,x2,y1,y2);
				}

				private Ellipse2D makeEllipse(double x1, double y1, double x2, double y2) {
					// TODO Auto-generated method stub
					double x = Math.min(x1, x2);
					double y = Math.min(y1, y2);
					double width = Math.abs(x1-x2);
					double height = Math.abs(y1-y2);
					return new Ellipse2D.Double(x,y,width,height);
				}

				private Rectangle2D makeRect(double x1, double y1, double x2, double y2) {
					// TODO Auto-generated method stub
					double x = Math.min(x1, x2);
					double y = Math.min(y1, y2);
					double width = Math.abs(x1-x2);
					double height = Math.abs(y1-y2);
					
					
					return new Rectangle2D.Double(x,y,width,height);
				}

				@Override
				public void mousePressed(MouseEvent m) {
					// TODO Auto-generated method stub
					Point p = new Point(m.getX(),m.getY());
					start.add(p);
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			
		}
		
		public void paint(Graphics g){
			Graphics2D graph2 = (Graphics2D)g;
			System.out.println("Reached");
			graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);;
			 
			 
			graph2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0F));
			for(int i=0;i<shape.size();i++){
				System.out.println(type.get(i));
				graph2.setPaint(Color.GREEN);
				if(type.get(i)==1){
					graph2.draw(shape.get(i));
				}else{
					graph2.fill(shape.get(i));
				}
			}
		}
	}
}
