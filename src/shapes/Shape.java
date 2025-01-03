package shapes;

import java.awt.*;

public abstract class Shape {
    protected int x1;
    protected int y1;
    protected int x2;
    protected int y2;
    protected Color color;
    protected boolean isSolid;
    protected boolean isDotted;

    public static final int NONE = 0;
    public static final int LINE = 1;
    public static final int RECTANGLE = 2;
    public static final int OVAL = 3;
    public static final int PENCIL = 4;
    public static final int ERASER = 5;

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }


    Shape(){}
    Shape(int x1, int y1, Color color, boolean isSolid, boolean isDotted) {
        this.x1 = x1;
        this.y1 = y1;
        this.color = color;
        this.isSolid = isSolid;
        this.isDotted = isDotted;
    }

    public Shape(int x1, int y1, int x2, int y2, Color color, boolean isSolid, boolean isDotted) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.isSolid = isSolid;
        this.isDotted = isDotted;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isSolid() {
        return isSolid;
    }

    public void setSolid(boolean solid) {
        isSolid = solid;
    }

    public boolean isDotted() {
        return isDotted;
    }

    public void setDotted(boolean dotted) {
        isDotted = dotted;
    }

    public abstract void draw(Graphics g);

}
