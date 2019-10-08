package wdw.ojs.usaco.ride;

import java.io.*;

public class ride {
    public static void main(String[] args) throws IOException {
        System.out.println( System.getProperty("user.dir"));;
        BufferedReader reader = new BufferedReader(new FileReader("src/com/wdw/usaco/ride/ride.in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/com/wdw/usaco/ride/ride.out"));

        String s1 = reader.readLine();
        String s2 = reader.readLine();
        int product1 = 1;
        int product2 = 1;
        for(int i = 0; i < s1.length(); i++){
            product1 *= s1.charAt(i) - 'A' + 1;
        }
        for(int i = 0; i < s2.length(); i++){
            product2 *= s2.charAt(i) - 'A' + 1;
        }

        if(product1 % 47 == product2 % 47){
            writer.write("GO\r\n");
        }else{
            writer.write("STAY\r\n");
        }

        reader.close();
        writer.close();
    }
}
