package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {
	private int x;
	private int y;
	
	public Point() {
	
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, boolean selected) {
		this(x,y);
		this.setSelected(selected);
	}
	
	public Point(int x, int y, boolean selected, Color color) {
		this(x,y,selected);
		this.setColor(color);
	}
	
	public void moveBy(int byX, int byY) {
		this.x += byX;
		this.y += byY;
	}

	public int compareTo(Object o) {
		if(o instanceof Point) {
			Point p = (Point) o;
			Point pocetak = new Point(0,0);
			return (int) ((this.distance(pocetak.getX(), pocetak.getY())) - (p.distance(pocetak.getX(), pocetak.getY())));
		}
		else return 0;
	}
	
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(this.x - 2, this.y, this.x + 2, this.y);
		g.drawLine(this.x, this.y - 2, this.x, this.y + 2);
	}
	
	public double distance(int x2, int y2) {
		double dx = getX() - x2;
		double dy = getY() - y2;
		double d = Math.sqrt(dy*dy+dx*dx);
		return d;
	}
	
	public boolean contains(int x, int y) {
		if(this.distance(x, y) <= 3) return true;
		else return false;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	} 
	
	public String toString() {
		return "(" + x + "," + y +")";
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point pomocna = (Point) obj;
			if(this.x == pomocna.x && this.y == pomocna.y) return true;
			else return false;
		}
		else return false;
	}
}
