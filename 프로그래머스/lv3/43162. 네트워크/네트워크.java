import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer=0;
        Queue<Integer> arr = new LinkedList<>();
        boolean[] visit = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(visit[i]) continue;
            else{
                arr.offer(i);
                visit[i] = true;
            }

            while(!arr.isEmpty()){
                int temp = arr.poll();

                for(int j=0; j<n; j++){
                    if(computers[temp][j]==1||computers[j][temp]==1){
                        if(!visit[j]){
                            arr.offer(j);
                            visit[j] = true;
                        }
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}