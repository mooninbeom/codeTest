import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> arr = new LinkedList<>();
        boolean[] visit = new boolean[words.length+1];

        arr.offer(begin);
        int a = 0;


        L1:
        while(!arr.isEmpty()) {
            int size = arr.size();

            for (int k = 0; k < size; k++) {
                String st = arr.poll();
                if (st.equals(target)) {
                    visit[words.length] = true;
                    break L1;
                }
                for (int i = 0; i < words.length; i++) {
                    if (visit[i]) continue;
                    int n = 0;
                    for (int j = 0; j < begin.length(); j++) {
                        if (st.charAt(j) != words[i].charAt(j)) n++;
                    }
                    if (n == 1) {
                        arr.offer(words[i]);
                        visit[i] = true;
                    }
                }

            }
            a++;
        }
        if(!visit[words.length]) return 0;

        return a;
    }
}