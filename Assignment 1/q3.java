import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class q3 {

    public static void main(String args[]) 
    { 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a no of nodes: ");
        Integer n = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj =  
                            new ArrayList<ArrayList<Integer>>(n); 
        for (int i = 0; i < n; i++) { 
            adj.add(new ArrayList<Integer>()); 
        } 
        System.out.print("Enter a no of edges: ");
        Integer m = sc.nextInt();
        for(int i=0;i<m;i++){
            System.out.print("Enter a edges variable 1 \n");
            Integer tmp1 = sc.nextInt();
            System.out.print("Enter a edges variable 2 \n");
            Integer tmp2 = sc.nextInt();
            addEdge(adj, tmp1, tmp2);
        }
        int source = 0, dest = n-1; 
        printShortestDistance(adj, source, dest, n); 
    }
    private static void printShortestDistance( 
                     ArrayList<ArrayList<Integer>> adj, 
                             int s, int dest, int v) 
    { 
        int node_dist[] = new int[v];
        int node_pre[] = new int[v]; 
  
        if (BFS(adj, s, dest, v, node_pre, node_dist) == false) { 
            System.out.println("No Path"); 
            return; 
        } 
  
        LinkedList<Integer> path = new LinkedList<Integer>(); 
        int crawl = dest; 
        path.add(crawl); 
        while (node_pre[crawl] != -1) { 
            path.add(node_pre[crawl]); 
            crawl = node_pre[crawl]; 
        } 
  
        System.out.println("Shortest path length \n" + node_dist[dest]); 
  
        System.out.println("Path \n"); 
        for (int i = path.size() - 1; i >= 0; i--) { 
            System.out.print(path.get(i) + " "); 
        } 
    }
    private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int src, 
                                  int dest, int v, int node_pre[], int node_dist[]) 
    { 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        boolean visited[] = new boolean[v]; 
        for (int i = 0; i < v; i++) { 
            visited[i] = false; 
            node_dist[i] = Integer.MAX_VALUE; 
            node_pre[i] = -1; 
        } 

        visited[src] = true; 
        node_dist[src] = 0; 
        queue.add(src); 
          while (!queue.isEmpty()) { 
            int u = queue.remove(); 
            for (int i = 0; i < adj.get(u).size(); i++) { 
                if (visited[adj.get(u).get(i)] == false) { 
                    visited[adj.get(u).get(i)] = true; 
                    node_dist[adj.get(u).get(i)] = node_dist[u] + 1; 
                    node_pre[adj.get(u).get(i)] = u; 
                    queue.add(adj.get(u).get(i)); 
                    if (adj.get(u).get(i) == dest) 
                        return true; 
                } 
            } 
        } 
        return false; 
    }
    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
        adj.get(j).add(i);
        adj.get(i).add(j);
    }
}
