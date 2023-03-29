import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());


        L1:
        while(T-->0){
            String st1 = br.readLine();
            int n = Integer.parseInt(br.readLine());
            boolean check = true;

            Deque<Integer> arr = new ArrayDeque<>();

            StringTokenizer st = new StringTokenizer(br.readLine(),",");

            int length = st.countTokens();

            if(n==1){
                int a=0;
                int k=1;
                String test = st.nextToken();
                for(int i=test.length()-2;i>=1; i--){
                    a+=Character.getNumericValue(test.charAt(i))*k;
                    k*=10;
                }
                arr.offer(a);
            }else if(n>1) {
                for (int i = 0; i < length; i++) {
                    String test = st.nextToken();
                    if (test.charAt(0) == '[') {
                        int a = 0;
                        int k = 1;
                        for (int j = test.length() - 1; j >= 1; j--) {
                            a += Character.getNumericValue(test.charAt(j)) * k;
                            k *= 10;
                        }
                        arr.offer(a);
                        continue;
                    } else if (test.charAt(test.length() - 1) == ']') {
                        int a = 0;
                        int k = 1;
                        for (int j = test.length() - 2; j >= 0; j--) {
                            a += Character.getNumericValue(test.charAt(j)) * k;
                            k *= 10;
                        }
                        arr.offer(a);
                        continue;
                    }
                    arr.offer(Integer.parseInt(test));
                }
            }

            for(int i=0; i<st1.length(); i++){
                if(st1.charAt(i)=='R') check = !check;
                else {
                    if(arr.isEmpty()) {
                        bw.write("error\n");
                        continue L1;
                    }
                    else {
                        if (check) arr.poll();
                        else arr.pollLast();
                    }
                }
            }

            bw.write("[");
            int a = arr.size();

            for(int i=0; i<a; i++) {
                if(arr.isEmpty()) bw.write("2341321");
                if(i==a-1) {
                    bw.write(arr.poll()+"");
                    continue;
                }
                if(check) bw.write(arr.poll()+",");
                else bw.write(arr.pollLast()+",");
            }
            bw.write("]\n");
        }

        bw.flush();
        bw.close();
    }

}





