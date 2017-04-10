package testing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

public class TextInScreen {
	private Font font;
	private Color color;
	private String text;
	private Point start;
	private Point end;
	public TextInScreen(Font font, Color color, String text, Point start, Point end) {
		super();
		this.font = font;
		this.color = color;
		this.text = text;
		this.start = start;
		this.end = end;
	}
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Point getStart() {
		return start;
	}
	public void setStart(Point start) {
		this.start = start;
	}
	public Point getEnd() {
		return end;
	}
	public void setEnd(Point end) {
		this.end = end;
	}

}
