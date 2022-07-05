package recursion_backtracking;

/**
 *  Working: https://takeuforward.org/data-structure/find-k-th-permutation-sequence/
 *  
 *  Time Complexity: O(N * N) -> Placing N numbers at N different position which is taking O(N) and O(N) for reducing size of List.
 *
 *  Space Complexity: O(N) for storing elements in List
 *  
 *  Use case: https://www.codingninjas.com/codestudio/problems/1112626
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthPermutationSequence {
/***   
	 Brute Force Solution
 *     Time complexity: O(N! * N) +O(N! Log N!)

       Reason:  The recursion takes O(N!)  time because we generate every possible permutation and another O(N)  time is required to make a deep copy and store every sequence in the data structure. Also, O(N! Log N!)  time required to sort the data structure

       Space complexity: O(N) Result stored in a vector, we are auxiliary space taken by recursion
	 
	 //  Code: 
	 List<String> result = new ArrayList<>();
	 public String getPermutation(int n, int k) {
		String s = "";
		for (int i = 1; i <= n; i++)
			s += i;
		get(s.toCharArray(), 0);
		Collections.sort(result);
		return result.get(k - 1);
	}
	public void get(char[] ch, int idx) {
		if (idx == ch.length) {

			String s = new String(ch);
			result.add(s);
			return;
		}
		for (int i = idx; i < ch.length; i++) {
			swap(ch, i, idx); // swapping
			get(ch, idx + 1);
			swap(ch, i, idx); // swapping : making same data
		}
	}
	public void swap(char[] ch, int i, int j) {

		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}
*/
	
	public static String kthPermutation(int n, int k) {

		int fact = 1;
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			fact *= i;
			list.add(i);
		}
		list.add(n);

		StringBuilder sb = new StringBuilder("");
		k = k - 1;
		while (true) {
			int index = k / fact; // getting position for current place.
			int nm = list.get(index);
			sb.append(nm);
			list.remove(index); // Removing Particular element from list
			if (list.size() == 0) // If no element is remaining
				break;
			k %= fact; // getting the sequence number for that position
			fact /= list.size(); // reducing to previous factorial.
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		System.out.println(kthPermutation(4, 24));

	}

}
