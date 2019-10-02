class ZeroOneKnapsack{
    static int[][] findItems(int[] weights , int[] values, int total_weight){
        int matrix_row = weights.length + 1;
        int matrix_column = total_weight + 1;
        int[][] solution_matrix = new int[matrix_row][matrix_column];

        for(int i = 0; i < matrix_row ; i++){
            for(int j = 0; j < matrix_column; j++){
                if(i == 0 || j == 0){
                    solution_matrix[i][j] = 0;
                }
                else if(weights[i - 1] <= j){
                    solution_matrix[i][j] = Integer.max(solution_matrix[i-1][j], values[i - 1] + solution_matrix[i - 1][j - weights[i-1]]);
                }
                else{
                    solution_matrix[i][j] = solution_matrix[i - 1][j];
                }
            }
        }

        return solution_matrix;
    }

    public static void main(String[] args) {
        int[] weights = {5,1,7};
        int[] values = {3,2,4};
        int total_weight = 12;

        int matrix_row = weights.length + 1;
        int matrix_column = total_weight + 1;

        int[][] result = ZeroOneKnapsack.findItems(weights,values, total_weight);

        System.out.println("SOLUTION MATRIX\n");

        for(int i = 0; i < matrix_row; i++){
            for(int j = 0; j < matrix_column; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nMAXIMUM VALUE OBTAINED: " + result[matrix_row - 1][matrix_column - 1]);
        System.out.println("\nSELECTED WEIGHTS\n");

        int i = weights.length;
        int j = total_weight;
        while(i != 0 || j != 0){
            if(result[i][j] == result[i-1][j]){
                i--;
            }
            else{
                System.out.print(weights[i - 1] + " ");
                j -= weights[i - 1];
                i--;
            }
        }

    }
}
