import java.io.*;
import java.util.*;

public class Main {


    static boolean[][] star;
    static int blue;
    static int white;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());


        star = new boolean[N][N];
        StringTokenizer st;
        blue = 0;
        white = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                star[i][j] = (st.nextToken().equals("1"))? true : false;
            }
        }


        recurs(0,0,N);
        bw.write(white+"\n"+blue);














        bw.flush();
        bw.close();
    }


    public static void recurs(int x, int y, int N){

//        System.out.println(String.format("x: %d, y:%d, size:%d",x,y,N));
        if(N==1){
            if(star[x][y]) blue++;
            else white++;
            return;
        }

        boolean isReversed = star[x][y];
        boolean isRecurs = false;

        L1:
        for(int i = x; i<x+ N; i++){
            for(int j = y; j<y+ N; j++){
                if(star[i][j] != isReversed){
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
            recurs(x+size,y, size);
            recurs(x,y+size,size);
            recurs(x+size,y+size,size);
            return;
        }

        if (isReversed) {
            blue++;
        } else {
            white++;
        }
        return;
    }


}
