import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int a:works) queue.offer(a);

        while(n-->0){
            int a = queue.poll();
            a--;
            queue.offer(a);
        }
        if(queue.peek()<=0) return 0;
        else{
            long answer = 0;
            while(!queue.isEmpty()) answer+=Math.pow(queue.poll(),2);
            return answer;
        }
    }
}