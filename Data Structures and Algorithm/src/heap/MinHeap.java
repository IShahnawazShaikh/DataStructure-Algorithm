package heap;
/***
 * 
 *  Working : Heap is Tree based Data Structure in which Tree is a complete Binary Tree.
 *   In MinHeap the root node must be smaller than the children and left and right subtree should also satisfy the condition.
 *   In MaxHeap the root node must be greater than the children and left and right subtree should also satisfy the condition
 * 
 *  Time Complexity: O(NlogN) -> Inserting N elements or getting N elements from heap, in each case heap should satisfy condition. 
 *  
 *  Space Complexity: O(N) + O(N) + O(LogN) -> Heap array, result array, for recursive heapify(). 
 *  
 *  Use case: https://www.codingninjas.com/codestudio/problems/min-heap_4691801
 * 
 */
import java.util.ArrayList;
import java.util.List;

public class MinHeap {
	
	static int[] minHeap(int n, int[][] q) {
		List<Integer> heap = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++)
			if (q[i][0] == 0) {
				insert(heap, q[i][1]);
			} else {
				result.add(heap.get(0));
				swap(heap, 0, heap.size() - 1);
				heap.remove(heap.size() - 1);
				heapify(heap, 0);
			}
		int[] ans = new int[result.size()];
		int idx = 0;
		for (int x : result)
			ans[idx++] = x;
		return ans;
	}

	static void insert(List<Integer> heap, int x) {
		heap.add(x);
		int idx = heap.size() - 1;
		while (idx > 0 && heap.get((idx - 1) / 2) > heap.get(idx)) {
			swap(heap, idx, (idx - 1) / 2);
			idx = (idx - 1) / 2;
		}
	}

	static void heapify(List<Integer> heap, int curr) {
		int n = heap.size();
		int left = 2 * curr + 1;
		int right = 2 * curr + 2;

		int mn = curr;
		if (left < n && heap.get(left) < heap.get(mn))
			mn = left;

		if (right < n && heap.get(right) < heap.get(mn))
			mn = right;

		if (curr != mn) {
			swap(heap, curr, mn);
			heapify(heap, mn);
		}

	}
	static void swap(List<Integer> heap, int i, int j) {
		int temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}

	public static void main(String[] args) {
		
		
		

	}

}
