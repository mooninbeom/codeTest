import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp;
    static int[][] arr;
    static int N;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        dp = new int[N][3];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        bw.write(Math.min(recurs(N-1,0),Math.min(recurs(N-1,1),recurs(N-1,2)))+"");







        bw.flush();
        bw.close();
    }


    public static int recurs(int a, int b){
        if(dp[a][b]==0){
            if(b==0){
                dp[a][0] = Math.min(recurs(a-1,1),recurs(a-1,2))+arr[a][0];
            }else if(b==1){
                dp[a][1] = Math.min(recurs(a-1,0),recurs(a-1,2))+arr[a][1];
            }else{
                dp[a][2] = Math.min(recurs(a-1,0),recurs(a-1,1))+arr[a][2];
            }
        }
        return dp[a][b];
    }


}
