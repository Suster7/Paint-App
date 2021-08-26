package geometry;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel{

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.white );
	
	}
	
	public void paint(Graphics g) {
		Point p = new Point(50,50,false,Color.BLUE);
		//p.draw(g);
		
		Line l = new Line(new Point(70,50), new Point(70,140), false, Color.RED);
		//l.draw(g);
		
		Circle c = new Circle(new Point(150,200), 50, false, Color.GRAY, Color.RED);
		//c.draw(g);
		
		Rectangle r = new Rectangle(new Point(230,100), 60, 120, false, Color.RED, Color.MAGENTA);
		//r.draw(g);
		
		Donut d = new Donut(new Point(300, 330), 70, 30, false, Color.BLACK, Color.YELLOW);
		//d.draw(g);
		
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(p);
		shapes.add(l);
		shapes.add(c);
		shapes.add(r);
		shapes.add(d);
		
		Iterator<Shape> it = shapes.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next().isSelected());
		}
		
		
		shapes.get(2).draw(g);
		shapes.get(shapes.size() - 1).draw(g);
		shapes.get(3).draw(g);
		shapes.add(3, new Line(new Point(450,200), new Point(600,200), false, Color.black));
		shapes.get(3).draw(g);
		shapes.remove(1);
		
		for (Shape shape : shapes) {
			if(shape instanceof SurfaceShape) shape.draw(g);
			
		}
	}
}











