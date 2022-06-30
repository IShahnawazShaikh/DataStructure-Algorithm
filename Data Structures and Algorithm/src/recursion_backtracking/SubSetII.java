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
import java.util.Arrays;
import java.util.List;

public class SubSetII {
	public static List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		result.clear();
		result.add(new ArrayList<Integer>());
		subsetFunction(nums, 0, new ArrayList<Integer>());
		System.out.println(result);
		return result;

	}

	private static void subsetFunction(int[] ar, int index, ArrayList<Integer> list) {
		for (int i = index; i < ar.length; i++) {
			if (i > index && ar[i - 1] == ar[i])
				continue;
			list.add(ar[i]);
			result.add(new ArrayList<Integer>(list));
			subsetFunction(ar, i + 1, list);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		new SubSetII().subsetsWithDup(new int[] {1,2,3,3});

	}

}
