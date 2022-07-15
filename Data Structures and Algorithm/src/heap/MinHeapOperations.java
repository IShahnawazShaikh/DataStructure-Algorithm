package heap;

import java.util.ArrayList;
import java.util.List;

/***
 * @author Shahnawaz Shaikh
 * 
 *  Operations on Heap
 *  
 *  1) Insertion: Inserting element in heap.
 *      Time Complexity for 1 insertion: O(LogN) -> N is the size of existing heap.
 *      
 *  2) extractMin/extractMax:
 *     Time Complexity: O(LogN) -> after extracting element do heapify to maintain heap property. 
 *  
 *  3) heapify: Process to rearrange heap to maintain heap property.
 *     Time Complexity: O(LogN).
 *     
 *  4) delete: delete Item from heap.
 *      Time Complexity: O(LogN) -> after deleting do heapify to maintain heap property.
 */
public class MinHeapOperations {

	 static List<Integer> heap=new ArrayList<Integer>();
	 
	static void insert(int val) {
		heap.add(val);
		int idx = heap.size() - 1;
		while (idx > 0 && heap.get((idx - 1) / 2) > heap.get(idx)) {
			swap(idx, (idx - 1) / 2);
			idx = (idx - 1) / 2;
		}
	}
	
	static int extractMin() {
		if(heap.size()==0) return Integer.MIN_VALUE;
		int ans=heap.get(0);
		swap(0,heap.size()-1);
		heap.remove(heap.size()-1);
		heapify(0);
		return ans;
	}
	static void delete(int index) {
		
		/***
		 *  To Delete an element from heap we perform the following operation.
		 *   i)  decreaseKey(index,-1)
		 *   ii) swap(index,0)
		 *   iii) call -> extractMin()
		 */
		
		
		if(index>=heap.size()) return;
		
		heap.set(index, -1);
		
		swap(index,0);
		
		extractMin();
		
	}
	
	static void heapify(int curr) {
		int n = heap.size();
		int left = 2 * curr + 1;
		int right = 2 * curr + 2;

		int mn = curr;
		if (left < n && heap.get(left) < heap.get(mn))
			mn = left;

		if (right < n && heap.get(right) < heap.get(mn))
			mn = right;

		if (curr != mn) {
			swap(curr, mn);
			heapify(mn);
		}

	}
	static void swap(int i, int j) {
		int temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
	public static void main(String[] args) {
		insert(6);
		insert(5);
		System.out.println(extractMin());
		insert(8);
		insert(10);
		insert(11);
		insert(12);
		insert(13);
		insert(14);
		insert(15);
		insert(16);
		System.out.println(heap);
		
		delete(4);
		System.out.println(heap);

	}

}
