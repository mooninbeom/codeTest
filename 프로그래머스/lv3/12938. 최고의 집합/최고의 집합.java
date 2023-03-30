

class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        if(n>s) return answer = new int[]{-1};
        answer = new int[n];
        java.util.Arrays.fill(answer,s/n);
        if(n==s) return answer;

        int i=answer.length-1;
        int a = s%n;

        while(a-->0){
            answer[i]++;
            if(i==0) i = answer.length;
            i--;
        }
        return answer;
    }
}