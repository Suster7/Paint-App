package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends SurfaceShape{

	private int width;
	private int height;
	private Point upperLeftPoint;
	
	public Rectangle() {
		
	}

	public Rectangle (Point upperLeftPoint, int width, int height) {
		this.setUpperLeftPoint(upperLeftPoint);
		this.setWidth(width);
		this.setHeight(height);
	}
	
	public Rectangle (Point upperLeftPoint, int width, int height, boolean selected) {
		this(upperLeftPoint, width, height);
		setSelected(selected);
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected, Color color) {
		this(upperLeftPoint, width, height, selected);
		this.setColor(color);
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected, Color color, Color innerColor) {
		this(upperLeftPoint, width, height, selected, color);
		setInnerColor(innerColor);
	}
	
	public void moveBy(int byX, int byY) {	
		upperLeftPoint.moveBy(byX, byY);
	}
	
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			return this.area() - ((Rectangle)o).area();
		}
		return 0;
	}
	
	public void drawSelected(Graphics g) {
		g.setColor(getColor());
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
	}
	
	public void draw(Graphics g) {	
		this.fill(g);
		g.setColor(getColor());
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
	}
	
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
	}
	
	public boolean contains(int x, int y) {
		 if(this.upperLeftPoint.getX() <= x && (this.upperLeftPoint.getX() + width) >= x && this.upperLeftPoint.getY() <= y && (this.upperLeftPoint.getY() + height) >= y) return true;
		 else return false;
	}
	
	public boolean contains(Point p) {
		 if(this.upperLeftPoint.getX() <= p.getX() && (this.upperLeftPoint.getX() + width) >= p.getX() && this.upperLeftPoint.getY() <= p.getY() && (this.upperLeftPoint.getY() + height) >= p.getY()) return true;
		 else return false;
	}
	
	public int area() {
		return width * height;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}
	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	
	
	public String toString() {
		return "Upper Left Point=" + upperLeftPoint +", width=" + width +", height=" + height;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle pomocna = (Rectangle) obj;
			if(this.upperLeftPoint.equals(pomocna.upperLeftPoint) && this.width == pomocna.width && this.height == pomocna.height) return true;
			else return false;
		}
		else return false;
	}

	
}








