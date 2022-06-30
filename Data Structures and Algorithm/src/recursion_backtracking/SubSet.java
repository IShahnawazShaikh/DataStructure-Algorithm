package recursion_backtracking;

/***
 *   Working: Generating All unique subsets for given array.
 * 
 *   Time Complexity: O(N*2^N) -> 2^N for generating every subset and O(N) for adding every subset in the Data Structure (result)
 *   
 *   Space Complexity: O(2^N * K) -> Result list, every subset (list).
 *    O(N) Auxiliary Space for the recursion because the tree depth would be only N if you draw memory.
 * 
 *   Use Case: https://leetcode.com/problems/subsets-ii/
 *   
 */


import java.util.ArrayList;
import java.util.List;

public class SubSet {

	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {

		List<Integer> list = new ArrayList<Integer>();
		result.add(list);
		backtrack(nums, 0, list);
		//System.out.println(result);
		return result;
	}

	public void backtrack(int[] nums, int idx, List<Integer> list) {

		for (int i = idx; i < nums.length; i++) {
			list.add(nums[i]);
			result.add(new ArrayList<Integer>(list));
			backtrack(nums, i + 1, list);
			list.remove(list.size() - 1);

		}
	}

	public static void main(String[] args) {
		
		new SubSet().subsets(new int[] {1,2,3});

	}

}
