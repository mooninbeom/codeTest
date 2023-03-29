import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] arr;
    static int root, remove, num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        root=0;
        arr = new ArrayList[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = new ArrayList<>();

        for(int i=0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            if(a==-1) {
                root = i;
                continue;
            }
            arr[a].add(i);
        }
        num = 0;
        remove = Integer.parseInt(br.readLine());

        if(remove==root){
            System.out.println("0");
            return;
        }

        dfs(root);

        bw.write(num+"");



        bw.flush();
        bw.close();
    }


    public static void dfs(int a){
        if(arr[a].isEmpty()) num++;
        int size = arr[a].size();

        for(int i=0; i<size; i++){
            int temp = arr[a].get(i);
            if(temp==remove) {
                if(size==1){
                    num++;
                }
                continue;
            }
            dfs(temp);
        }
    }

}
