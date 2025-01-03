package shapes;

import java.awt.*;

public class Rectangle extends Shape{

    public Rectangle(int x1, int y1, Color color, boolean isSolid, boolean isDotted) {
        super(x1, y1, color, isSolid, isDotted);
    }
	
	public Rectangle(int x1, int y1, int x2, int y2, Color color, boolean isSolid, boolean isDotted) {
        super(x1, y1, x2, y2, color, isSolid, isDotted);
    }


    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        if(isSolid) {
            g.fillRect(x1, y1, Math.abs(x2-x1), Math.abs(y2-y1));
        } else {
            g.drawRect(x1, y1, Math.abs(x2-x1), Math.abs(y2-y1));
        }
    }
}
