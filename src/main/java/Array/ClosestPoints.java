package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClosestPoints {

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        Point p1 = new Point(1,2);
        Point p2 = new Point(2,3);
        Point p3 = new Point(1,-3);
        points.add(p1);
        points.add(p2);
        points.add(p3);

        Point vertex = new Point(2,2);
        int k = 2;

        List<Point> closestPoints = kClosestPoints(points, vertex, k);
        for (Point point : closestPoints) {
            System.out.println(point);
        }
    }

    public static List<Point> kClosestPoints(List<Point> points, Point vertex, int k) {

        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point point1, Point point2) {
                double d1 = point1.distanceTo(vertex);
                double d2 = point2.distanceTo(vertex);
                return Double.compare(d1, d2);
            }
        });

        return points.subList(0,k);
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point point) {
        return Math.sqrt((Math.pow(x- point.x, 2)) - (Math.pow(y- point.y, 2)));
    }

    @Override
    public String toString() {
        return "["+x+", "+y+"]";
    }
}
