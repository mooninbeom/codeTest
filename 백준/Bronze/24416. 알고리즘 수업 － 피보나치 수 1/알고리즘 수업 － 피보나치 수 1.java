import java.io.*;
import java.util.*;

public class Main {

    static int recursNum = 0;
    static int recursDpNum = 0;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        var N = Integer.parseInt(br.readLine());
        arr = new long[N+1];
        arr[1] = 1;
        arr[2] = 2;
        recurs(N);
        recursDp(N);

        bw.write(recursNum+" "+recursDpNum);






        bw.flush();
        bw.close();
    }

    static long recurs(long a){
        if(a==1||a==2){
            recursNum++;
            return 1;
        }
        return recurs(a-1)+recurs(a-2);
    }

    static long recursDp(int a){
        if(arr[a]!=0) return arr[a];
        else if(a==1||a==2) return 1;
        recursDpNum++;
        return arr[a] = recursDp(a-1) + recursDp(a-2);
    }
}
