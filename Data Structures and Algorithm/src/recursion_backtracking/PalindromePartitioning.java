package recursion_backtracking;

/***
 * 
 * Time Complexity: O((2^n) *k*(n/2))
 * Reason: O(2^n) to generate every substring and O(n/2) to check if the substring generated is a palindrome.
 * O(k) is for inserting the palindromes in another data structure, where k  is the average length of the palindrome list.
 * 
 * Space Complexity: O(k * x)
 * k is the average length of the list of palindromes 
 * we have x such list of palindromes in our final answer. 
 * 
 * The depth of the recursion tree is n, so the auxiliary space required is equal to the O(n).
 * 
 *  Use Case: https://leetcode.com/problems/palindrome-partitioning/
 *  
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	 public List<List<String>> result=new ArrayList<>();
	    public List<List<String>> partition(String s) {  
	        backtrack(s,0,s.length(),new ArrayList<String> ());
	        //System.out.println(result);
	        return result;
	        
	    }
	    public void backtrack(String s,int idx,int n,List<String> list){
	        if(idx==n){
	           result.add(new ArrayList<String>(list));
	            return;
	        }
	        StringBuilder sb=new StringBuilder("");
	        for(int i=idx;i<n;i++){
	            sb.append(s.charAt(i));
	            if(isPalindrome(sb)){
	               list.add(sb.toString());
	                backtrack(s,i+1,n,list);
	                list.remove(list.size()-1);
	            }
	        }
	        
	    }
	    public boolean isPalindrome(StringBuilder sb){
	        int p1=0,p2=sb.length()-1;
	        while(p1<p2){
	            if(sb.charAt(p1)!=sb.charAt(p2)) return false;
	            p1+=1;
	            p2-=1;
	        }
	        return true;
	    }
	public static void main(String[] args) {
		new PalindromePartitioning().partition("aaa");
		

	}

}
