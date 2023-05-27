import java.io.*;
import java.util.*;

public class Main {

    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());



        dp = new int[N+1];
        arr = new int[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = arr[1];
        if(N>1) dp[2] = arr[1]+arr[2];
        System.out.println(recurs(N));




        bw.flush();
        bw.close();
    }

    public static int recurs(int a){
        if(a<=2) return dp[a];
        if(dp[a]==0)
            dp[a] = Math.max(recurs(a-2),arr[a-1]+recurs(a-3))+arr[a];
        return dp[a];
    }




}
