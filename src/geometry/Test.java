package geometry;

import java.util.HashMap;

public class Test {
	
	public static void main(String[] args) {
		
		Point p = new Point();
		p.setSelected(true);
		
		double distance = p.distance(1, 1);
		System.out.println(distance);
		System.out.println(p.getX());
		
		Point p1 = new Point();
		p1.setX(15);
		p1.setY(27);
		p1.setSelected(true);
		
		Rectangle r1 = new Rectangle();
		Line l1 = new Line();
		Circle c1 = new Circle();
		
		p.setX(p1.getY());
		
		l1.setStartPoint(p);
		l1.setEndPoint(p1);
		
		l1.getEndPoint().setY(23);
		
		l1.getStartPoint().setX(l1.getEndPoint().getY());
		
		l1.getEndPoint().setX((int)l1.length()-(l1.getStartPoint().getX() + l1.getStartPoint().getY()));
		
		r1.setUpperLeftPoint(p);
		r1.getUpperLeftPoint().setX(10);
		r1.getUpperLeftPoint().setY(15);
		
		c1.setCenter(r1.getUpperLeftPoint());
		c1.getCenter().setX(r1.area() - l1.getStartPoint().getY());
		
		
		Point p2 = new Point(50,100);
		Line l2 = new Line(p2, new Point(400,500));
		Rectangle r2 = new Rectangle(p1, 50, 80);
		Circle c2 = new Circle();
		
		System.out.println(p2);
		System.out.println(l2);
		System.out.println(r2);
		System.out.println(c2);
		
		String s1 = "Marko";
		String s2 = "Mirko";
		
		System.out.println(s1.equals(s2)); 
		
		System.out.println(p1.equals(p2));
		
		Donut d1 = new Donut(new Point (5,5), 5, 1);
		
		
		System.out.println(d1.contains(7,7));
		
		HashMap<String, Shape> map = new HashMap<String, Shape>();
		map.put("point", p1);
		map.put("rectangle", r1);
		map.put("Point", p2);
		
		System.out.println(map.get("point"));
		System.out.println(map.get("Point"));
		
	}

}







