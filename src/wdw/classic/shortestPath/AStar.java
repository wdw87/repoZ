package wdw.classic.shortestPath;

import java.util.ArrayList;
import java.util.List;

public class AStar {
    static class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    private static List<Integer> openList = new ArrayList<>();
    private static List<Integer> closeList = new ArrayList<>();

}
