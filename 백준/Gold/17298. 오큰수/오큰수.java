import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> idx = new Stack<>();
        int[] arr = new int[N];



        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (i == 0) {
                stack.push(a);
                idx.push(i);
                continue;
            }

            if (stack.peek() < a) {
                while (true) {
                    if (stack.isEmpty()||stack.peek() >= a) break;

                    stack.pop();
                    arr[idx.pop()] = a;
                }
            }
            stack.push(a);
            idx.push(i);
        }

        for(int a:arr) {
            if(a==0) bw.write("-1 ");
            else bw.write(a+" ");
        }


        bw.flush();
        bw.close();


    }
}