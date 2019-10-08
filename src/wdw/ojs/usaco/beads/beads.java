package wdw.ojs.usaco.beads;

import java.io.*;

/*
ID:wudw1
LANG:JAVA
PROG:beads
 */
public class beads {

    private static int mod(int x, int y){
        while(x < 0) x +=y;
        return x % y;
    }
    private static int expan(int point, String necklace, int N){
        int n = 0;
        char color = 'w';
        //向右
        for(int i = 0; i < N; i ++){
            int p = mod(point + i ,N);
            if(color == 'w' && necklace.charAt(p) != 'w'){
                color = necklace.charAt(p);
            }else if (color != necklace.charAt(p) && necklace.charAt(p) != 'w'){
                break;
            }
            n++;
        }
        //向左
        color = 'w';
        for(int i = 1; i < N; i ++){
            int p = mod(point - i , N);
            if(color == 'w' && necklace.charAt(p) != 'w'){
                color = necklace.charAt(p);
            }else if (color != necklace.charAt(p) && necklace.charAt(p) != 'w'){
                break;
            }
            n++;
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/com/wdw/usaco/beads/beads.in"));
        PrintWriter writer = new PrintWriter(new FileWriter("src/com/wdw/usaco/beads/beads.out"));
        int N = Integer.parseInt(reader.readLine());
        String necklace = reader.readLine();

        int max = 0;

        for(int i = 0; i < N; i ++){
            max = Math.max(max,expan(i,necklace,N));
        }
        if(max > N) max = N;
        writer.print(max);
        reader.close();
        writer.close();

    }
}
