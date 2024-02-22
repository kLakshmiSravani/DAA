import java.util.*;
public class Optimal{
    public static int optimalmerge(int[] files,int n){
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int file:files){
            pq.add(file);
        }
        int cost=0;
        while(pq.size()>1){
            int file1=pq.poll();
            int file2=pq.poll();
            int mergedfilesize=file1+file2;
            cost+=mergedfilesize;
            pq.add(mergedfilesize);

        }
        return cost;

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the no.of files");
        int n=sc.nextInt();
        System.out.println("enter file size");
        int[] files=new int[n];
        for(int file=0;file<files.length;file++){
            files[file]=sc.nextInt();
        }
        int mincost=optimalmerge(files,n);
        System.out.println(mincost+" comparison");
    }
}