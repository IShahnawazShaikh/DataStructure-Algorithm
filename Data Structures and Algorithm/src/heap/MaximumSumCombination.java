package heap;

/** 
 * 
 *  Working: Finding the maximum K sum from the combination of array.
 *  
 *  Time Complexity: O(NLogN) + O(NlogN) +O(K*(LogN + LogN + logN)) ->  for sorting A, for sorting B, for K time poll and then 2 time insertion in worst case 
 *  
 *  SpaceComplexity: O(K) + O(N)  + O(N) -> answer array, for Heap, for Set<String>   
 *  
 *  Use Case: https://www.interviewbit.com/problems/maximum-sum-combinations/
 *  
 * 
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MaximumSumCombination {
    public int[] solve(int[] A, int[] B, int k) {
        
        PriorityQueue<Pair> maxHeap=new PriorityQueue<>((p1,p2)->p2.sum-p1.sum);
        Arrays.sort(A);
        Arrays.sort(B);
        
        int n=A.length;
        int[] ans=new int[k];
        
        int sum=A[n-1]+B[n-1];
        Set<String> set=new HashSet<>();
        maxHeap.offer(new Pair(sum,n-1,n-1));
        set.add(""+(n-1)+" "+(n-1));    // Adding index to not to add same sum again
        int idx=0;
        while(idx<k){
            Pair p=maxHeap.poll();
            ans[idx]=p.sum;
            if(set.contains(""+(p.i)+" "+(p.j-1))==false){
              maxHeap.offer(new Pair(A[p.i]+B[p.j-1],p.i,p.j-1));
              set.add(""+(p.i)+" "+(p.j-1));
            }
            if(set.contains(""+(p.i-1)+" "+(p.j))==false){
              maxHeap.offer(new Pair(A[p.i-1]+B[p.j],p.i-1,p.j));
              set.add(""+(p.i-1)+" "+(p.j));
            }
            idx+=1;
        }
        
        return ans;
        
    }
    static class Pair{
        int sum,i,j;
        Pair(int sum,int i,int j){
           this.sum=sum;
           this.i=i;
           this.j=j; 
        }
    }
}