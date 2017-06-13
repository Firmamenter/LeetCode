/**
225. Implement Stack using Queues

Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

Solution: O(n) push, other operations are O(1). 
*/

//My version.
public class MyStack {
    private Queue<Integer> queue1; 
    private Queue<Integer> queue2; 

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<Integer>(); 
        queue2 = new LinkedList<Integer>(); 
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue1.offer(x); 
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll()); 
            }
        } else {
            queue2.offer(x); 
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll()); 
            }
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (queue1.isEmpty()) {
            return queue2.poll(); 
        } else {
            return queue1.poll(); 
        }
    }
    
    /** Get the top element. */
    public int top() {
       if (queue1.isEmpty()) {
            return queue2.peek(); 
        } else {
            return queue1.peek(); 
        }
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty(); 
    }
}

//Simplified version.
public class MyStack {
    private Queue<Integer> queue; 

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>(); 
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        int size = queue.size(); 
        queue.offer(x); 
        while (size > 0) {
            queue.offer(queue.poll()); 
            size--; 
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll(); 
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek(); 
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty(); 
    }
}

//Simulating LinkedList O(1) time complexity.
public class MyStack {
    private Queue queue; 

    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        Queue q = new LinkedList(); 
        q.offer(x); 
        q.offer(queue); 
        queue = q; 
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int res = (int) queue.poll(); 
        queue = (Queue) queue.peek(); 
        return res; 
    }
    
    /** Get the top element. */
    public int top() {
        return (int) queue.peek(); 
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue == null; 
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */