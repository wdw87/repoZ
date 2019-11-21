package wdw.classic.DAG.topological;

import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 拓扑排序就是检测有向图是否有环
 */
public class Indegree {
    /**
     *
     * @param numCourses 结点数量
     * @param prerequisites 以边缘列表法存储的图 [[1,0]] 表示 0-->1  ,千万注意
     * https://leetcode-cn.com/problems/course-schedule/
     * @return
     */
    public static boolean topologicalSort(int numCourses, int[][] prerequisites){
        int[] indegree = new int[numCourses]; //每个结点的入度表
        for(int[] cp : prerequisites){   //统计入度
            indegree[cp[0]] ++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i ++){
            if(indegree[i] == 0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            Integer pre = queue.poll();
            numCourses--;
            System.out.print(pre + "-->");
            for(int[] cp : prerequisites){
                if(cp[1] != pre) continue;
                if(--indegree[cp[0]] == 0) queue.offer(cp[0]);
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        int num = 8;
        //注意这里以边缘列表法存储的图 [[1,0]] 表示 0-->1  ,千万注意
        int[][] prerequisites = {{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}};
        System.out.println(topologicalSort(num,prerequisites));
    }
}
