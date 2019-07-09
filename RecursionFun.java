/**
 * Complete the seven methods methods in this file using recursion, no loops. 
 * Also complete these three methods inside LinkedList<E>:
 *   get(int)
 *   removeAll(E)
 *   duplicateAll(E)
 *   
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 *   findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will
 * be using this same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Atom Mingle
 */
public class RecursionFun {

  // Complete recursive method combinations that returns from n choose k.
  // This method is described in 17_SimpleRecursion.pptx.
  public int combinations(int n, int k) {
	  if(k == 1) {
		  return n;
	  }
	  if (k == n) {
		  return 1;
	  }
	  else {
		  return combinations(n-1, k-1) + combinations(n-1, k);
	  }
  }

 
  // Complete recursive method intWithCommas that returns the argument as a String
  // with commas in the correct places.
  //
  // intWithCommas(999) returns "999"
  // intWithCommas(1234) returns "1,234"
  // intWithCommas(1007) returns "1,007"
  // intWithCommas(1023004567) returns "1,023,004,567"
  //
  // Precondition: n >= 0
  public String intWithCommas(int n) {
    if(n < 1000) {
    	return Integer.toString(n);
    }
    else {
    	if(n % 1000 < 10) {
    		return intWithCommas(n / 1000) + ",00" + intWithCommas(n % 1000);
    	}
    	if(n % 1000 < 100) {
    		return intWithCommas(n / 1000) + ",0" + intWithCommas(n % 1000);
    	}
    	else {
    		return intWithCommas(n / 1000) + "," + intWithCommas(n % 1000);
    	}
    }
    
    
    
  }

  // Write recursive method reverseArray that reverses the array elements in a
  // filled array of ints. Use recursion; do not use a loop. The following
  // assertions must pass:
  //
  // int[] a = { 2, 4, 6 };
  // rf.reverseArray(a);
  // assertEquals(6, a[0]);
  // assertEquals(4, a[1]);
  // assertEquals(2, a[2]);
  //
  // Precondition: x.length > 0
  public void reverseArray(int[] x) {
    reverseArray(x, 0, x.length);
  }

  private void reverseArray(int[] x, int index, int len) {
    int temp = 0;
    if(index == len / 2) {
    	return;
    }
    else {
    	temp = x[index];
    	x[index] = x[len - 1 - index];
    	x[len - 1 - index] = temp;
    	reverseArray(x, index + 1, len);
    }
  }

  // Write recursive method arrayRange that returns the maximum
  // integer minus the minimum integer in the filled array of 
  // integers, Use recursion; do not use a loop. 
  // Precondition: a.length > 0
  public int arrayRange(int[] a) {
	  int min = findMin(a,0, Integer.MAX_VALUE);
	  int max = findMax(a,0, Integer.MIN_VALUE);
    return max - min;
  }

  private int findMax(int[] a, int index, int max){
	  if(index == a.length) {
		  return max;
	  }
	  else if (a[index] > max) {
		  max = a[index];
	  }
	  return findMax(a, index + 1, max);
  }
  
  private int findMin(int[] a, int index, int min) {
	  if(index == a.length) {
		  return min;
	  }
	  else if (a[index] < min) {
		  min = a[index];
	  }
	  return findMin(a, index + 1, min);
  }
  // Return true if nums has all int elements in ascending order.
  // If not isSorted, return false.
  public boolean isSorted(int[] nums) {
	  
    return compareTwo(nums, 0);
  }
  
  private boolean compareTwo(int[] nums, int index) {
	  if(index >= nums.length - 1) {
		  return true;
	  }
	  return nums[index] <= nums[index + 1] && compareTwo(nums, index + 1);
  }

  // Complete method found to return true if search is found in strs.
  // If not found, return false. Use equals, not ==.
  public boolean found(String search, String[] strs) {
     return found(search, strs, 0);
  }
  private boolean found(String search, String[] strs, int index) {
	  if(index == strs.length) {
		  return false;
	  }
	  if(strs[index].equals(search)) {
		  return true;
	  }
	  else {
		  return found(search, strs, index + 1);
	  }
  }
}
