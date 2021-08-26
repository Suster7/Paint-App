package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends SurfaceShape {
	
	private Point center;
	private int radius;
	
	public Circle() {
		
	}

	public Circle(Point center, int radius) {
		this.setCenter(center);
		try {
			this.setRadius(radius);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center,radius);
		setSelected(selected);
	}
	
	public Circle(Point center, int radius, boolean selected, Color color) {
		this(center, radius, selected);
		this.setColor(color);
	}
	
	public Circle(Point center, int radius, boolean selected, Color color, Color innerColor) {
		this(center, radius, selected, color);
		setInnerColor(innerColor);
	}
	
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);
	}
	
	public int compareTo(Object o) {
		if(o instanceof Circle) {
			return this.radius - ((Circle) o).radius;
		}
		return 0;
	}
	
	public void draw(Graphics g) {
		this.fill(g);
		g.setColor(getColor());
		g.drawOval(center.getX() - radius, center.getY() - radius, radius*2, radius*2);
	}
	
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillOval(center.getX() - radius , center.getY() - radius , radius * 2, radius * 2);
	}
	
	public boolean contains(int x, int y) {
		if(this.center.distance(x, y) <= radius ) return true;
		else return false;
	}
	
	public boolean contains(Point p) {
		if(this.center.distance(p.getX(), p.getY()) <= radius ) return true;
		else return false;
	}
	
	public double area() {
		return radius * radius * Math.PI;
	}
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public String toString() {
		return "Center=" + center + ", radius=" + radius;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle pomocna = (Circle) obj;
			if(this.center.equals(pomocna.center) && this.radius == pomocna.radius) return true;
			else return false;
		}
		else {
			return false;
		}
	}
}