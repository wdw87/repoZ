package wdw.classic.shortestPath.AStar;

public class Point implements Comparable<Point> {
    private int x, y;
    private Point parent;
    private int f, g, h;
    private int gNext;
    private char val;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point(int x, int y,char val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    public Point(int x, int y, int f) {
        this.x = x;
        this.y = y;
        this.f = f;
    }
    @Override
    public int compareTo(Point o) {
        return this.f - o.f;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point getParent() {
        return parent;
    }

    public void setParent(Point parent) {
        this.parent = parent;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public char getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }

    public int getgNext() {
        return gNext;
    }

    public void setgNext(int gNext) {
        this.gNext = gNext;
    }
}
