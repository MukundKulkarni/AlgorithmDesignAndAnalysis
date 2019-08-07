import java.util.*;
class FactIterative{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number you want to find the factorial of : ");
        int n = sc.nextInt();
        int result = 1;
        double start = System.nanoTime();
        for(int i = 1; i<=n; i++){
            result *= i;
        }
        double end = System.nanoTime();
        System.out.println("Factorial of " + n + " = " + result);
        System.out.println("\n Time taken = " + (end-start)/100000 + "ms");
    }
}
