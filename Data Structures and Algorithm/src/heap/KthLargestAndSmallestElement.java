package heap;

/**
 *  Working: getting Kth Largest and Smallest Element
 *  
 *  Space Complexity: O(K) + O(K) -> for minHeap and MaxHeap of size K.
 *  
 *  Time Complexity: O((N-K)LogK)) -> After inserting first N element we have to perform N-K remove and insert operation in worst case on the Queue of size K. 
 *  
 *  Use Case: https://www.codingninjas.com/codestudio/problems/kth-smallest-and-largest-element-of-array_1115488 
 */


import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargestAndSmallestElement {
	public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(getSmallestElement(arr, k));
		result.add(getLargestElement(arr, k));
		return result;
	}

	public static int getSmallestElement(ArrayList<Integer> list, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
		for (int i = 0; i < k; i++)
			maxHeap.offer(list.get(i));

		for (int i = k; i < list.size(); i++) {
			int val = list.get(i);
			if (val < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.offer(val);
			}
		}
		return maxHeap.peek();

	}

	public static int getLargestElement(ArrayList<Integer> list, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int i = 0; i < k; i++)
			minHeap.offer(list.get(i));
		for (int i = k; i < list.size(); i++) {
			int val = list.get(i);
			if (val > minHeap.peek()) {
				minHeap.poll();
				minHeap.offer(val);
			}
		}
		return minHeap.peek();
	}

	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<>();
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(2);
		System.out.println(kthSmallLarge(list,list.size(),3));
		
	}

}
