package recursion_backtracking;

/***
 * 
 *  Working: Here we need to return all the unique Combination till Target, We can use same element any number of times
 *  
 *  Time Complexity: O(N*2^Target) -> N times all the combination till target. 
 *  
 *  Space Complexity:  O(K*X) -> K is the average length of subset, X number of combination 
 *  
 *  Use Case: https://leetcode.com/problems/combination-sum/
 * 
 */



import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	List<List<Integer>>  result=new ArrayList<>();
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		   backtrack(candidates,0,new ArrayList<Integer>(),target);
		   System.out.println(result);
	       return result;  
	
		}
	
	
	/******************* Way-01 ***************************/
	public void backtrack(int[] nums,int idx,List<Integer> list,int k){

		if (k == 0) {
			result.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = idx; i < nums.length; i++) {
			if (k - nums[i] >= 0) {
				list.add(nums[i]);
				backtrack(nums, i, list,k - nums[i]);
				list.remove(list.size() - 1);
			}
		}

	}
	
	/******************* Way-02 **************************
    public void backtrack(int[] nums,int idx,List<Integer> list,int k){
        
        if(k<0 || idx>=nums.length) return;
        
        if(k==0){
            result.add(new ArrayList<Integer>(list));
            return;
            
        }
         
        list.add(nums[idx]);
        backtrack(nums,idx,list,k-nums[idx]);
        
        list.remove(list.size()-1); 
        backtrack(nums,idx+1,list,k); 
         
         
     }
	*/
	/******************* Way-03 **************************
    public void backtrack(int[] nums,int idx,List<Integer> list,int k){
        
        if(k<0) return; 
        if(k==0){
            result.add(new ArrayList<Integer>(list));
            return;
        } 
         
        for(int i=idx;i<nums.length;i++){
            
            list.add(nums[i]);
            backtrack(nums,i,list,k-nums[i]);
            list.remove(list.size()-1);
        }  
     }
     */
	public static void main(String[] args) {
		new CombinationSum().combinationSum(new int[] {2,3,6,7}, 7);

	}

}
