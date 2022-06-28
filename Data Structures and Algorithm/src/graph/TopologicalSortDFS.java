package graph;

import java.util.ArrayList;
import java.util.Stack;

/***
 * 
 * @author Shahnawaz Shaikh
 * 
 *         Working:
 *         Topological sort 
 *         -> The linear ordering of nodes/vertices such that if there exists an edge between 2 nodes u,v then ‘u’ appears before ‘v’.
 *         -> Topological sort is not possible with cyclic graph, so Topological sort is also used to detect cycle in the graph.
 *         -> Topological Sort is not possible in Directed Graph
 *         
 *         Time Complexity: O(V+E) 
 *         Space Complexity: O(V) + O(V) O(V) -> Stack, answer Array, visited array
 *         
 *         Use Case: https://practice.geeksforgeeks.org/problems/topological-sort/1
 *
 */
public class TopologicalSortDFS {

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[V];
        boolean[] visited=new boolean[V]; 
         
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                dfs(adj,i,visited,stack);
            }
        } 
        int idx=0;
        while(!stack.isEmpty()) ans[idx++]=stack.pop();
       
        return ans;
         
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj,int src,boolean[] visited,Stack<Integer> stack){
        
        visited[src]=true;
        for(int des: adj.get(src)){
            if(visited[des]==false){
              dfs(adj,des,visited,stack);        
            }
        }
        stack.push(src);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
