import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String T = br.readLine();
        for(int i=0; i<Integer.parseInt(T); i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            long result=0;
            long j=1;
            while(true){
                if(j==1 || j==2)
                    result ++;
                else {
                    result += (j-1) * 2;
                }
                if(result>=B-A)
                    break;
                j++;
            }

            if(j>2){
                if(((j-1)*2-(result-(B-A)))%((j-1)*2)==0)
                    j=2+(j-2)*2;
                else if(((j-1)*2-(result-(B-A)))%((j-1)*2)>(j-1))
                    j=2+(j-2)*2;
                else
                    j=1+(j-2)*2;
            }

            bw.write(j+"\n");
            bw.flush();
        }
    }
}







