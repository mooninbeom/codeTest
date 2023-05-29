import java.io.*;
import java.util.*;


class Edge implements Comparable<Edge>{
    int node;
    int value;

    public Edge(int node, int value){
        this.node = node;
        this.value = value;
    }

    @Override
    public int compareTo(Edge edge){
        return this.value - edge.value;
    }


}


public class Main{
    public static ArrayList<Edge>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int node, line;
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        list = new ArrayList[node+1];
        dist = new int[node+1];

        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for(int i=0; i<line; i++){
            String[] st2 = br.readLine().split(" ");
            int start1 = Integer.parseInt(st2[0]);
            int end1 = Integer.parseInt(st2[1]);
            int value1 = Integer.parseInt(st2[2]);
            list[start1].add(new Edge(end1,value1));
//            System.out.println(String.format("%d %d %d",start1,end1,value1));
//            System.out.println(list[]);
        }
//        for(Edge edge: list[1]) System.out.println(String.format("%d %d",edge.node, edge.value));

        bfs(start);

        for(int i=1; i<=node; i++){
            if(dist[i]==Integer.MAX_VALUE) bw.write("INF\n");
            else bw.write(dist[i]+"\n");
        }









        bw.flush();
        bw.close();
    }

    public static void bfs(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start,0));

        while(!pq.isEmpty()){
            Edge now = pq.poll();
//            System.out.println(now.node);

            for(Edge temp: list[now.node]){
                if(dist[temp.node] > now.value + temp.value){
                    dist[temp.node] = now.value + temp.value;
                    pq.offer(new Edge(temp.node, dist[temp.node]));
                }
            }
        }
    }





}
