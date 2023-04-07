import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> plus = new PriorityQueue<>();
        PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int a = Integer.parseInt(br.readLine());
            if(i==0){
                plus.offer(a);
                bw.write(a+"\n");
                continue;
            }

            //bw.write(Math.min(a,plus.peek())+"\n");

            if(plus.peek()>a){
                minus.offer(a);
            }else{
                plus.offer(a);
            }

            if(i%2==1){
                if(minus.isEmpty()) minus.offer(plus.poll());
                if(plus.size()>minus.size()) minus.offer(plus.poll());
                else if(plus.size()<minus.size()) plus.offer(minus.poll());
                bw.write(Math.min(plus.peek(),minus.peek())+"\n");
                continue;
            }

            if(plus.size()>minus.size()) bw.write(plus.peek()+"\n");
            else bw.write(minus.peek()+"\n");

        }


        bw.flush();
        bw.close();


    }
}

