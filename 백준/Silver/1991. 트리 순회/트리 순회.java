import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][2];

        for(int i=0; i<N; i++){
            String[] a = br.readLine().split(" ");

            arr[a[0].charAt(0)-65][0] = (a[1].equals("."))? -1: a[1].charAt(0)-65;
            arr[a[0].charAt(0)-65][1] = (a[2].equals("."))? -1: a[2].charAt(0)-65;
        }




        sb = new StringBuilder();

        sb.append("A");
        preorder(0);
        bw.write(sb.toString()+"\n");

        sb = new StringBuilder();
        inorder(0);
        bw.write(sb.toString()+"\n");

        
        sb = new StringBuilder();
        reverseorder(0);
        bw.write(sb.toString()+"");









        bw.flush();
        bw.close();


    }

    public static void preorder(int a){
        for(int i=0; i<2; i++){
            if(arr[a][i]!=-1){
                sb.append((char)(arr[a][i]+65));
                preorder(arr[a][i]);
            }
        }
    }

    public static void reverseorder(int a){
        for(int i=0; i<2; i++){
            if(arr[a][i]!=-1){
                reverseorder(arr[a][i]);
            }
        }
        sb.append((char)(a+65));
    }

    public static void inorder(int a){
        for(int i=0; i<2; i++){
            if(arr[a][i]!=-1){
                inorder(arr[a][i]);
            }
            if(i!=1) sb.append((char)(a+65));
        }
    }


}
