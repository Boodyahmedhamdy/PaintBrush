package shapes;

import java.awt.*;
import java.util.ArrayList;

public class Pencil extends Shape{

    public Pencil(){}
    public Pencil(int x1, int y1, Color color, boolean isSolid, boolean isDotted) {
        super(x1, y1, color, isSolid, isDotted);
    }


	public Pencil(int x1, int y1, int x2, int y2, Color color, boolean isSolid, boolean isDotted) {
        super(x1, y1, x2, y2, color, isSolid, isDotted);
    }
	
	public Pencil(int x1, int y1, int x2, int y2, Color color, boolean isSolid, boolean isDotted, ArrayList<Point> points) {
        super(x1, y1, x2, y2, color, isSolid, isDotted);
		for(Point point: points) {
			this.points.add(point);
		}
    }

    private ArrayList<Point> points = new ArrayList<>();
	


    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        // points.add(new Point(x2, y2));
        for(Point point : points) {
            g.fillOval(point.x, point.y, 5, 5);
            System.out.println("point with (x,y) " + point.x + " " + point.y + " was drawn");
        }
        System.out.println("you have " + points.size() + " points");

    }
}
