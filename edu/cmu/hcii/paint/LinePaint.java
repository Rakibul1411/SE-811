package edu.cmu.hcii.paint;

import java.awt.*;

public class LinePaint extends PaintObject {

    private Point start;
    private Point end;

    public LinePaint() {}

    public double getStartX() { return start == null ? 0 : start.getX(); }
    public double getStartY() { return start == null ? 0 : start.getY(); }
    public double getEndX()   { return end   == null ? 0 : end.getX();   }
    public double getEndY()   { return end   == null ? 0 : end.getY();   }

    public void define(Point[] points) {
        if (points == null || points.length == 0) return;
        start = points[0];
        end   = points[points.length - 1];
    }

    public Rectangle getBoundingBox() {
        if (start == null || end == null)
            return new Rectangle(0, 0, 0, 0);
        int x = Math.min(start.x, end.x) - thickness / 2;
        int y = Math.min(start.y, end.y) - thickness / 2;
        int w = Math.abs(end.x - start.x) + thickness;
        int h = Math.abs(end.y - start.y) + thickness;
        return new Rectangle(x, y, w, h);
    }

    public void paint(Graphics2D g) {
        if (start == null || end == null) return;
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.setColor(color);
        g.drawLine(start.x, start.y, end.x, end.y);
        g.setStroke(oldStroke);
    }
}
