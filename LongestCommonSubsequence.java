class LongestCommonSubsequence{

    static int[][] solution_matrix;
    static char[][] path_matrix;

    static void findLength(String str1,String str2){

        solution_matrix = new int[str1.length() + 1][str2.length() + 1];
        path_matrix = new char[str1.length() + 1][str2.length() + 1];

        for(int i = 0; i <= str1.length() ; i++){
            solution_matrix[i][0] = 0;
            path_matrix[i][0] = '*';
        }

        for(int i = 0; i <= str2.length() ; i++){
            solution_matrix[0][i] = 0;
            path_matrix[0][i] = '*';
        }

        for(int i = 1; i <= str1.length(); i++){
            for(int j = 1; j <= str2.length(); j++){

                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    solution_matrix[i][j] = solution_matrix[i - 1][j -1] + 1;
                    path_matrix[i][j] = 'A';

                }
                else if(solution_matrix[i][j-1] > solution_matrix[i - 1][j]){
                    solution_matrix[i][j] = solution_matrix[i][j-1];
                    path_matrix[i][j] = 'L';

                }
                else{
                    solution_matrix[i][j] = solution_matrix[i-1][j];
                    path_matrix[i][j] = 'U';

                }
            }
        }
    }

    static int[][] getSolutionMatrix(){
        return solution_matrix;
    }

    static char[][] getPathMatrix(){
        return path_matrix;
    }



    public static void main(String args[]){
        String str1 = "AEDFHR";
        String str2 = "ABCDGH";
        LongestCommonSubsequence.findLength(str1, str2);
        int[][] result = getSolutionMatrix();
        char[][] path = getPathMatrix();
        System.out.println("SOLUTION MATRIX\n");

        for(int i = 0; i <= str1.length(); i++){
            for(int j = 0; j <= str2.length(); j++){
                    System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nPATH MATRIX\n");

        for(int i = 0; i <= str1.length(); i++){
            for(int j = 0; j <= str2.length(); j++){
                    System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nLENGTH OF LONGEST COMMON SUBSEQUENCE : " + result[str1.length()][str2.length()]);

        int i = str1.length();
        int j = str2.length();

        StringBuilder sequence = new StringBuilder();

        while(i != 0 || j != 0){
            if(path_matrix[i][j] == 'A'){
                sequence.append(str1.charAt(i - 1));
                i--;
                j--;
            }
            else if(path_matrix[i][j] == 'L'){
                j--;
            }
            else{
                i--;
            }

        }
        System.out.println("\nLONGEST COMMON SUBSEQUENCE : " + sequence.reverse());

    }
}
