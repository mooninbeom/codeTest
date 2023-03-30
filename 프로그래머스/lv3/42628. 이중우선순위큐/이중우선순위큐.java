import java.util.*;


class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Queue<Integer> save = new LinkedList<>();
        int len = operations.length;
        int[] answer = new int[2];

        for(int i=0; i<len; i++){
            if(operations[i].charAt(0)=='I') {
                String st = "";
                for(int j=2; j<operations[i].length();j++) st+=operations[i].charAt(j);
                queue.offer(Integer.parseInt(st));
                continue;
            }
            if(queue.isEmpty()) continue;

            if(operations[i].charAt(2)=='1'){
                while(queue.size()!=1){
                    save.offer(queue.poll());
                }
                queue.poll();
                while(!save.isEmpty()) queue.offer(save.poll());
            }else{
                queue.poll();
            }
        }
        if(queue.isEmpty()) return answer = new int[]{0,0};
        else if(queue.size()==1) return answer = new int[]{queue.peek(),queue.peek()};

        int max=0;
        int min = queue.poll();
        while(!queue.isEmpty()) max = queue.poll();
        return answer = new int[]{max,min};
    }
}