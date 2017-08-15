/**
384. Shuffle an Array

Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();

Solution: Reservoir sampling. Fisher-Yates Algorithm. 
*/

// O(n^2). Reservoir Sampling. 
public class Solution {
    private int[] org; 
    
    public Solution(int[] nums) {
        org = new int[nums.length]; 
        for (int i = 0; i < nums.length; i++) {
            org[i] = nums[i]; 
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return org; 
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = new int[org.length]; 
        List<Integer> list = new ArrayList<>(); 
        for (int i = 0; i < org.length; i++) {
            list.add(org[i]); 
        }
        for (int i = 0; i < org.length; i++) {
            res[i] = sampling(list); 
        }
        return res; 
    }
    
    private int sampling(List<Integer> list) {
        int count = 1; 
        int flag = list.get(0); 
        int pos = 0; 
        for (int i = 0; i < list.size(); i++) {
            if (Math.random() < 1.0 / count) {
                flag = list.get(i); 
                pos = i; 
            }
            count++; 
        }
        list.remove(pos); 
        return flag; 
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */


// O(n). Fisher-Yates Algorithm. 
public class Solution {
    private int[] org; 
    
    public Solution(int[] nums) {
        org = nums; 
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return org; 
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = org.clone(); 
        for (int i = 0; i < res.length - 1; i++) {
            int index = (int)(i + Math.random() * (res.length - 1 - i + 1)); 
            swap(res, i, index); 
        }
        return res; 
    }
    
    private void swap(int[] res, int index1, int index2) {
        int temp = res[index1]; 
        res[index1] = res[index2]; 
        res[index2] = temp; 
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */