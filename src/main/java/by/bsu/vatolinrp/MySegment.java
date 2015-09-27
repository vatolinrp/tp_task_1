package by.bsu.vatolinrp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * @version 1.0
 * @created 18-Sep-2014 15:38:18
 */
public class MySegment extends MyFigure1D {

	public MySegment(Point firstPoint, Color lineColor, Point secondPoint){
		super(firstPoint, lineColor,secondPoint);
	}

	
	public void paint(Graphics2D g){
		
			drawLine(g);
		
	}
	
	public void  move(Point point){
		Point p=getFirstPoint();
		setFirstPoint(point);
		setSecondPoint(new Point(getSecondPoint().x-p.x+getFirstPoint().x,getSecondPoint().y-p.y+getFirstPoint().y));
		
	}


	public void drawLine(Graphics2D g) {
		g.setStroke(new BasicStroke(3));
		g.setColor(getLineColor());
		g.drawLine(getFirstPoint().x,getFirstPoint().y,getSecondPoint().x,getSecondPoint().y) ;
	}
	

}