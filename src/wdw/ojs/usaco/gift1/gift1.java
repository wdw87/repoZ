
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
ID:wudw1
LANG:JAVA
PROG:gift1
 */
public class gift1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter writer = new PrintWriter(new FileWriter("gift1.out"));

        int NP = Integer.parseInt(reader.readLine());

        Map<String,Integer> map = new HashMap<>();
        String[] names = new String[NP];
        for(int i = 0; i < NP; i++){
            names[i] = reader.readLine();
            map.put(names[i],0);
        }
        for(int i = 0; i < NP; i ++){
            String giver = reader.readLine();
            StringTokenizer st = new StringTokenizer(reader.readLine()," ");
            int money = Integer.parseInt(st.nextToken());
            int receiver = Integer.parseInt(st.nextToken());
            int givedMoney = 0;
            if(receiver != 0){
                givedMoney = money / receiver;
            }
            map.put(giver,map.get(giver) - givedMoney * receiver);
            for(int j = 0; j < receiver; j++){
                String receiverName = reader.readLine();
                map.put(receiverName,map.get(receiverName) + givedMoney);
            }
        }

        for( String key : names){
            writer.println(key + " " + map.get(key));
        }

        reader.close();
        writer.close();

    }
}
