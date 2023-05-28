import java.io.*;
import java.util.*;

public class Main {

    static int[] dp;
    static int[][] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        dp = new int[N+1];
        arr = new int[N+1][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;

        for(int i=0; i<=N; i++){
            max = Math.max(dp[i],max);

            int idx = i+arr[i][0];
            if(idx<=N){
                dp[idx] = Math.max(dp[idx],max+arr[i][1]);
            }
        }
        System.out.println(max);


//        System.out.println(max);





        bw.flush();
        bw.close();
    }


}
