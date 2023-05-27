import java.io.*;
import java.util.*;

public class Main {

    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        dp = new long[N+1];
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(recurs(N));



        bw.flush();
        bw.close();
    }

    public static long recurs(int a){
        if(a<=1) return dp[a];
        if(dp[a]!=0) return dp[a];
        dp[a] = recurs(a-1)+recurs(a-2);
        return dp[a];
    }


}
