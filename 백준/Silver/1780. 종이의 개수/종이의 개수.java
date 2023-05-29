import java.io.*;
import java.util.*;

public class Main{


    static int[][] arr;
    static int minus;
    static int zero;
    static int plus;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());




        arr = new int[N][N];
        StringTokenizer st;


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        recurs(0,0,N);

        bw.write(minus+"\n"+zero+"\n"+plus);
        

        bw.flush();
        bw.close();
    }


    public static void recurs(int x, int y, int N){

        if(N==1){
            switch (arr[x][y]){
                case -1 :{
                    minus++;
                    break;
                }
                case 0 :{
                    zero++;
                    break;
                }
                case 1 :{
                    plus++;
                    break;
                }
            }
            return;
        }

        int isReversed = arr[x][y];
        boolean isRecurs = false;

        L1:
        for(int i = x; i<x+ N; i++){
            for(int j = y; j<y+ N; j++){
                if(arr[i][j] != isReversed){
                    isRecurs = true;
                    break L1;
                }
            }
        }

        if (isRecurs) {
            int size = N/3;
            for(int i=0; i<=2*size; i+=size){
                for(int j=0; j<=2*size; j+=size){
                    recurs(x+i,y+j,size);
                }
            }
            return;
        }

        switch (arr[x][y]){
            case -1 :{
                minus++;
                break;
            }
            case 0 :{
                zero++;
                break;
            }
            case 1 :{
                plus++;
                break;
            }
        }


    }


}