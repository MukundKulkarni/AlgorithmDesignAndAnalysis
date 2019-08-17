import java.util.*;
class FractionalKnapsack{
    static double[] getMaxValue(double[] w, double[] v, double W){
        int n = w.length;
        double[] vbyw = new double[n];
        double[] x = new double[n];
        for(int i = 0; i<n; i++){
            vbyw[i] = v[i]/w[i];
            x[i] = 0;
        }
        MergeSort ob = new MergeSort();
        ob.sort(vbyw,0,n-1);
        double weight = 0;
        double value = 0;
        for(int i = 0; i < n ; i++){
            if(weight + w[i] <= W){
                x[i] = 1;
                weight += w[i];
                value  += v[i];
            }
            else{
                x[i] = (W - weight)/w[i];
                weight = W;
                value += v[i]*x[i];
                break;
            }
        }
        ob.printArray(vbyw);
        System.out.println("Max Value obtained = " + value);
        return x;
    }

    public static void main(String args[]){
        double[] w = {10,20,30,40,50};
        double[] v = {50,60,70,80,90};
        double W = 80;
        double[] x = getMaxValue(w,v,W);
        for(int i = 0 ; i <w.length ; i++){
            System.out.println(x[i]);
        }

    }
}
