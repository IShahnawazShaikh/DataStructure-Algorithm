package recursion_backtracking;

/**
 *  Time Complexity: O(N!*N) -> Generating N! permutation sequence, Adding the list to result. 
 *  
 *  Space Complexity: O(N!*N) -> result for storing N! arrays of length N.
 *  
 *  Use Case: https://leetcode.com/problems/permutations/
 * 
 */
import java.util.ArrayList;
import java.util.List;

public class Permutation {

	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> permute(int[] nums) {

		get(nums, 0);
		return result;
	}

	public void get(int[] nums, int idx) {
		if (idx == nums.length) {
			addArrayList(nums);
		}
		for (int i = idx; i < nums.length; i++) {
			nums[i] = (nums[i] + nums[idx]) - (nums[idx] = nums[i]); // swapping

			get(nums, idx + 1);

			nums[i] = (nums[i] + nums[idx]) - (nums[idx] = nums[i]); // swapping : making same data
		}
	}

	public void addArrayList(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++)
			list.add(nums[i]);
		result.add(list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
