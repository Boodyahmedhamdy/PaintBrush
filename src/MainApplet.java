import shapes.*;
import java.applet.Applet;
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class MainApplet extends Applet  {
    Color color = Color.BLACK;
    boolean isSolid = false;
    boolean isDotted = false;
    ArrayList<Shape> shapes;
    Shape currentShape;
    int currentShapeType = Shape.NONE;
	int tempx1, tempy1, tempx2, tempy2;
	ArrayList<Point> tempFreePoints = new ArrayList<Point>();


    class MainAppletMouseAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
			
			tempx1 = tempx2 = e.getX();
			tempy1 = tempy2 = e.getY();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if(currentShapeType != Shape.NONE) {
				tempx2 = e.getX();
				tempy2 = e.getY();
				if(currentShapeType == Shape.PENCIL || currentShapeType == Shape.ERASER) {
					tempFreePoints.add(new Point(tempx2, tempy2));
				}
                repaint();
            }
        }
		
		@Override 
		public void mouseReleased(MouseEvent e) {
			
			if(tempx1 != tempx2 || tempy1 != tempy2) {
				switch (currentShapeType) {
					case Shape.LINE:
						currentShape = new Line(tempx1, tempy1, tempx2, tempy2, color, isSolid, isDotted);
						break;
					case Shape.RECTANGLE:
						currentShape = new Rectangle(tempx1, tempy1, tempx2, tempy2, color, isSolid, isDotted);
						break;
					case Shape.OVAL:
						currentShape = new Oval(tempx1, tempy1, tempx2, tempy2, color, isSolid, isDotted);
						break;
					case Shape.PENCIL:
						currentShape = new Pencil(tempx1, tempy1, tempx2, tempy2, color, isSolid, isDotted, tempFreePoints);
						tempFreePoints.clear();
						break;
					case Shape.ERASER:
						currentShape = new Eraser(tempFreePoints);
						tempFreePoints.clear();
						break;
					default:
						System.out.println("something went wrong -> " + currentShapeType);
						break;
					}
				shapes.add(currentShape);
				repaint();
			}
		}
    }

    class ClearBtnActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            shapes.clear();
			tempFreePoints.clear();
			// clear temp variables
			tempx1 = tempy1 = tempx2 = tempy2 = 0;
            repaint();
        }
    }

    class LineBtnActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            currentShapeType = Shape.LINE;
        }
    }

    class RectBtnActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            currentShapeType = Shape.RECTANGLE;
        }
    }

    class OvalBtnActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentShapeType = Shape.OVAL;
        }
    }

    class isSolidCheckBoxActionListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            isSolid = !isSolid;
        }
    }

    class RedBtnActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            color = Color.RED;
        }
    }

    class GreenBtnActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            color = Color.GREEN;
        }
    }

    class BlueBtnActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            color = Color.BLUE;
        }
    }

    class BlackBtnActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            color = Color.BLACK;
        }
    }

    class UndoBtnActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!shapes.isEmpty()){
                shapes.remove(shapes.size()-1);
                repaint();
            }
        }
    }

    class PencilBtnActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentShapeType = Shape.PENCIL;
        }
    }

    class EraserBtnActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentShapeType = Shape.ERASER;
        }
    }

    @Override
    public void init() {
        shapes = new ArrayList<>();


        setupShapesButtons();
        setupColorsButtons();

        MainAppletMouseAdapter mouseAdapter = new MainAppletMouseAdapter();
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    private void setupShapesButtons() {
        // buttons
        Button undoBtn = new Button("Undo");
        Button clearBtn = new Button("Clear");
        Button lineBtn = new Button("Line");
        Button rectBtn = new Button("Rectangle");
        Button ovalBtn = new Button("Oval");
        Checkbox isSolidCheckBox = new Checkbox("isSolid", isSolid);
        Button pencilBtn = new Button("Pencil");
        Button eraserBtn = new Button("Eraser");


        // actions and register
        UndoBtnActionListener undoBtnActionListener = new UndoBtnActionListener();
        undoBtn.addActionListener(undoBtnActionListener);

        ClearBtnActionListener clearBtnActionListener = new ClearBtnActionListener();
        clearBtn.addActionListener(clearBtnActionListener);

        LineBtnActionListener lineBtnActionListener = new LineBtnActionListener();
        lineBtn.addActionListener(lineBtnActionListener);

        RectBtnActionListener rectBtnActionListener = new RectBtnActionListener();
        rectBtn.addActionListener(rectBtnActionListener);

        OvalBtnActionListener ovalBtnActionListener = new OvalBtnActionListener();
        ovalBtn.addActionListener(ovalBtnActionListener);

        isSolidCheckBoxActionListener isSolidCheckBoxActionListener = new isSolidCheckBoxActionListener();
        isSolidCheckBox.addItemListener(isSolidCheckBoxActionListener);

        PencilBtnActionListener pencilBtnActionListener = new PencilBtnActionListener();
        pencilBtn.addActionListener(pencilBtnActionListener);

        EraserBtnActionListener eraserBtnActionListener = new EraserBtnActionListener();
        eraserBtn.addActionListener(eraserBtnActionListener);

        // adding to the applet
        add(undoBtn);
        add(clearBtn);
        add(lineBtn);
        add(rectBtn);
        add(ovalBtn);
        add(isSolidCheckBox);
        add(pencilBtn);
        add(eraserBtn);
    }

    void setupColorsButtons() {
        // color buttons
        Label colorsLabel = new Label("Colors");

        Button redBtn = new Button("RED");
        redBtn.setBackground(Color.RED);

        Button greenBtn = new Button("GREEN");
        greenBtn.setBackground(Color.GREEN);

        Button blueBtn = new Button("BLUE");
        blueBtn.setBackground(Color.BLUE);

        Button blackBtn = new Button("Black");
        blackBtn.setBackground(Color.BLACK);

        RedBtnActionListener redBtnActionListener = new RedBtnActionListener();
        redBtn.addActionListener(redBtnActionListener);

        GreenBtnActionListener greenBtnActionListener = new GreenBtnActionListener();
        greenBtn.addActionListener(greenBtnActionListener);

        BlueBtnActionListener blueBtnActionListener = new BlueBtnActionListener();
        blueBtn.addActionListener(blueBtnActionListener);

        BlackBtnActionListener blackBtnActionListener = new BlackBtnActionListener();
        blackBtn.addActionListener(blackBtnActionListener);

        add(colorsLabel);
        add(redBtn);
        add(greenBtn);
        add(blueBtn);
        add(blackBtn);
    }

    @Override
    public void paint(Graphics g) {
		g.setColor(color);
		// temp draw
		switch (currentShapeType) {
			case Shape.LINE:
				g.drawLine(tempx1, tempy1, tempx2, tempy2);
				break;
			case Shape.RECTANGLE:
				if(isSolid) {
					g.fillRect(tempx1, tempy1, Math.abs(tempx1 - tempx2), Math.abs(tempy1 - tempy2));
				} else {
					g.drawRect(tempx1, tempy1, Math.abs(tempx1 - tempx2), Math.abs(tempy1 - tempy2));
				}
				break;
				
			case Shape.OVAL:
				if(isSolid) {
					g.fillOval(tempx1, tempy1, Math.abs(tempx1-tempx2), Math.abs(tempy1-tempy2));
				} else {
					g.drawOval(tempx1, tempy1, Math.abs(tempx1-tempx2), Math.abs(tempy1-tempy2));
				}
				break;
				
			case Shape.PENCIL:
				for(Point point: tempFreePoints) {
					g.fillOval(point.x, point.y, 5, 5);
				}
				break;
			case Shape.ERASER:
				g.setColor(Color.WHITE);
				for(Point point: tempFreePoints) {
					g.fillOval(point.x, point.y, 15, 15);
				}
				break;
			default:
				System.out.println("something went wrong -> " + currentShapeType);
				break;
			}
		// real draw
        for(Shape shape : shapes) {
            shape.draw(g);
        }
        System.out.println(shapes.size());
    }
}
