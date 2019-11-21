package wdw.classic.DAG.topological;


public class Dfs {
    /**
     * 对每个节点 v 做dfs，如果发现某个顶点 w 有 w-->v 的回边，则存在环，排序失败
     * 借助一个标志列表 flags，用于判断每个节点 i （课程）的状态：
     * 未被 DFS 访问：i == 0；
     * 已被其他节点启动的DFS访问：i == -1；
     * 已被当前节点启动的DFS访问：i == 1。
     * @param adjacency
     * @param i
     * @param flags
     * @return
     */
    public static boolean dfs(int[][] adjacency,int i, int flags[]){
        if(flags[i] == 1) return false;
        if(flags[i] == -1) return true;
        flags[i] = 1;
        for(int j = 0; j < adjacency.length; j ++){
            if(adjacency[i][j] == 1 && !dfs(adjacency,j,flags)) return false;
        }
        flags[i] = -1;
        return true;
    }

    public static void main(String[] args) {
        int num = 8;
        int[][] prerequisites = {{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}};
        int[][] adjacency = new int[num][num];
        int[] flags = new int[num];
        //将边缘列表 转换为 邻接矩阵
        for(int[] cp : prerequisites){
            adjacency[cp[1]][cp[0]] = 1;
        }
        //对每个顶点进行DFS
        for(int i = 0; i < num; i ++){
            if(!dfs(adjacency,i,flags)) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
