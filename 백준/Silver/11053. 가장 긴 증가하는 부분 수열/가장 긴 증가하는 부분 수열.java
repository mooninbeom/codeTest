import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        var N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[N];
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
        }
        dp[0] = 1;
        for(int i=1; i<N; i++){

            for(int j=i; j>=0; j--){
                if(arr[j]<arr[i] && dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
            if(dp[i]==0) dp[i] = 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(dp[i]>max) max = dp[i];
        }
        System.out.println(max);








        bw.flush();
        bw.close();
    }
}
