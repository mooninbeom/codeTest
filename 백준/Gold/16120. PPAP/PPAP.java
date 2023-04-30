import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] chr = br.readLine().toCharArray();
        int len = chr.length;
        Stack<Character> stack = new Stack<>();
        int n=0;

        for(int i=0; i<len; i++){
            if(chr[i]=='P') stack.push(chr[i]);
            else{
                n++;
                if(stack.isEmpty()||stack.size()<2) {
                    System.out.println("NP");
                    return;
                }
                stack.pop();
                stack.pop();

                if(i==len-1||chr[i+1]=='A'){
                    System.out.println("NP");
                    return;
                }
            }
        }
        if(len==1) n++;

        if(stack.size()<2&&n>0) bw.write("PPAP");
        else bw.write("NP");



        bw.flush();
        bw.close();


    }
}

