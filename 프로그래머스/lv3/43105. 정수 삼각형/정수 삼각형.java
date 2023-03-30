class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        int a = triangle.length;

        for(int i=len;i>1; i--){
            a--;
            for(int j=0; j<i-1; j++){
                triangle[a-1][j] += Math.max(triangle[a][j],triangle[a][j+1]);
            }
        }
        return triangle[0][0];
    }
}