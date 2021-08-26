package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle{
	private int innerRadius;
	
	
	public Donut() {
		
	}

	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		setSelected(selected);
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color) {
		this(center, radius, innerRadius, selected);
		this.setColor(color);
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color, Color innerColor) {
		this(center, radius, innerRadius, selected, color);
		this.setInnerColor(innerColor);
	}
	
	public int compareTo(Object o) {
		if(o instanceof Donut) {
			Donut pomocna = (Donut) o;
			return (int) (this.area() - pomocna.area());
		}
		return 0;
	}
	
	public void draw(Graphics g) {	
		super.draw(g);
		
		
		this.fill(g);
	}
	
	public void fill(Graphics g) {
		super.fill(g);
		g.setColor(Color.white);
		g.fillOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius() * 2 - 1, this.getInnerRadius() * 2 - 1);
		g.setColor(getColor());
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius()*2, this.getInnerRadius()*2);
	}
	
	public String toString() {
		return super.toString() + ", inner radius=" + innerRadius;
	}
	
	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
 	}
	
	public boolean eqauals(Object obj) {
		if(obj instanceof Donut) {
			Donut pomocna = (Donut) obj;
			if(super.equals(obj) && this.innerRadius == pomocna.innerRadius) return true;
			else return false;
		}
		else return false;
	}
	
	public boolean contains(int x, int y) {
		if(super.contains(x,y) &&  super.getCenter().distance(x, y) >= innerRadius) return true;
		else return false;
	}
	
	public boolean contains(Point p) {
		if(super.contains(p.getX(), p.getY()) && super.getCenter().distance(p.getX(), p.getY()) >= innerRadius) return true;
		else return false;
	}
	
	public int getInnerRadius() {
		return innerRadius;
	}
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
}
