class MakingChange{
    static int[][] findCoins(int[] available_denominations, int total_value){
        int matrix_row = available_denominations.length + 1;
        int matrix_column = total_value + 1;
        int[][] solution_matrix = new int[matrix_row][matrix_column];

        for(int i = 0; i < matrix_row ; i++){
            solution_matrix[i][0] = Integer.MAX_VALUE - 1;
        }

        for(int i = 0; i < matrix_column ; i++){
            solution_matrix[0][i] = Integer.MAX_VALUE - 1;
        }



        for(int i = 1; i < available_denominations.length + 1; i++){
            for(int j = 1; j < total_value + 1; j++){
                if(available_denominations[i - 1] == j){
                    solution_matrix[i][j] = 1;
                }
                else if(available_denominations[i-1] > j){
                    solution_matrix[i][j] = solution_matrix[i - 1][j];
                }
                else{
                    solution_matrix[i][j] = Integer.min(solution_matrix[i-1][j], 1 + solution_matrix[i][j - available_denominations[i-1]]);
                }
            }
        }

        return solution_matrix;
    }

    public static void main(String[] args) {
        int[] available_denominations = {5,1,7};
        int total_value = 11;

        int matrix_row = available_denominations.length + 1;
        int matrix_column = total_value + 1;

        int[][] result = MakingChange.findCoins(available_denominations,total_value);

        System.out.println("SOLUTION MATRIX\n");

        for(int i = 0; i < matrix_row; i++){
            for(int j = 0; j < matrix_column; j++){
                if(result[i][j] == Integer.MAX_VALUE - 1){
                    System.out.print("# ");

                }
                else{
                    System.out.print(result[i][j] + " ");
                }
            }
            System.out.println();
        }

        System.out.println("\nSELECTED COINS\n");

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
        }

    }
}
