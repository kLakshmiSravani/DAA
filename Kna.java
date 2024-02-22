import java.util.*;
class DataObject{
    
    int profit;
    int weight;
    double pw;
}
public class Kna{
    DataObject d[];
    int n,max;
    Scanner sc;
    public Kna(){
        sc=new Scanner(System.in);
        System.out.println("enter no.of objects");
        n=sc.nextInt();
        System.out.print("enter max value");
        max=sc.nextInt();
        d=new DataObject[n];
        for(int i=0;i<n;i++){
            d[i]=new DataObject();
            System.out.println("enter profit");
            d[i].profit=sc.nextInt();
            System.out.println("enter weigths");
            d[i].weight=sc.nextInt();
        }

    }
    public void calculate(){
        for(int i=0;i<n;i++){
            d[i].pw=d[i].profit/d[i].weight;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(d[i].pw<d[j].pw){
                    DataObject temp=d[i];
                    d[i]=d[j];
                    d[j]=temp;
                }
            }
        }
        int s=0,k=0;
        while(max>0){
            if(max>=d[k].weight){
                max=max-d[k].weight;
                s=s+d[k].profit;
            }
            else{
                s=s+(max/d[k].weight)*d[k].profit;
                break;
            }
            
            k++;
        }
        System.out.println("final profit"+s);
    }
    public static void main(String[] args){
        Kna k=new Kna();
        k.calculate();
    }
}