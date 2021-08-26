package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Drawing;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import geometry.SurfaceShape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public final class PnlDrawing extends JPanel {

	public ArrayList<Shape> shapeList = new ArrayList<Shape>();
	
	private int click = 0;
	private Point sPoint;
	private int i;
	private Point oldPoint;
	private Line oldLine;
	private Rectangle oldRectangle;
	private Circle oldCircle;
	private Donut oldDonut;
	private Rectangle selection;
	private Point selectPoint;
	private Line selectLine;
	private Rectangle selectRectangle;
	private Circle selectCircle;
	private Donut selectDonut;
	private Color transparentColor;
	
	/**
	 * Create the panel.
	 */
	public PnlDrawing(FrmDrawing frame) {
		setVisible(true);
		setBackground(Color.white );
		
		transparentColor = new Color(0f,0f,1f, 0.1f);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			for(i = shapeList.size() - 1; i>-1; i--) {
				if(shapeList.get(i).contains(e.getX(), e.getY())) {
					for (Shape shape : shapeList) {
						if(shape instanceof Shape) shape.setSelected(false);
					}
					shapeList.get(i).setSelected(true);
					repaint();
					break;
				}

				}
				if(i == -1) {
					for (Shape shape : shapeList) {
						if(shape instanceof Shape) shape.setSelected(false);
					}
					repaint();
					
					if(frame.tglbtnPoint.isSelected()) {
						Point point = new Point(e.getX(), e.getY(), false, frame.color);
						shapeList.add(point);
						repaint();
						
						
		
					}else if(frame.tglbtnLine.isSelected()){
						if(click == 0) {
							sPoint = new Point(e.getX(), e.getY());
							click = 1;
						}else {
							Line line = new Line(sPoint, new Point(e.getX(), e.getY()), false, frame.color);
							shapeList.add(line);
							click = 0;
							repaint();
						}
				
						
							
					}else if(frame.tglbtnRectangle.isSelected()) {
						DlgRectangle dlgRectangle = new DlgRectangle();
						dlgRectangle.getFtxtfXcoord().setEnabled(false);
						dlgRectangle.getFtxtfYcoord().setEnabled(false);
						dlgRectangle.getFtxtfXcoord().setText(Integer.toString(e.getX()));
						dlgRectangle.getFtxtfYcoord().setText(Integer.toString(e.getY()));
						dlgRectangle.setVisible(true);
						if(dlgRectangle.flag == true) {
							Rectangle rectangle = new Rectangle(new Point(Integer.parseInt(dlgRectangle.getFtxtfXcoord().getText()), 
									Integer.parseInt(dlgRectangle.getFtxtfYcoord().getText())),
									Integer.parseInt(dlgRectangle.getFtxtfWidth().getText()), 
									Integer.parseInt(dlgRectangle.getFtxtfHeight().getText()), false, dlgRectangle.borderColor, dlgRectangle.innerColor);
							shapeList.add(rectangle);
							repaint();
						}

					}else if(frame.tglbtnCircle.isSelected()) {
						DlgCircle dlgCircle = new DlgCircle();
						dlgCircle.getFtxtfCenterX().setText(Integer.toString(e.getX()));
						dlgCircle.getFtxtfCenterY().setText(Integer.toString(e.getY()));
						dlgCircle.getFtxtfCenterX().setEnabled(false);
						dlgCircle.getFtxtfCenterY().setEnabled(false);
						dlgCircle.setVisible(true);
						if(dlgCircle.flag == true) {
							Circle circle = new Circle(new Point(e.getX(),e.getY()), Integer.parseInt(dlgCircle.getFtxtfRadius().getText()), false, dlgCircle.borderColor,dlgCircle.innerColor);
							shapeList.add(circle);
							repaint();
						}
						
						
						
					}else if(frame.tglbtnDonut.isSelected()) {
						DlgDonut dlgDonut = new DlgDonut();
						dlgDonut.getFtxtfCenterX().setText(Integer.toString(e.getX()));
						dlgDonut.getFtxtfCenterY().setText(Integer.toString(e.getY()));
						dlgDonut.getFtxtfCenterX().setEnabled(false);
						dlgDonut.getFtxtfCenterY().setEnabled(false);
						dlgDonut.setVisible(true);
						if(dlgDonut.flag == true) {
							Donut donut = new Donut(new Point(e.getX(), e.getY()), Integer.parseInt(dlgDonut.getFtxtfRadius().getText()), Integer.parseInt(dlgDonut.getFtxtfInnerRadius().getText()), false, dlgDonut.borderColor, dlgDonut.innerColor);
							shapeList.add(donut);
							repaint();
						}
					}
				}

			}
				
		});
		
		

	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		for (Shape shape : shapeList) {
			if(shape instanceof Shape) shape.draw(g);
		}
		for (Shape shape : shapeList) {
			if(shape instanceof Point && shape.isSelected()) {
				oldPoint = (Point) shape;
				selection = new Rectangle(new Point(oldPoint.getX() - 2, oldPoint.getY() - 2), 4, 4, false, Color.blue);
				selection.drawSelected(g);
				selectPoint = new Point(oldPoint.getX(), oldPoint.getY(), false, transparentColor);
				selectPoint.draw(g);
				break;
			}else if(shape instanceof Line && shape.isSelected()) {
				oldLine = (Line) shape;
				selection = new Rectangle(new Point(oldLine.getStartPoint().getX() - 2, oldLine.getStartPoint().getY() - 2), 4, 4, false, Color.blue);
				selection.drawSelected(g);
				selection = new Rectangle(new Point(oldLine.getEndPoint().getX() -2, oldLine.getEndPoint().getY() -2), 4, 4, false, Color.blue);
				selection.drawSelected(g);
				
				selectLine = new Line(oldLine.getStartPoint(), oldLine.getEndPoint(), false, transparentColor);
				selectLine.draw(g);
				break;
			}else if(shape instanceof Rectangle && shape.isSelected()) {
				oldRectangle = (Rectangle) shape;
				selection = new Rectangle(new Point(oldRectangle.getUpperLeftPoint().getX() - 2, oldRectangle.getUpperLeftPoint().getY() - 2), 4, 4, false, Color.blue);
				selection.drawSelected(g);
				selection = new Rectangle(new Point(oldRectangle.getUpperLeftPoint().getX() + oldRectangle.getWidth() - 2, oldRectangle.getUpperLeftPoint().getY() - 2), 4, 4, false, Color.blue);
				selection.drawSelected(g);
				selection = new Rectangle(new Point(oldRectangle.getUpperLeftPoint().getX() - 2, oldRectangle.getUpperLeftPoint().getY() + oldRectangle.getHeight() - 2), 4, 4, false, Color.blue);
				selection.drawSelected(g);
				selection = new Rectangle(new Point(oldRectangle.getUpperLeftPoint().getX() + oldRectangle.getWidth() - 2, oldRectangle.getUpperLeftPoint().getY() + oldRectangle.getHeight() - 2), 4, 4, false, Color.blue);
				selection.drawSelected(g);
				
				selectRectangle = new Rectangle(oldRectangle.getUpperLeftPoint(), oldRectangle.getWidth(), oldRectangle.getHeight(), false,  Color.blue, transparentColor);
				selectRectangle.draw(g); 
				break;
			}
			else if(shape instanceof Donut && shape.isSelected()){
				oldDonut = (Donut) shape;
				
				selectDonut = new Donut(oldDonut.getCenter(), oldDonut.getRadius(), oldDonut.getInnerRadius(), false, Color.blue, transparentColor);
				selectDonut.draw(g);
				
				selection = new Rectangle(new Point(oldDonut.getCenter().getX() - 2, oldDonut.getCenter().getY() - 2), 4, 4, false, Color.blue);
				selection.drawSelected(g);
				selection = new Rectangle(new Point(oldDonut.getCenter().getX() - oldDonut.getRadius() - 2, oldDonut.getCenter().getY() - 2), 4, 4, false, Color.blue);
				selection.drawSelected(g);
				selection = new Rectangle(new Point(oldDonut.getCenter().getX() - 2, oldDonut.getCenter().getY() - oldDonut.getRadius() - 2), 4, 4, false, Color.blue);
				selection.drawSelected(g);
				selection = new Rectangle(new Point(oldDonut.getCenter().getX() + oldDonut.getRadius() - 2, oldDonut.getCenter().getY() - 2), 4, 4, false, Color.blue);
				selection.drawSelected(g);
				selection = new Rectangle(new Point(oldDonut.getCenter().getX() - 2, oldDonut.getCenter().getY() + oldDonut.getRadius() - 2), 4, 4, false, Color.blue);
				selection.drawSelected(g);
				
				
				
				break;
			}else if(shape instanceof Circle && shape.isSelected()) {
				oldCircle = (Circle) shape;
				
				selectCircle = new Circle(oldCircle.getCenter(), oldCircle.getRadius(), false, Color.blue, transparentColor);
				selectCircle.draw(g);
				
				selection = new Rectangle(new Point(oldCircle.getCenter().getX() - 2, oldCircle.getCenter().getY() - 2), 4, 4, false, Color.blue);
				selection.drawSelected(g);
				selection = new Rectangle(new Point(oldCircle.getCenter().getX() - oldCircle.getRadius() - 2, oldCircle.getCenter().getY() - 2), 4, 4, false, Color.blue);
				selection.drawSelected(g);
				selection = new Rectangle(new Point(oldCircle.getCenter().getX() - 2, oldCircle.getCenter().getY() - oldCircle.getRadius() - 2), 4, 4, false, Color.blue);
				selection.drawSelected(g);
				selection = new Rectangle(new Point(oldCircle.getCenter().getX() + oldCircle.getRadius() - 2, oldCircle.getCenter().getY() - 2), 4, 4, false, Color.blue);
				selection.drawSelected(g);
				selection = new Rectangle(new Point(oldCircle.getCenter().getX() - 2, oldCircle.getCenter().getY() + oldCircle.getRadius() - 2), 4, 4, false, Color.blue);
				selection.drawSelected(g);
				break;
			}
		}
	}
	
	
	
	public void delete() {
		for (Shape shape : shapeList) {
			if(shape instanceof Shape && shape.isSelected()) {
				DlgDelete dlgDelete = new DlgDelete();
				dlgDelete.setVisible(true);
				if(dlgDelete.safetyCheck == true) {
					shapeList.remove(shape);
				}
				break;
			}
		}
		repaint();
	}
	
	public void deleteAll() {
		DlgDeleteAll dlgDeleteAll = new DlgDeleteAll();
		dlgDeleteAll.setVisible(true);
		if(dlgDeleteAll.safetyCheck == true) {
			shapeList.removeAll(shapeList);
		}
		repaint();
	}
	
	
	public void modify() {
		for (Shape shape : shapeList) {
			if(shape instanceof Point && shape.isSelected()) {
				oldPoint = (Point) shape;
				modifyPoint();
				break;
			}else if(shape instanceof Line && shape.isSelected()) {
				oldLine = (Line) shape;
				modifyLine();
				break;
			}else if(shape instanceof Rectangle && shape.isSelected()) {
				oldRectangle = (Rectangle) shape;
				modifyRectangle();
				break;
			}
			else if(shape instanceof Donut && shape.isSelected()){
				oldDonut = (Donut) shape;
				modifyDonut();
				break;
			}else if(shape instanceof Circle && shape.isSelected()) {
				oldCircle = (Circle) shape;
				modifyCircle();
				break;
			}
		}
		repaint();
	}
	
	public void modifyPoint() {
		DlgPoint dlgPoint = new DlgPoint();
		dlgPoint.getFtxtfXcoord().setText(Integer.toString(oldPoint.getX()));
		dlgPoint.getFtxtfYcoord().setText(Integer.toString(oldPoint.getY()));
		dlgPoint.setInitialColor(oldPoint.getColor());
		dlgPoint.setVisible(true);
		if(dlgPoint.flag == true) {
			Point modificatedPoint;
			if(dlgPoint.colorChange == false) {
				modificatedPoint = new Point(Integer.parseInt(dlgPoint.getFtxtfXcoord().getText()),
						Integer.parseInt(dlgPoint.getFtxtfYcoord().getText()),
						false, dlgPoint.getInitialColor());
			}else {
				modificatedPoint = new Point(Integer.parseInt(dlgPoint.getFtxtfXcoord().getText()),
						Integer.parseInt(dlgPoint.getFtxtfYcoord().getText()),
						false, dlgPoint.getColor());
			}
			
			shapeList.add(modificatedPoint);
			shapeList.remove(oldPoint);
		}
	}
	
	public void modifyLine() {
		DlgLine dlgLine = new DlgLine();
		dlgLine.getFtxtfStartX().setText(Integer.toString(oldLine.getStartPoint().getX()));
		dlgLine.getFtxtfStartY().setText(Integer.toString(oldLine.getStartPoint().getY()));
		dlgLine.getFtxtfEndX().setText(Integer.toString(oldLine.getEndPoint().getX()));
		dlgLine.getFtxtfEndY().setText(Integer.toString(oldLine.getEndPoint().getY()));
		dlgLine.setInitialColor(oldLine.getColor());
		dlgLine.setVisible(true);
		if(dlgLine.flag == true) {
			Line modificatedLine;
			if(dlgLine.colorChange == false) {
				modificatedLine = new Line(new Point(Integer.parseInt(dlgLine.getFtxtfStartX().getText()),
						Integer.parseInt(dlgLine.getFtxtfStartY().getText())),
						new Point(Integer.parseInt(dlgLine.getFtxtfEndX().getText()),
								Integer.parseInt(dlgLine.getFtxtfEndY().getText())),
						false, dlgLine.getInitialColor());
			}else {
			modificatedLine = new Line(new Point(Integer.parseInt(dlgLine.getFtxtfStartX().getText()),
					Integer.parseInt(dlgLine.getFtxtfStartY().getText())),
					new Point(Integer.parseInt(dlgLine.getFtxtfEndX().getText()),
							Integer.parseInt(dlgLine.getFtxtfEndY().getText())),
					false, dlgLine.color );
			}
			shapeList.add(modificatedLine);
			shapeList.remove(oldLine);
		}
	}
	
	public void modifyRectangle() {
		DlgRectangle dlgRectangle = new DlgRectangle();
		dlgRectangle.getFtxtfXcoord().setText(Integer.toString(oldRectangle.getUpperLeftPoint().getX()));
		dlgRectangle.getFtxtfYcoord().setText(Integer.toString(oldRectangle.getUpperLeftPoint().getY()));
		dlgRectangle.getFtxtfWidth().setText(Integer.toString(oldRectangle.getWidth()));
		dlgRectangle.getFtxtfHeight().setText(Integer.toString(oldRectangle.getHeight()));
		dlgRectangle.setInitialBorderColor(oldRectangle.getColor());
		dlgRectangle.setInitialInnerColor(oldRectangle.getInnerColor());
		dlgRectangle.setVisible(true);
		if(dlgRectangle.flag == true) {
			Rectangle modificatedRectangle;
			if(dlgRectangle.borderColorChanged == true) {
				if(dlgRectangle.innerColorChanged == true) {
					modificatedRectangle = new Rectangle(new Point(Integer.parseInt(dlgRectangle.getFtxtfXcoord().getText()), 
							Integer.parseInt(dlgRectangle.getFtxtfYcoord().getText())),
							Integer.parseInt(dlgRectangle.getFtxtfWidth().getText()),
							Integer.parseInt(dlgRectangle.getFtxtfHeight().getText()),
							false, dlgRectangle.borderColor, dlgRectangle.innerColor);
				}
				else {
					modificatedRectangle = new Rectangle(new Point(Integer.parseInt(dlgRectangle.getFtxtfXcoord().getText()), 
							Integer.parseInt(dlgRectangle.getFtxtfYcoord().getText())),
							Integer.parseInt(dlgRectangle.getFtxtfWidth().getText()),
							Integer.parseInt(dlgRectangle.getFtxtfHeight().getText()),
							false, dlgRectangle.borderColor, dlgRectangle.getInitialInnerColor());
				}
			}else if(dlgRectangle.innerColorChanged == true) {
				modificatedRectangle = new Rectangle(new Point(Integer.parseInt(dlgRectangle.getFtxtfXcoord().getText()), 
						Integer.parseInt(dlgRectangle.getFtxtfYcoord().getText())),
						Integer.parseInt(dlgRectangle.getFtxtfWidth().getText()),
						Integer.parseInt(dlgRectangle.getFtxtfHeight().getText()),
						false, dlgRectangle.getInitialBorderColor(), dlgRectangle.innerColor);
			}else {
				modificatedRectangle = new Rectangle(new Point(Integer.parseInt(dlgRectangle.getFtxtfXcoord().getText()), 
						Integer.parseInt(dlgRectangle.getFtxtfYcoord().getText())),
						Integer.parseInt(dlgRectangle.getFtxtfWidth().getText()),
						Integer.parseInt(dlgRectangle.getFtxtfHeight().getText()),
						false, dlgRectangle.getInitialBorderColor(), dlgRectangle.getInitialInnerColor());
			}
			
			shapeList.add(modificatedRectangle);
			shapeList.remove(oldRectangle);
		}
	}
	
	public void modifyCircle() {
		DlgCircle dlgCircle = new DlgCircle();
		dlgCircle.getFtxtfCenterX().setText(Integer.toString(oldCircle.getCenter().getX()));
		dlgCircle.getFtxtfCenterY().setText(Integer.toString(oldCircle.getCenter().getY()));
		dlgCircle.getFtxtfRadius().setText(Integer.toString(oldCircle.getRadius()));
		dlgCircle.setInitialBorderColor(oldCircle.getColor());
		dlgCircle.setInitialInnerColor(oldCircle.getInnerColor());
		dlgCircle.setVisible(true);
		if(dlgCircle.flag == true) {
			Circle modificatedCircle;
			if(dlgCircle.borderColorChanged == true) {
				if(dlgCircle.innerColorChanged == true) {
					modificatedCircle = new Circle(new Point(Integer.parseInt(dlgCircle.getFtxtfCenterX().getText()),
							Integer.parseInt(dlgCircle.getFtxtfCenterY().getText())),
							Integer.parseInt(dlgCircle.getFtxtfRadius().getText()),
							false, dlgCircle.borderColor, dlgCircle.innerColor);
				}
				else {
					modificatedCircle = new Circle(new Point(Integer.parseInt(dlgCircle.getFtxtfCenterX().getText()),
							Integer.parseInt(dlgCircle.getFtxtfCenterY().getText())),
							Integer.parseInt(dlgCircle.getFtxtfRadius().getText()),
							false, dlgCircle.borderColor, dlgCircle.getInitialInnerColor());
				}
			}else if(dlgCircle.innerColorChanged == true) {
				modificatedCircle = new Circle(new Point(Integer.parseInt(dlgCircle.getFtxtfCenterX().getText()),
						Integer.parseInt(dlgCircle.getFtxtfCenterY().getText())),
						Integer.parseInt(dlgCircle.getFtxtfRadius().getText()),
						false, dlgCircle.getInitialBorderColor(), dlgCircle.innerColor);
			}else {
				modificatedCircle = new Circle(new Point(Integer.parseInt(dlgCircle.getFtxtfCenterX().getText()),
						Integer.parseInt(dlgCircle.getFtxtfCenterY().getText())),
						Integer.parseInt(dlgCircle.getFtxtfRadius().getText()),
						false, dlgCircle.getInitialBorderColor(), dlgCircle.getInitialInnerColor());
			}
			shapeList.add(modificatedCircle);
			shapeList.remove(oldCircle);
		}
	}
	
	public void modifyDonut() {
		DlgDonut dlgDonut = new DlgDonut();
		dlgDonut.getFtxtfCenterX().setText(Integer.toString(oldDonut.getCenter().getX()));
		dlgDonut.getFtxtfCenterY().setText(Integer.toString(oldDonut.getCenter().getY()));
		dlgDonut.getFtxtfRadius().setText(Integer.toString(oldDonut.getRadius()));
		dlgDonut.getFtxtfInnerRadius().setText(Integer.toString(oldDonut.getInnerRadius()));
		dlgDonut.setInitialBorderColor(oldDonut.getColor());
		dlgDonut.setInitialInnerColor(oldDonut.getInnerColor());
		dlgDonut.setVisible(true);
		if(dlgDonut.flag == true) {
			Donut modificatedDonut;
			if(dlgDonut.borderColorChanged == true) {
				if(dlgDonut.innerColorChanged == true) {
					modificatedDonut = new Donut(new Point(Integer.parseInt(dlgDonut.getFtxtfCenterX().getText()),
							Integer.parseInt(dlgDonut.getFtxtfCenterY().getText())),
							Integer.parseInt(dlgDonut.getFtxtfRadius().getText()),
							Integer.parseInt(dlgDonut.getFtxtfInnerRadius().getText()),
							false, dlgDonut.borderColor, dlgDonut.innerColor);
				}
				else {
					modificatedDonut = new Donut(new Point(Integer.parseInt(dlgDonut.getFtxtfCenterX().getText()),
							Integer.parseInt(dlgDonut.getFtxtfCenterY().getText())),
							Integer.parseInt(dlgDonut.getFtxtfRadius().getText()),
							Integer.parseInt(dlgDonut.getFtxtfInnerRadius().getText()),
							false, dlgDonut.borderColor, dlgDonut.getInitialInnerColor());
				}
			}else if(dlgDonut.innerColorChanged == true) {
				modificatedDonut = new Donut(new Point(Integer.parseInt(dlgDonut.getFtxtfCenterX().getText()),
						Integer.parseInt(dlgDonut.getFtxtfCenterY().getText())),
						Integer.parseInt(dlgDonut.getFtxtfRadius().getText()),
						Integer.parseInt(dlgDonut.getFtxtfInnerRadius().getText()),
						false, dlgDonut.getInitialBorderColor(), dlgDonut.innerColor);
			}else {
				modificatedDonut = new Donut(new Point(Integer.parseInt(dlgDonut.getFtxtfCenterX().getText()),
						Integer.parseInt(dlgDonut.getFtxtfCenterY().getText())),
						Integer.parseInt(dlgDonut.getFtxtfRadius().getText()),
						Integer.parseInt(dlgDonut.getFtxtfInnerRadius().getText()),
						false, dlgDonut.getInitialBorderColor(), dlgDonut.getInitialInnerColor());
			}
			shapeList.add(modificatedDonut);
			shapeList.remove(oldDonut);
		}
	}
	
	

}
