class ZeroOneKnapsack{
    static int[][] findItems(int[] weights , int[] values, int total_weight){
        int matrix_row = weights.length + 1;
        int matrix_column = total_weight + 1;
        int[][] solution_matrix = new int[matrix_row][matrix_column];

        for(int i = 0; i < matrix_row ; i++){
            solution_matrix[i][0] = 0;
        }

        for(int i = 0; i < matrix_column ; i++){
            solution_matrix[0][i] = 0;
        }

        for(int i = 1; i < matrix_row ; i++){
            for(int j = 1; j < matrix_column; j++){
                if(weights[i - 1] == j){
                    solution_matrix[i][j] = values[i - 1];
                }
                else{
                    solution_matrix[i][j] = Integer.max(solution_matrix[i-1][j], solution_matrix[i-1][j] + solution_matrix[i - 1][j - 1]);
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

        System.out.println("\nSELECTED COINS\n");
/*
        int i = available_denominations.length;
        int j = total_value;
        while(i != 0 || j != 0){
            if(result[i][j] == result[i-1][j]){
                i--;
            }
            else{
                System.out.print(available_denominations[i - 1] + " ");
                j -= available_denominations[i - 1];
            }
        }*/

    }
}
