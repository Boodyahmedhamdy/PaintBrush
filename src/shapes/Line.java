package shapes;

import java.awt.*;

public class Line extends Shape{

    public Line(){

    }
    public Line(int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;

    }
    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

    }
    public Line(int x1, int y1, Color color, boolean isSolid, boolean isDotted) {
        super(x1, y1, color, isSolid, isDotted);

    }
	
	public Line(int x1, int y1, int x2, int y2, Color color, boolean isSolid, boolean isDotted) {
        super(x1, y1, x2, y2, color, isSolid, isDotted);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }
}
