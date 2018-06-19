/**
170. Two Sum III - Data structure design

Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Example 1:

add(1); add(3); add(5);
find(4) -> true
find(7) -> false
Example 2:

add(3); add(1); add(2);
find(3) -> true
find(6) -> false
*/

// add O(1), find O(n). Space O(n)
class TwoSum {
    private List<Integer> list; 
    private HashMap<Integer, Integer> map; 

    /** Initialize your data structure here. */
    public TwoSum() {
        list = new ArrayList<Integer>(); 
        map = new HashMap<Integer, Integer>(); 
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number); 
        map.put(number, list.size() - 1); 
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(value - list.get(i)) && map.get(value - list.get(i)) != i) {
                return true; 
            }
        }
        return false; 
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */