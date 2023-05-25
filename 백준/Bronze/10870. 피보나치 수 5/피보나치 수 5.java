import java.io.*;
import java.util.*;

public class Main {

    public static int pibo(int N){
        if(N==0) return 0;
        else if(N==1) return 1;
        return pibo(N-1)+pibo(N-2);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(pibo(Integer.parseInt(br.readLine()))+"");



        bw.flush();
        bw.close();
    }
}