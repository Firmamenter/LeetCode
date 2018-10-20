/**
324. Wiggle Sort II

Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].
Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?

Sol: Quick Selection + ... O(N) time and O(N) space.
*/
// Naive Solution O(nlogn) time and O(n) space
class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return; 
        }
        Arrays.sort(nums); 
        int len = nums.length; 
        int mid = nums[(len - 1) / 2]; 
        Integer[] temp = new Integer[len]; 
        int oddIdx = 1; 
        int evenIdx = len % 2 != 0 ? len - 1 : len - 2; 
        for (int i = 0; i < len; i++) {
            if (nums[i] < mid) {
                temp[evenIdx] = nums[i]; 
                evenIdx -= 2; 
            } else if (nums[i] > mid) {
                temp[oddIdx] = nums[i]; 
                oddIdx += 2; 
            }
        }
        for (int i = 0; i < len; i++) {
            if (temp[i] == null) {
                nums[i] = mid; 
            } else {
                nums[i] = temp[i]; 
            }
        }
    }
}

// Partition was prepared for O(1) space but not used here
class Solution {
    public void wiggleSort(int[] nums) {
        int mid = quickSelect(nums, 0, nums.length - 1, (nums.length + 1) / 2); 
        partition(nums, mid); 
        sort(nums, mid); 
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start > end) {
            return -1; 
        }
        int idx = start; 
        int pivot = nums[start]; 
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < pivot) {
                swap(nums, ++idx, i); 
            }
        }
        swap(nums, start, idx); 
        if (idx - start + 1 == k) {
            return nums[idx]; 
        } else if (idx - start + 1 > k) {
            return quickSelect(nums, start, idx - 1, k); 
        } else {
            return quickSelect(nums, idx + 1, end, k - idx + start - 1); 
        }
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left]; 
        nums[left] = nums[right]; 
        nums[right] = temp; 
    }
    
    private void partition(int[] nums, int mid) {
        int pivot = mid; 
        int idx = -1; 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= pivot) {
                swap(nums, ++idx, i); 
            }
        }
    }
    
    private void sort(int[] nums, int mid) {
        Integer[] res = new Integer[nums.length]; 
        int oddIdx = 1; 
        int evenIdx = nums.length % 2 != 0 ? nums.length - 1 : nums.length - 2; 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mid) {
                res[oddIdx] = nums[i]; 
                oddIdx += 2; 
            } else if (nums[i] < mid) {
                res[evenIdx] = nums[i]; 
                evenIdx -= 2; 
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (res[i] == null) {
                nums[i] = mid; 
            } else {
                nums[i] = res[i]; 
            }
        }
    }
}

// No partition
class Solution {
    public void wiggleSort(int[] nums) {
        int mid = quickSelect(nums, 0, nums.length - 1, (nums.length + 1) / 2); 
        sort(nums, mid); 
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start > end) {
            return -1; 
        }
        int idx = start; 
        int pivot = nums[start]; 
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < pivot) {
                swap(nums, ++idx, i); 
            }
        }
        swap(nums, start, idx); 
        if (idx - start + 1 == k) {
            return nums[idx]; 
        } else if (idx - start + 1 > k) {
            return quickSelect(nums, start, idx - 1, k); 
        } else {
            return quickSelect(nums, idx + 1, end, k - idx + start - 1); 
        }
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left]; 
        nums[left] = nums[right]; 
        nums[right] = temp; 
    }
    
    private void sort(int[] nums, int mid) {
        Integer[] res = new Integer[nums.length]; 
        int oddIdx = 1; 
        int evenIdx = nums.length % 2 != 0 ? nums.length - 1 : nums.length - 2; 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mid) {
                res[oddIdx] = nums[i]; 
                oddIdx += 2; 
            } else if (nums[i] < mid) {
                res[evenIdx] = nums[i]; 
                evenIdx -= 2; 
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (res[i] == null) {
                nums[i] = mid; 
            } else {
                nums[i] = res[i]; 
            }
        }
    }
}