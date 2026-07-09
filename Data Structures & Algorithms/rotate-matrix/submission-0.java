class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int[] arr : matrix){
            reverse(arr, n);
        }

    }

    public void reverse(int[] arr, int n){
        int i =0;
        int j= n-1;

        while(i <= j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}