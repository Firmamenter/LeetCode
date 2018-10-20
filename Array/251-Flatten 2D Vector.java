/**
251. Flatten 2D Vector

Implement an iterator to flatten a 2d vector.

Example:

Input: 2d vector =
[
  [1,2],
  [3],
  [4,5,6]
]
Output: [1,2,3,4,5,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,2,3,4,5,6].
Follow up:
As an added challenge, try to code it using only iterators in C++ or iterators in Java.

Sol: 
*/

public class Vector2D implements Iterator<Integer> {
    private List<List<Integer>> input; 
    private List<Integer> output; 
    private int idxIn; 
    private int idxOut; 
    
    public Vector2D(List<List<Integer>> vec2d) {
        idxIn = 0;
        idxOut = 0; 
        input = vec2d; 
        output = new ArrayList<Integer>(); 
    }

    @Override
    public Integer next() {
        return output.get(idxOut++); 
    }

    @Override
    public boolean hasNext() {
        while (idxOut >= output.size()) {
            if (idxIn >= input.size()) {
                return false; 
            }
            output = input.get(idxIn++); 
            idxOut = 0; 
        }
        return true; 
    }
}

public class Vector2D implements Iterator<Integer> {
    private List<List<Integer>> input; 
    private List<Integer> output; 
    private Iterator idxIn; 
    private Iterator idxOut; 
    
    public Vector2D(List<List<Integer>> vec2d) {
        input = vec2d; 
        idxIn = input.iterator(); 
        output = new ArrayList<Integer>(); 
        idxOut = output.iterator(); 
    }

    @Override
    public Integer next() {
        return (Integer)idxOut.next(); 
    }

    @Override
    public boolean hasNext() {
        while (!idxOut.hasNext()) {
            if (!idxIn.hasNext()) {
                return false; 
            }
            output = (List<Integer>)idxIn.next(); 
            idxOut = output.iterator(); 
        }
        return true; 
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */