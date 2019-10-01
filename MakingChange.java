class MakingChange{
    static int[][] find_coins(int[] available_denominations, int total_value){
        int matrix_row = available_denominations.length + 1;
        int matrix_column = total_value + 1;
        int[][] solution_matrix = new int[matrix_row][matrix_column];

        for(int i = 0; i < matrix_row; i++){
            solution_matrix[i][0] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < matrix_column; i++){
            solution_matrix[0][i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < available_denominations.length; i++){
            for(int j = 1; j < matrix_column; j++){
                if(j % available_denominations[i] == 0){

                    int solution = (int)(j/available_denominations[i]);
                    if(solution < solution_matrix[i][j]){
                        solution_matrix[i+1][j] = solution;
                    }
                    else
                    {
                        solution_matrix[i+1][j] = solution_matrix[i][j];
                    }

                }
                else{
                        solution_matrix[i+1][j] = solution_matrix[i][j];
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

        int[][] solution_matrix = new int[matrix_row][matrix_column];


        for(int i = 0; i < matrix_row; i++){
            solution_matrix[i][0] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < matrix_column; i++){
            solution_matrix[0][i] = Integer.MAX_VALUE;
        }



        for(int i = 0; i < matrix_row; i++){
            for(int j = 0; j < matrix_column; j++){
                System.out.print(solution_matrix[i][j] + " ");
            }
            System.out.println();
        }

        int[][] result = MakingChange.find_coins(available_denominations,total_value);

        System.out.println("\n\n\n");
        for(int i = 0; i < matrix_row; i++){
            for(int j = 0; j < matrix_column; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}
