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

public class MaxHeap {

	static List<Integer> maxHeap(int n, int[][] q) {
		List<Integer> heap = new ArrayList<>();
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < n; i++)
			if (q[i][0] == 0) {
				insert(heap, q[i][1]);
			} else {
				int max = heap.get(0);
				result.add(max);
				swap(heap, 0, heap.size() - 1);
				heap.remove(heap.size() - 1);
				heapify(heap, 0);
			}
		System.out.println(heap);
		return result;
	}

	static void heapify(List<Integer> heap, int curr) {

		int left = curr * 2 + 1;
		int right = curr * 2 + 2;
		int mx = curr;
		if (left < heap.size() && heap.get(left) > heap.get(mx))
			mx = left;
		if (right < heap.size() && heap.get(right) > heap.get(mx))
			mx = right;

		if (curr != mx) {
			swap(heap, mx, curr);
			heapify(heap, mx);
		}

	}

	static void insert(List<Integer> heap, int val) {

		heap.add(val);
		int idx = heap.size() - 1;
		while (idx > 0 && heap.get(idx) > heap.get((idx - 1) / 2)) {
			swap(heap, idx, (idx - 1) / 2);
			idx = (idx - 1) / 2;
		}
	}

	static void swap(List<Integer> heap, int i, int j) {
		int temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}

	public static void main(String[] args) {
		int[][] q = { { 0, 9 }, { 0, 8 }, { 0, 20 }, { 1, -1 }, { 0, 5 }, { 0, 19 }, { 1, -1 } };
		List<Integer> result = maxHeap(q.length, q);
		System.out.println(result);
	}

}
