package recursion_backtracking;

/***
 * 
 *  Working: Here we need to return all the unique Combination till Target.
 *  
 *  Time Complexity: O(N*2^Target) -> N times all the combination till target. 
 *  
 *  Space Complexity:  O(K*X) -> K is the average length of subset, X number of combination 
 *  
 *  Use Case: https://leetcode.com/problems/combination-sum-ii/
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		backtrack(candidates, 0, new ArrayList<Integer>(), target);
		System.out.println(result);
		return result;

	}

	public void backtrack(int[] nums, int idx, List<Integer> list, int k) {
		if (k == 0) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = idx; i < nums.length; i++) {

			if (i != idx && nums[i] == nums[i - 1])
				continue;

			if (k - nums[i] < 0)
				break;
			list.add(nums[i]);
			backtrack(nums, (i + 1), list, k - nums[i]);
			list.remove(list.size() - 1);

		}

	}

	public static void main(String[] args) {
		new CombinationSumII().combinationSum2(new int[] {2,2,3,6,7}, 7);

	}

}
