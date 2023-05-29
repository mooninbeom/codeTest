import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visit;
    static Queue<Integer> queue;
    static int[] dx = {1,2,3,4,5,6};
    static int[] arr, ladder_snake;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ladder_snake= new int[101];

        for(int i=0; i<N+M; i++){
            st = new StringTokenizer(br.readLine());
            ladder_snake[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        queue = new LinkedList<>();
        visit = new boolean[101];
        arr = new int[101];

        bfs();

        arr[1] = 0;


        bw.write(arr[100]+"\n");



        bw.flush();
        bw.close();
    }


    static void bfs  (){
        queue.offer(1);
        visit[1] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now == 100) return;

            for(int i=0; i<6; i++){
                int next_x = now+dx[i];

                if(next_x>100) continue;
                if(visit[next_x]) continue;

                if(ladder_snake[next_x]>0) next_x = ladder_snake[next_x];
                if(arr[next_x]>0) continue;
                queue.offer(next_x);
                arr[next_x] = arr[now]+1;
                visit[next_x] = true;
            }
        }
    }
}

