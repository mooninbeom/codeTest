import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = arr[0];

        dp[0] = arr[0];

        for(int i=1; i<N; i++){
            dp[i] = arr[i];
            int min = 0;

            for(int j=i-1; j>=0; j--){
                if(arr[i]>arr[j]){
                    if(min<dp[j]){
                        min = dp[j];
                        dp[i] = min+arr[i];
                    }
                }
            }
            if(max<dp[i]) max = dp[i];
        }
        System.out.println(max);








        bw.flush();
        bw.close();
    }


}
