class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] arr = new int[commands.length];

        for(int i=0; i< commands.length; i++){
            int a,b;
            a = commands[i][1];
            b = commands[i][0];
            int[] test = new int[a-b+1];


            int n=0;
            for(int j=b-1;j<a;j++){
                test[n] = array[j];
                n++;
            }
            java.util.Arrays.sort(test);
            arr[i] = test[commands[i][2]-1];
        }
        return arr;
    }
}