import java.util.Arrays;
import java.util.Scanner;
import java.util.PriorityQueue;

public class Dij {

   static class Node implements Comparable<Node> {
       int vertex;
       int distance;

       public Node(int vertex, int distance) {
           this.vertex = vertex;
           this.distance = distance;
       }

       @Override
       public int compareTo(Node other) {
           return Integer.compare(this.distance, other.distance);
       }
   }

   public static void dijkstra(int[][] graph, int source) {
       int n = graph.length;
       int[] distance = new int[n];
       Arrays.fill(distance, Integer.MAX_VALUE);
       distance[source] = 0;

       PriorityQueue<Node> minHeap = new PriorityQueue<>();
       minHeap.add(new Node(source, 0));

       while (!minHeap.isEmpty()) {
           Node currentNode = minHeap.poll();
           int currentVertex = currentNode.vertex;

           for (int neighbor = 0; neighbor < n; neighbor++) {
               if (graph[currentVertex][neighbor] != 0) {
                   int newDistance = distance[currentVertex] + graph[currentVertex][neighbor];
                   if (newDistance < distance[neighbor]) {
                       distance[neighbor] = newDistance;
                       minHeap.add(new Node(neighbor, newDistance));
                   }
               }
           }
       }
       System.out.println("Shortest distances from source " + source + ":");
       for (int i = 0; i < n; i++) {
           System.out.println("To " + i + ": " + distance[i]);
       }
   }

   public static void main(String[] args) {
     Scanner input=new Scanner(System.in);
     System.out.println("enter the no of vertices:");
     int vertices=input.nextInt();
     int [][]graph=new int[vertices][vertices];
     System.out.println("enter the adjacency matrix");
     for(int i=0;i<vertices;i++)
     {
       for(int j=0;j<vertices;j++)
       {
           graph[i][j]=input.nextInt();

       }
     }
     System.out.println("enter the source vertex:");
     int source=input.nextInt();
     dijkstra(graph,source);
   }
}

