package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
	
	private Point startPoint;
	private Point endPoint;
	
	public Line() {
	
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.setStartPoint(startPoint);
		this.setEndPoint(endPoint);
	}

	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.setSelected(selected);
	}
	
	
	public Line(Point startPoint, Point endPoint, boolean selected, Color color) {
		this(startPoint, endPoint, selected);
		this.setColor(color);
	}
	
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);
	}
	
	public int compareTo(Object o) {
		if(o instanceof Line) {
			return (int) (this.length() - ((Line) o).length());
		}
		return 0;
	}
	
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(this.startPoint.getX(), this.startPoint.getY(), this.endPoint.getX(), this.endPoint.getY());
	}
	
	public boolean contains(int x, int y) {
		if((startPoint.distance(x, y) + endPoint.distance(x, y)) - length() <= 0.05) {
			return true;
		}
		else return false;
	}
	
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	public String toString() {
		return startPoint.toString() + "-->" + endPoint.toString();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line pomocna = (Line) obj;
			if(this.startPoint.equals(pomocna.startPoint) && this.endPoint.equals(pomocna.endPoint)) return true;
			else return false;
		}
		else return false;
	}
	
}
