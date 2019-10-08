package wdw.classic.shortestPath.AStar;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class AStar {
    private PriorityQueue<Point> openList = new PriorityQueue<>();
    private Set<Point> closeList = new HashSet<>();

    private Grid grid;

    public AStar(Grid grid){
        this.grid = grid;
    }

    protected boolean search(Point start){
        openList.add(start);
        return search();
    }

    private boolean search(){

        if(openList.size() == 0)
            return false;
        if(openList.contains(grid.getEnd()))
            return true;

        //寻找开启列表中F值最低的格子。我们称它为当前格。
        Point tmp = openList.poll();
        //把它切换到关闭列表。
        closeList.add(tmp);
        //对于相邻的八个点
        System.out.println(tmp.getX());
        System.out.println(tmp.getY());
        List<Point> nextList = grid.nextPoints(tmp);
        for(Point p : nextList){
            if(closeList.contains(p)){
                continue;
            }
            //不在openList中
            if(!openList.contains(p)) {
                //设置父节点,指向原始的点
                p.setParent(tmp);
                //记录这点的F,G,和H值
                p.setG(p.getG() + p.getgNext());
                p.setF(p.getG() + p.getH());
                openList.add(p);
            }else{  //在openlist中，看新路是否比旧路更优
                int tmpG = p.getG();
                int newG = p.getG() + p.getgNext();
                if(newG < tmpG){  //更优
                    p.setParent(tmp);
                    p.setG(newG);
                    p.setF(p.getG() + p.getH());
                }
            }
        }
        return search();
    }

    public static void main(String[] args) {
        long startTim,endTim,runTim;
        char[][] cgrid = {
                {'0','0','0','0','0','0','0','0'},
                {'0','0','0','0','#','0','0','0'},
                {'0','0','S','0','#','0','E','0'},
                {'0','0','0','0','#','0','0','0'},
                {'0','0','0','0','#','0','0','0'},
                {'0','0','0','0','#','0','0','0'},
        };

        Grid grid = new Grid(cgrid);
        AStar aStar = new AStar(grid);
        startTim = System.currentTimeMillis();

        aStar.search(grid.getStart());

        runTim = System.currentTimeMillis() - startTim;
        System.out.println("Running Time : " + runTim + "ms");
        grid.printGrid();
    }


}
