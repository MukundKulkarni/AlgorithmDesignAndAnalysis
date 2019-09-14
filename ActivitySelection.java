//Assume activities alreaddy sorted according to finish time
import java.util.*; 
class ActivitySelection 

{
	static MergeSort ob = new MergeSort(); 
	public static void printMaxActivities(int s[], int f[], int n) 
	{ 
	int i, j; 
	double[] selected = new double[n];
	System.out.print("Following activities are selected : \n"); 
	
	 
	i = 0; 
	selected[0] = 0;
	//System.out.print(i+" "); 
	
	for (j = 1; j < n; j++) 
	{
		if (s[j] >= f[i]) 
		{ 
			i = j; 
			selected[i] = j;
			//System.out.print(j+" "); 
			
		} 
	} 
		ob.printArray(selected);
	} 
	 
	public static void main(String[] args) 
	{ 
	int s[] = {1, 3, 0, 5, 8, 5}; 
	int f[] = {2, 4, 6, 7, 9, 9}; 
	int n = s.length; 
		
	printMaxActivities(s, f, n); 
	} 
	
} 

