import java.io.*;
import java.util.*;

public class Main {

    static int num = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while(N-->0){
            String a = br.readLine();
            bw.write(isPalin(a)+" "+num+"\n");
            num=0;
        }



        bw.flush();
        bw.close();
    }


    public static int recurs(String a, int b, int c){
        num++;
        if(b>=c) return 1;
        else if(a.charAt(b)!=a.charAt(c)) return 0;
        return recurs(a,b+1, c-1);
    }

    public static int isPalin(String a){
        return recurs(a,0,a.length()-1);
    }
}
