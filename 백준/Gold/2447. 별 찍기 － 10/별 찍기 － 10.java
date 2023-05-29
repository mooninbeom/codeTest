import java.io.*;
import java.util.*;

public class Main {


    static char[][] star;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        star = new char[N][N];
        recurs(0,0,N,false);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                bw.write(star[i][j]);
            }
            bw.write("\n");
        }










        bw.flush();
        bw.close();
    }


    public static void recurs(int x, int y, int N, boolean isFive){

        if(isFive){
            for(int i=x; i<x+N; i++){
                for(int j=y; j<y+N; j++){
                    star[i][j] = ' ';
                }
            }
            return;
        }


        if(N==1){
            star[x][y] = '*';
            return;
        }



        int size = N/3;
        int count = 0;

        for(int i=x; i<x+N; i+=size){
            for(int j=y; j<y+N; j+=size){
                count++;
                recurs(i,j,size, count == 5);
            }
        }
    }


}
