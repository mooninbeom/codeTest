import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        var N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[N];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            if(i==0) {
                dp[i] = a;
                max = dp[i];
                continue;
            }
            dp[i] = Math.max(dp[i-1]+a,a);
            if(dp[i]>max) max = dp[i];
        }
        bw.write(String.valueOf(max));







        bw.flush();
        bw.close();
    }
}
