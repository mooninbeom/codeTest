import java.io.*;
import java.util.*;

public class Main {

    static int check(int a){
        if(a==1) return 1;
        else if(a==2) return 2;
        else if(a==3) return 4;
        else return check(a-1)+check(a-2)+check(a-3);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        while(N-->0){
            int n = Integer.parseInt(br.readLine());
            bw.write(check(n)+"\n");
        }





        bw.flush();
        bw.close();
    }
}