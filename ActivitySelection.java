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

        System.out.println("Selected Activities\n");
		System.out.print(tactivities[0].id);
        for(int i = 1; i < tactivities.length; i++){

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

public class ActivityScheduling{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Activitys : ");
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

        Activity.printSelectedActivitys(given_jobs);
    }
}
