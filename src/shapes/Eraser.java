package shapes;

import java.awt.*;
import java.util.ArrayList;

public class Eraser extends Shape{

    public Eraser() {}
	
	public Eraser(ArrayList<Point> points) {
		this.color = Color.WHITE;
		for(Point point : points) {
			this.points.add(point);
		}
	}
	
	

    private ArrayList<Point> points = new ArrayList<>();
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        for(Point point : points) {
            g.fillRect(point.x, point.y, 15, 15);
        }

    }
}
