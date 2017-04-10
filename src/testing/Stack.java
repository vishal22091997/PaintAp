package testing;

import java.awt.Color;
import java.awt.Shape;
import java.awt.Stroke;

public class Stack{
	private int type;
	private Shape shape;
	private Color color;
	private boolean fill;//true for fill and false for draw
	private Stroke stroke;
	public Stack(int type, Shape shape, Color color, boolean fill, Stroke stroke) {
		 
		this.type = type;
		this.shape = shape;
		this.color = color;
		this.fill = fill;
		this.stroke = stroke;
	}
	public Stroke getStroke() {
		return stroke;
	}
	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Shape getShape() {
		return shape;
	}
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public boolean isFill() {
		return fill;
	}
	public void setFill(boolean fill) {
		this.fill = fill;
	}
	
}
