package by.bsu.vatolinrp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class MainFrame extends JFrame
{

    private ArrayList<Figure> list = new ArrayList<Figure>();
    private Figure current;

    private JMenuItem exitItem;

    private JMenuItem move;
    private JMenuItem lineColorItem;
    private JMenuItem fillColorItem;

    private JMenuItem segment;
    private JMenuItem ray;
    private JMenuItem line;

    private JMenuItem poligon;
    private JMenuItem regular;
    private JMenuItem rect;
    private JMenuItem rhomb;
    private JMenuItem parallelogram;
    private JMenuItem isoscelesTriangle;
    private JMenuItem ellipse;
    private JMenuItem circle;

    private JMenuItem square;
    private JMenuItem triangle;

    private JMenuItem Clear;
    private JFileChooser fc;

    private Color lineColor = Color.BLUE;
    private Color fillColor = Color.GREEN;

    ShapePanel tp;
    static int q = 0;

    MainFrame()
    {
        super();

        createMenu();

        addFiguresPanel();

        setSize(600, 500);
        setResizable(false);
    }

    private void addFiguresPanel()
    {
        Container content = getContentPane();

        tp = new ShapePanel(list);
        content.add(tp);
    }

    private void createMenu()
    {

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        createMenuBar(menuBar);
        addListeners();
    }

    private void createMenuBar(JMenuBar menuBar)
    {
        JMenu fileMenu = new JMenu("File");
        JMenu EditMenu = new JMenu("Edit");
        JMenu PaintMenu1D = new JMenu("Paint1D");
        JMenu PaintMenu2D = new JMenu("Paint2D");
        JMenu regular = new JMenu("RegularFigure");

        menuBar.add(fileMenu);

        menuBar.add(EditMenu);
        menuBar.add(PaintMenu1D);
        menuBar.add(PaintMenu2D);

        createItems();

        fileMenu.add(exitItem);

        EditMenu.add(move);
        EditMenu.add(lineColorItem);
        EditMenu.add(fillColorItem);
        EditMenu.add(Clear);

        PaintMenu1D.add(segment);
        PaintMenu1D.add(ray);
        PaintMenu1D.add(line);

        PaintMenu2D.add(poligon);
        PaintMenu2D.add(regular);
        PaintMenu2D.add(rect);
        PaintMenu2D.add(rhomb);
        PaintMenu1D.add(parallelogram);
        PaintMenu2D.add(isoscelesTriangle);
        PaintMenu2D.add(ellipse);
        PaintMenu2D.add(circle);

        regular.add(triangle);
        regular.add(square);

    }

    private void addListeners()
    {

        DemoAction lDemoAction = new DemoAction();
        exitItem.addActionListener(lDemoAction);

        move.addActionListener(lDemoAction);
        lineColorItem.addActionListener(lDemoAction);
        fillColorItem.addActionListener(lDemoAction);
        Clear.addActionListener(lDemoAction);

        segment.addActionListener(lDemoAction);
        ray.addActionListener(lDemoAction);
        line.addActionListener(lDemoAction);

        poligon.addActionListener(lDemoAction);
        regular.addActionListener(lDemoAction);
        rect.addActionListener(lDemoAction);
        rhomb.addActionListener(lDemoAction);
        parallelogram.addActionListener(lDemoAction);
        isoscelesTriangle.addActionListener(lDemoAction);
        ellipse.addActionListener(lDemoAction);
        circle.addActionListener(lDemoAction);

        triangle.addActionListener(lDemoAction);
        square.addActionListener(lDemoAction);

    }

    private void createItems()
    {
        exitItem = new JMenuItem("Exit");

        move = new JMenuItem("Move Figure");
        lineColorItem = new JMenuItem("Color of borders");
        fillColorItem = new JMenuItem("Color of fill");
        Clear = new JMenuItem("Clear All");

        segment = new JMenuItem("Segment");
        ray = new JMenuItem("Ray");
        line = new JMenuItem("Line");

        poligon = new JMenuItem("Polygon");
        regular = new JMenuItem("Regular Figure");
        rect = new JMenuItem("Rectangle");
        rhomb = new JMenuItem("Rhombus");
        parallelogram = new JMenuItem("Parallelogram");
        ellipse = new JMenuItem("Ellipse");
        circle = new JMenuItem("Circle");

        square = new JMenuItem("4 sides");
        triangle = new JMenuItem("3 sides");
        isoscelesTriangle = new JMenuItem("Triangle with equal sides");

    }

    public static void main(String[] args)
    {

        MainFrame mf = new MainFrame();
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf.show();

    }

    class DemoAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            List<Point> points = tp.getPoints();

            if (event.getSource() == exitItem)
            {
                System.exit(0);
            }
            if (event.getSource() == move)
            {
                if(validateAction(1))
                {
                    current.move(points.get(0));
                }
            }
            if (event.getSource() == lineColorItem)
            {
                lineColor = getColor();
            }
            if (event.getSource() == fillColorItem)
            {
                fillColor = getColor();
            }
            if (event.getSource() == segment)
            {
                if(validateAction(2))
                {
                    Figure c = new Segment(points.get(0), lineColor, points.get(1));
                    current = c;
                    list.add(c);
                }
            }
            if (event.getSource() == ray)
            {
                if(validateAction(2))
                {
                    Figure c = new Ray(points.get(0), lineColor, points.get(1));
                    current = c;
                    list.add(c);
                }
            }
            if (event.getSource() == line)
            {
                if(validateAction(2))
                {
                    Figure c = new Line(points.get(0), lineColor, points.get(1));
                    current = c;
                    list.add(c);
                }
            }
            if (event.getSource() == poligon)
            {
                if(validateAction(3))
                {
                    Figure c = new Polygon(points.get(0), lineColor, fillColor,
                            points.toArray(new Point[points.size()]));
                    current = c;
                    list.add(c);
                }
            }
            if (event.getSource() == ellipse)
            {
                if(validateAction(2))
                {
                    Figure c = new Ellipse(points.get(0), lineColor, fillColor,
                            points.toArray(new Point[points.size()]));
                    current = c;
                    list.add(c);
                }
            }
            if (event.getSource() == circle)
            {
                if(validateAction(2))
                {
                    Figure c = new Circle(points.get(0), lineColor, fillColor,
                            points.toArray(new Point[points.size()]));
                    current = c;
                    list.add(c);
                }
            }
            if (event.getSource() == rect)
            {
                if(validateAction(2))
                {
                    Figure c = new Rectangle(points.get(0), lineColor, fillColor,
                            points.toArray(new Point[points.size()]));
                    current = c;
                    list.add(c);
                }
            }
            if (event.getSource() == isoscelesTriangle)
            {
                if(validateAction(2))
                {
                    Figure c = new IsoscelesTriangle(points.get(0), lineColor, fillColor,
                            points.toArray(new Point[points.size()]));
                    current = c;
                    list.add(c);
                }
            }
            if (event.getSource() == rhomb)
            {
                if(validateAction(2))
                {
                    Figure c = new Rhombus(points.get(0), lineColor, fillColor,
                            points.toArray(new Point[points.size()]));
                    current = c;
                    list.add(c);
                }
            }
            if (event.getSource() == parallelogram)
            {
                if(validateAction(2))
                {
                    Figure c = new Parallelogram(points.get(0), lineColor, fillColor,
                            points.toArray(new Point[points.size()]));
                    current = c;
                    list.add(c);
                }
            }
            if (event.getSource() == square)
            {
                if(validateAction(2))
                {
                    Figure c = new RegularFigure(points.get(1), lineColor, fillColor, points.get(0),4);
                    current = c;
                    list.add(c);
                }
            }
            if (event.getSource() == triangle)
            {
                if(validateAction(2))
                {
                    Figure c = new RegularFigure(points.get(1), lineColor, fillColor, points.get(0),3);
                    current = c;
                    list.add(c);
                }
            }

            if (event.getSource() == Clear)
            {
                ClearItem_Action();
            }

            repaintAndClear(points);

        }

    }

    private Color getColor()
    {
        return JColorChooser.showDialog(this, "Choose color", Color.green);
    }

    private void clearLists()
    {
        list.clear();
    }

    private void repaintAndClear(List<Point> points)
    {
        this.repaint();
        points.clear();
    }

    private boolean validateAction(int numberNeeded)
    {
        if ((tp.getPoints()).size() >= numberNeeded)
        {
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "need points: " + numberNeeded);
            return false;
        }
    }

    private void ClearItem_Action()
    {
        clearLists();
        this.repaint();

    }
}

class ShapePanel extends JPanel
{
    private ArrayList<Figure> AL;
    private List<Point> points = new ArrayList<Point>();

    public ShapePanel(ArrayList<Figure> al)
    {
        super();
        AL = al;
        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent event)
            {
                points.add(event.getPoint());
                repaint();
            }
        });
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < points.size(); ++i)
        {
            Point p = points.get(i);
            g.drawOval(p.x, p.y, 3, 3);
        }

        for (int i = 0; i < AL.size(); ++i)
        {
            AL.get(i).draw(g2);
        }

    }

    public List<Point> getPoints()
    {
        return points;
    }

}
