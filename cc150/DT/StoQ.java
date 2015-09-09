public class StoQ {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Solution() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        stack1.push(element);
    }

    //s1 to s2, then pop the top element from s2, and then push everything back to s1
    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    // s1 to s2, then pop the top element from s2, and then save it back to s1, then push everything
    // back to s1
    public int top() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        stack1.push(result);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}

