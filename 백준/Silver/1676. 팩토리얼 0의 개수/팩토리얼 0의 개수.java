import java.io.*;
import java.util.*;

public class Main{




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int plus = N/25;
        int plus2 = N/125;

        bw.write((N/5+plus+plus2)+"");


        bw.flush();




    }










}
