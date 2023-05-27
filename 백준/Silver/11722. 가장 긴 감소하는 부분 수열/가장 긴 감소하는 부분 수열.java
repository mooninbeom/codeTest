import java.io.*;
import java.util.*;

public class Main {

    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        dp = new int[N];
        arr = new int[N];

        int max = 1;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 1;
        for(int i=1; i<N; i++){
            dp[i] = 1;
            for(int j=i-1; j>=0; j--){
                if(arr[j]>arr[i] && dp[j]>=dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
            if(dp[i]>max) max = dp[i];

        }

        bw.write(String.valueOf(max));



        bw.flush();
        bw.close();
    }





}
