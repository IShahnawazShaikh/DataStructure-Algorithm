package recursion_backtracking;

import java.util.ArrayList;
import java.util.Collections;

/***
 * 
 * @author Shahnawaz Shaikh
 * 
 * 
 * Time Complexity:
 *  At every steps we are considering 2 options that is pick the element for sum or left the element for sum.
 *  so we have N elements and for every elements we have 2 choices therefore complexity.
 *  TC: O(2^N) + O(2^N log(2^N) -> For backtracking, for sorting.
 *  
 * Space Complexity: O(2^N) + O(2^N) -> for result array, Auxiliary space 
 * 
 * Use Case: https://practice.geeksforgeeks.org/problems/subset-sums2234/1
 */
public class SubsetsSum {

	ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {

		ArrayList<Integer> res = new ArrayList<Integer>();

		bactrack(arr, 0, N, res, 0);
		Collections.sort(res);
		return res;

	}

	void bactrack(ArrayList<Integer> arr, int idx, int n, ArrayList<Integer> res, int sum) {

		if (idx == n) {
			res.add(sum);
			return;
		}
		bactrack(arr, idx + 1, n, res, sum);
		bactrack(arr, idx + 1, n, res, sum + arr.get(idx));

	}

	public static void main(String[] args) {

	}

}
