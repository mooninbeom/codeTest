import java.io.*;
import java.lang.annotation.Target;
import java.util.*;

public class Main{


    static boolean[][] star;
    static int blue;
    static int white;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        sb = new StringBuilder();


        star = new boolean[N][N];
        blue = 0;
        white = 0;

        for(int i=0; i<N; i++){
            char[] st = br.readLine().toCharArray();
            for(int j=0; j<N; j++){
                star[i][j] = (st[j] == '1')? true : false;
            }
        }


        recurs(0,0,N);

        bw.write(sb.toString());














        bw.flush();
        bw.close();
    }


    public static void recurs(int x, int y, int N){

//        System.out.println(String.format("x: %d, y:%d, size:%d",x,y,N));
        if(N==1){
            if(star[x][y]) sb.append('1');
            else sb.append('0');
            return;
        }

        boolean isReversed = star[x][y];
        boolean isRecurs = false;

        L1:
        for(int i = x; i<x+ N; i++){
            for(int j = y; j<y+ N; j++){
                if(star[i][j] != isReversed){
                    sb.append('(');
                    isRecurs = true;
//                    System.out.print(String.format("here ----- i=%d, j=%d and ",i,j));
//                    System.out.println(isReversed);
                    break L1;
                }
            }
        }

        if (isRecurs) {
            int size = N/2;
            recurs(x,y,size);
            recurs(x,y+size, size);
            recurs(x+size,y,size);
            recurs(x+size,y+size,size);
            sb.append(')');
            return;
        }

        if (isReversed) {
            sb.append('1');
        } else {
            sb.append('0');
        }
    }


}
