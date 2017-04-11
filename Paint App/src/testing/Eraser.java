package testing;

import java.awt.Color;
import java.awt.Point;

public class Eraser {
	private Color color;
	private Point center;
	private int rad;
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Point getCorner() {
		return center;
	}
	public void setCorner(Point corner) {
		this.center = corner;
	}
	public int getRad() {
		return rad;
	}
	public void setRad(int rad) {
		this.rad = rad;
	}
	public Eraser(Color color, Point center, int rad) {
		super();
		this.color = color;
		this.center = center;
		this.rad = rad;
	}

}
