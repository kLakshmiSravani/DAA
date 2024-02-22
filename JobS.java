import java.util.Arrays;
import java.util.Scanner;
class Job {
    char id;
    int deadline;                                                        
    int profit;
}
public class JobS{
    public static void printJobSequence(Job[] jobs) {
        
        Arrays.sort(jobs,(a,b)->b.profit-a.profit);
        int n=jobs.length;
        int maxDeadline=getMaxDeadline(jobs);
        char[] result=new char[maxDeadline];
        boolean[] slot=new boolean[maxDeadline];
        Arrays.fill(slot,false);
        for (int i=0;i<n;i++) {
            for (int j=Math.min(maxDeadline-1,jobs[i].deadline-1);j>=0;j--) {
                if (!slot[j]) {
                    result[j]=jobs[i].id;
                    slot[j]=true;
                    break;
                }
            }
        }
        for (char job : result) {
            System.out.print(job + " ");
        }
    }
    private static int getMaxDeadline(Job[] jobs) {
        int maxDeadline=Integer.MIN_VALUE;
        for (Job job : jobs) {
            if (job.deadline>maxDeadline) {
                maxDeadline=job.deadline;
            }
        }
        return maxDeadline;
    }
    public static void main(String[] args) {
        Job jobs[];
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter n value");
        n=sc.nextInt();
        jobs=new Job[n];
        for(int i=0;i<n;i++){
            jobs[i]=new Job();
            System.out.println("Enter id value");
            jobs[i].id=sc.next().charAt(0);
            System.out.println("enter deadline value");
            jobs[i].deadline=sc.nextInt();
            System.out.println("enter profit value");
            jobs[i].profit=sc.nextInt();
        }
        System.out.println("Job sequence is");
        printJobSequence(jobs);
    }
}