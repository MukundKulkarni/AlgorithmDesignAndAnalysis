import java.util.Scanner;
class Job{
    String id;
    int deadline;
    int profit;

    Job(String tid, int tdeadline, int tprofit){
        id = tid;
        deadline = tdeadline;
        profit = tprofit;
    }

    static void printSelectedJobs(Job[] tjobs){

        boolean[] slot = new boolean[tjobs.length];
        System.out.println("Selected Jobs");
        for(int i = 0; i < tjobs.length; i++){
            for(int j = tjobs[i].deadline; j >= 0; j--){
                if(slot[j] == false){

                    slot[j] = true;

                    System.out.print(" " + tjobs[i].id + " ");
                    break;
                }
            }

        }
    }

    static void sortProfit(Job tjobs[]){
        for(int i=0;i < tjobs.length; i++){
            for(int j = i+1; j< tjobs.length; j++){
                if(tjobs[i].profit < tjobs[j].profit){
                    Job temp = new Job(tjobs[j].id, tjobs[j].deadline, tjobs[j].profit);
                    tjobs[j].id = tjobs[i].id;
                    tjobs[j].deadline = tjobs[i].deadline;
                    tjobs[j].profit = tjobs[i].profit;

                    tjobs[i].id = temp.id;
                    tjobs[i].deadline = temp.deadline;
                    tjobs[i].profit = temp.profit;
                }
            }
        }
    }
}

public class JobScheduling{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Jobs : ");
        int n = sc.nextInt();
        Job[] given_jobs = new Job[n];
        for(int i = 0; i < n; i++){
            System.out.print("\nEnter Job " + (i+1) + " ID :");
            sc.nextLine();
            String id = sc.nextLine();
            System.out.print("\nEnter Job " + (i+1) + " deadline :");
            int deadline = sc.nextInt();
            System.out.print("\nEnter Job " + (i+1) + " profit :");
            int profit = sc.nextInt();

            given_jobs[i] = new Job(id,deadline,profit);
        }

        Job.sortProfit(given_jobs);

        Job.printSelectedJobs(given_jobs);
    }
}
