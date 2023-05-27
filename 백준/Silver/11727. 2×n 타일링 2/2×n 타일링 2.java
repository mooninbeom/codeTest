import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;

    private static int tile(int n){
        if(n==1){
            dp[1] = 1;
            return dp[1];
        } else if(n==2){
            dp[2] = 3;
            return dp[2];
        }
        if(dp[n]>0){
            return dp[n];
        } else{
            dp[n] = (tile(n-1)%10007+(tile(n-2)*2)%10007)%10007;
            return dp[n];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new int[1001];
        int N = Integer.parseInt(br.readLine());
        bw.write(tile(N)+"");



        bw.flush();
        bw.close();
    }
}