package wdw.classic.shortestPath.AStar;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private Point[][] grid;

    private Point start;
    private Point end;

    public Grid(char[][] grid){
        this.grid = new Point[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j++){
                this.grid[i][j] = new Point(i,j,grid[i][j]);
                if(grid[i][j] == 'S')
                    start = this.grid[i][j];
                if(grid[i][j] == 'E')
                    end = this.grid[i][j];
            }
        }
    }
    //计算曼哈顿距离
    protected int manhattan(Point a,Point b){
        return 10 * (Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()));
    }

    protected int getVal(Point p){
        return grid[p.getX()][p.getY()].getVal();
    }

    protected Point getPoint(int x,int y){
        if(x <0 || x >= grid.length ||y < 0 || y >= grid[0].length){
            return null;
        }
        return grid[x][y];
    }
    //判断点是否在矩阵中
    protected boolean reachable(int x,int y){
        if(x <0 || x >= grid.length || y < 0 || y >= grid[0].length || getPoint(x,y).getVal() == '#')
            return false;
        return true;
    }
    //获得下一步可以走的点(八个方向),并计算G和H值
    protected List<Point> nextPoints(Point p){
        List<Point> list = new ArrayList<>();
        //上
        Point next;
        if(reachable(p.getX() - 1,p.getY())){
            next = getPoint(p.getX() - 1,p.getY());
            next.setgNext(10);
            next.setH(manhattan(next,end));
            list.add(next);
        }
        //下
        if(reachable(p.getX() + 1,p.getY())){
            next = getPoint(p.getX() + 1,p.getY());
            next.setgNext(10);
            next.setH(manhattan(next,end));
            list.add(next);
        }
        //左
        if(reachable(p.getX(),p.getY() - 1)){
            next = getPoint(p.getX(),p.getY() - 1);
            next.setgNext(10);
            next.setH(manhattan(next,end));
            list.add(next);
        }
        //右
        if(reachable(p.getX(),p.getY() + 1)){
            next = getPoint(p.getX(),p.getY() + 1);
            next.setgNext(10);
            next.setH(manhattan(next,end));
            list.add(next);
        }
        //左上
        if(reachable(p.getX() - 1,p.getY() - 1)){
            next = getPoint(p.getX() - 1,p.getY() - 1);
            next.setgNext(14);
            next.setH(manhattan(next,end));
            list.add(next);
        }
        //左下
        if(reachable(p.getX() + 1,p.getY() - 1)){
            next = getPoint(p.getX() + 1,p.getY() - 1);
            next.setgNext(14);
            next.setH(manhattan(next,end));
            list.add(next);
        }
        //右上
        if(reachable(p.getX() - 1,p.getY() + 1)){
            next = getPoint(p.getX() - 1,p.getY() + 1);
            next.setgNext(14);
            next.setH(manhattan(next,end));
            list.add(next);
        }
        //右下
        if(reachable(p.getX() + 1,p.getY() + 1)){
            next = getPoint(p.getX() + 1,p.getY() + 1);
            next.setgNext(14);
            next.setH(manhattan(next,end));
            list.add(next);
        }
        return list;

    }

    private void drawPath(){
        Point p = end;
        while(p.getParent() != null){
            if(p.getVal() != 'E')
            p.setVal('1');
            p = p.getParent();
        }
    }

    public void printGrid(){
        drawPath();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                System.out.print(grid[i][j].getVal());
            }
            System.out.println();
        }
    }

    public Point[][] getGrid() {
        return grid;
    }

    public void setGrid(Point[][] grid) {
        this.grid = grid;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }
}
