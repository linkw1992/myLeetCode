//
// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//
// push(x) -- Push element x onto stack.
//
//
// pop() -- Removes the element on top of the stack.
//
//
// top() -- Get the top element.
//
//
// getMin() -- Retrieve the minimum element in the stack.
//
//
//
//
// Example:
//
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> Returns -3.
// minStack.pop();
// minStack.top();      --> Returns 0.
// minStack.getMin();   --> Returns -2.
//
//


class MinStack {
    int min=Integer.MAX_VALUE;
    Stack<Integer> s=new Stack<Integer>();

    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {//保证当最小值在最上面时，倒数第二是第二上面；其他情况正常加
        if(x<=min){
            s.push(min);
            min=x;
        }
        s.push(x);
    }
    
    public void pop() {//最小值在最上面时连第二小都去掉并赋值
        if(s.pop()==min)min=s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
