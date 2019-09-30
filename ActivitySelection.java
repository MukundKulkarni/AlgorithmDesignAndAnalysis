import java.util.Scanner;
class Activity{
    String id;
    int start;
    int finish;

    Activity(String tid, int tstart, int tfinish){
        id = tid;
        start = tstart;
        finish = tfinish;
    }

    static void printSelectedActivities(Activity[] tactivities){

        System.out.println("\nSelected Activities\n");
		System.out.print(tactivities[0].id + " ");
        int cfinish = tactivities[0].finish;
        for(int i = 1; i < tactivities.length; i++){
            if(tactivities[i].start >= cfinish){
                System.out.print(" " + tactivities[i].id + " ");
                cfinish = tactivities[i].finish;
            }
		}
    }


    static void sortfinish(Activity tactivities[]){
        for(int i=0;i < tactivities.length; i++){
            for(int j = i+1; j< tactivities.length; j++){
                if(tactivities[i].finish > tactivities[j].finish){
                    Activity temp = new Activity(tactivities[j].id, tactivities[j].start, tactivities[j].finish);
                    tactivities[j].id = tactivities[i].id;
                    tactivities[j].start = tactivities[i].start;
                    tactivities[j].finish = tactivities[i].finish;

                    tactivities[i].id = temp.id;
                    tactivities[i].start = temp.start;
                    tactivities[i].finish = temp.finish;
                }
            }
        }
    }
}

public class ActivitySelection{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Activityies : ");
        int n = sc.nextInt();
        Activity[] given_jobs = new Activity[n];
        for(int i = 0; i < n; i++){
            System.out.print("\nEnter Activity " + (i+1) + " ID :");
            sc.nextLine();
            String id = sc.nextLine();
            System.out.print("\nEnter Activity " + (i+1) + " start :");
            int start = sc.nextInt();
            System.out.print("\nEnter Activity " + (i+1) + " finish :");
            int finish = sc.nextInt();

            given_jobs[i] = new Activity(id,start,finish);
        }

        Activity.sortfinish(given_jobs);

        Activity.printSelectedActivities(given_jobs);
    }
}
