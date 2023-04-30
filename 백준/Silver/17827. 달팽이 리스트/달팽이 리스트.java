import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N,M,V;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        while (M-->0){
            int n = Integer.parseInt(br.readLine());

            if(n/N==0){
                System.out.println(arr[n]);
            }else{
                n = n-N;
                n = n%(N-V+1);
                System.out.println(arr[n+V-1]);
            }
        }
        
        bw.flush();
        bw.close();
    }







}
