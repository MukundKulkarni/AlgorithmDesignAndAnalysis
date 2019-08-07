import java.util.*;
class FactRecursive{
    static int fact(int n){
        if(n==1 || n==0){
            return 1;
        }
        else{
            return(n*fact(n-1));
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number you want to find the factorial of : ");
        int n = sc.nextInt();
        double start = System.nanoTime();
        int result = fact(n);
        double end = System.nanoTime();
        System.out.println("Factorial of " + n + " = " + result);
        System.out.println("\n Time taken = " + (end-start)/100000 + "ms");

    }
}
