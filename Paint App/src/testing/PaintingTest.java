package testing;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;
 

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

import testing.Stack;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
public class PaintingTest{
	private int cur = 1;
	private JFrame frame;
	
	private List<JComponent> comps = new ArrayList<JComponent>();
	private Color curColor;
	private boolean fillStroke;
	private int strokeVal;
	private JButton curBut;
	private Color back = Color.BLACK;
	 
	private int eStroke = 40;
	private Color backColor = Color.WHITE;
 
	private List<Stack> draws = new ArrayList<Stack>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 
		new PaintingTest();
		
	}
	
	//1 line
	//2. ellipse
	//3. brush
	//4. rect
	//5. currect
	//6. tri
	//7. textArea
	
	//8. erraser
	
	/**
	 * Create the application.
	 */
	public PaintingTest() {
		 
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void changeBack(JButton newButton){
		newButton.setBackground(Color.LIGHT_GRAY);
		curBut.setBackground(Color.WHITE);
		curBut = newButton;
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 604, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(new Drawing(), BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel.add(panel_3);
		
		JButton textBut = new JButton("");
		textBut.setMargin(new Insets(0,0,0,0));
		textBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cur = 7;
				changeBack(textBut);
				
			}
		});
		textBut.setBackground(Color.WHITE);
		textBut.setIcon(new ImageIcon(PaintingTest.class.getResource("/testing/19489-200.png")));
		panel_3.add(textBut);
		
		JButton btnEraser = new JButton("");
		btnEraser.setIcon(new ImageIcon(PaintingTest.class.getResource("/testing/Eraser-icon.png")));
		btnEraser.setMargin(new Insets(0, 0, 0, 0));
		btnEraser.setBackground(Color.white);
		btnEraser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cur = 8;
				changeBack(btnEraser);
				 
			}
		});
		panel_3.add(btnEraser);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);
		
		JButton rect = new JButton("");
		rect.setIcon(new ImageIcon(PaintingTest.class.getResource("/testing/software_shape_rectangle-256.png")));
		rect.setBackground(Color.WHITE);
		rect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cur = 4;
				changeBack(rect);
			}
		});
		panel_2.add(rect);
		
		JButton currect = new JButton("");
		currect.setIcon(new ImageIcon(PaintingTest.class.getResource("/testing/177531-200.png")));
		currect.setBackground(Color.WHITE);
		panel_2.add(currect);
		currect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cur = 5;
				changeBack(currect);
			}
		});
		JButton tri = new JButton("");
		tri.setIcon(new ImageIcon(PaintingTest.class.getResource("/testing/114907-magic-marker-icon-arrows-triangle-solid-up.png")));
		tri.setBackground(Color.WHITE);
		panel_2.add(tri);
		tri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cur = 6;
				changeBack(tri);
			}
		});
		tri.setMargin(new Insets(0,0,0,0));
		rect.setMargin(new Insets(0,0,0,0));
		currect.setMargin(new Insets(0,0,0,0));
		JButton line = new JButton("");
		line.setIcon(new ImageIcon(PaintingTest.class.getResource("/testing/line1600.png")));
		panel_2.add(line);
		
		line.setBackground(Color.WHITE);
		line.setMargin(new Insets(0,0,0,0));
		line.setBackground(Color.LIGHT_GRAY);
		line.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeBack(line);
				cur = 1;
			}
		});
		curBut = line;
		
		JButton ellipse = new JButton("");
		panel_2.add(ellipse);
		ellipse.setIcon(new ImageIcon(PaintingTest.class.getResource("/testing/shape_ellipse-512.png")));
		ellipse.setBackground(Color.WHITE);
		ellipse.setMargin(new Insets(0,0,0,0));
		
		JButton Brush = new JButton("");
		panel_2.add(Brush);
		Brush.setIcon(new ImageIcon(PaintingTest.class.getResource("/testing/Editing-Brush-icon.png")));
		Brush.setBackground(Color.WHITE);
		Brush.setMargin(new Insets(0,0,0,0));
		Brush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeBack(Brush);
				cur = 3;
			}
		});
		ellipse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeBack(ellipse);
				cur = 2;
			}
		});
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setMargin(new Insets(0,0,0,0));
		btnNewButton_3.setIcon(new ImageIcon(PaintingTest.class.getResource("/testing/color_wheel.png")));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color sel = JColorChooser.showDialog(null, "Choose Color", Color.BLACK);
				btnNewButton_3.setBackground(sel);
				curColor = sel;
			}
		});
		panel.add(btnNewButton_3);
		
		JRadioButton draw = new JRadioButton("Draw");
		draw.setBackground(Color.WHITE);
		panel.add(draw);
		draw.setSelected(true);
		JRadioButton fill = new JRadioButton("Fill");
		fill.setBackground(Color.WHITE);
		panel.add(fill);
		
		ButtonGroup group = new ButtonGroup();
		group.add(draw);
		group.add(fill);
		
		JComboBox stroke = new JComboBox();
		stroke.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				strokeVal = Integer.parseInt((String) stroke.getItemAt(stroke.getSelectedIndex()));
			}
		});
		stroke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				strokeVal = Integer.parseInt((String) stroke.getItemAt(stroke.getSelectedIndex()));
				
			}
		});
		stroke.setToolTipText("Select Stroke");
		stroke.setModel(new DefaultComboBoxModel(new String[] {"2", "4", "6", "8", "10", "12", "14", "16", "18", "20"}));
		panel.add(stroke);
		draw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fillStroke = false;
			}
		}); 
		fill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fillStroke = true;
			}
		});
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		 
		
		frame.setVisible(true);
	}
	private Point curP = null;
	private class Drawing extends JPanel {
		private Point start = null;
		private Point end = null;
		List<Point> points = new ArrayList<Point>();
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			Graphics2D graph = (Graphics2D)g;
			for(int i=0,j=draws.size();i<j;i++){
				Stack s = draws.get(i);
				Shape shape = s.getShape();
				
				graph.setStroke(s.getStroke());
				if(s.getType()==8){
					graph.setColor(backColor);
				}else{
					graph.setColor(s.getColor());
				}
				if(s.isFill()){
					
					graph.fill(shape);
				}else{
					graph.draw(shape);	
				}
				graph.setColor(curColor);
			
			}
			if(cur==8){
				Point cen = curP.getLocation();
				Shape cir = new Ellipse2D.Double(cen.getX()-30, cen.getY()-30, 60, 60);
				graph.setPaint(Color.yellow);
				graph.fill(cir);
				graph.setColor(curColor);
				
			}
			
			
		}
		 
		public Drawing(){
			this.setBackground(Color.WHITE);
			 
			this.setLayout(new FlowLayout());
			 
			this.addMouseListener(new MouseAdapter() {
				
				public void mousePressed(MouseEvent m){
					 
					Point p = m.getPoint();
					start = p;
					 
				}public void mouseReleased(MouseEvent m){
					Point p = m.getPoint();
					end = p;
					
					addDraws();
					
					repaint();
				}
				
			});
			
			this.addMouseMotionListener(new MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					// TODO Auto-generated method stub
					curP = e.getPoint();
					if(cur==8){
						System.out.println("moving");
						repaint();
					}
					 
				}
				
				@Override
				public void mouseDragged(MouseEvent e) {
					// TODO Auto-generated method stub
					curP = e.getPoint();
					if(cur==3){
						 
						Point p = e.getPoint();
						points.add(p);
						
						
					}
					if(cur==8){
						Shape ellipse = new Ellipse2D.Double(curP.getX()-30, curP.getY()-30, 60, 60);
						Stack s = new Stack(8, ellipse, backColor, true	, new BasicStroke(10));
						draws.add(s);
						
						repaint();
					}
					repaint();
					 
				}
			});
			
			
		}
		private void addDraws() {
			// TODO Auto-generated method stub
			if(cur == 1){
				Stack obj = new Stack(cur, new Line2D.Double(start.getX(), start.getY(), end.getX(), end.getY()),	 curColor, false, new BasicStroke(strokeVal));
				draws.add(obj);
			}else if(cur==2){
				Stack obj = new Stack(cur,makeShape(start, end), curColor,fillStroke,new BasicStroke(strokeVal));
				draws.add(obj);
			}else if(cur==3&&points.size()>0){
				Point fir = points.get(0);
				Point sec;
				for(int i=1;i<points.size();i++){
					sec = points.get(i);
					Stack obj = new Stack(cur,new Line2D.Double(fir.getX(), fir.getY(), sec.getX(),sec.getY()),curColor,false, new BasicStroke(strokeVal));
					draws.add(obj);
					fir = sec;
				}
				points.clear();
			}else if(cur==4){
				Shape s = makeShape(start,end);
				Stack obj = new Stack(cur, s, curColor, fillStroke, new BasicStroke(strokeVal));
				draws.add(obj);
			}else if(cur==5){
				Shape s = makeShape(start, end);
				Stack obj = new Stack(cur, s, curColor, fillStroke, new BasicStroke(strokeVal));
				draws.add(obj); 
			}else if(cur==6){
				if(start.getY()==end.getY()){
					return;
				}
				Shape s = makeTri(start,end);
				Stack obj = new Stack(cur, s, curColor, fillStroke, new BasicStroke(strokeVal));
				draws.add(obj);
			}
		}
		private Shape makeShape(Point start2, Point end2) {
			// TODO Auto-generated method stub
			double x = Math.min(start2.getX(), end2.getX());
			double y = Math.min(start2.getY(), end2.getY());
			double width = Math.abs(start2.getX()-end2.getX());
			double height = Math.abs(start2.getY()-end2.getY());
			if(cur==2){
			return new Ellipse2D.Double(x, y, width, height);}
			else if(cur==4){
				return new Rectangle2D.Double(x, y, width, height);			
			}
			else if(cur==5){
				return new RoundRectangle2D.Double(x, y, width, height,10,10);			
			}
			return null;
		}
		private Rectangle  makeRect(){
			int  x = (int) Math.min(start.getX(), end.getX());
			int y = (int) Math.min(start.getY(), end.getY());
			int width = (int) Math.abs(start.getX()-end.getX());
			int height = (int) Math.abs(start.getY()-end.getY());
			Rectangle rec = new Rectangle(x, y, width, height);
			return rec;
			
		}
		private Shape makeTri(Point start, Point end){
			int x3 = 0,x2 = (int)end.getX(), x1 = (int)start.getX() ; 
			int y3 = 0, y2 = (int)end.getY(), y1 = (int)start.getY() ;
			if(x2>x1&&y2<y1){
				x3 = x1+2*(x2-x1);
				y3 = y1;
			}else if(x2>x1&&y2>y1){
				x3 = x2-2*(x2-x1);
				y3 = y2;
			}else if(x1>x2&&y2>y1){
				x3 = x2+2*(x1-x2);
				y3 = y2;
			}else if(x1>x2&&y1>y2){
				x3 = x1-2*(x1-x2);
				y3 = y1;
			}
			int x[] = {x1,x2,x3};
			int y[] = {y1,y2,y3};
			Shape s = new Polygon(x,y,3);
			return s;
				
		}
		 
		 
	}
}
