public class MinStack {

    private Stack<Integer> stack1;    
    private Stack<Integer> minstack;
    
    // note: to keep the min number at the front, use two stacks to implement
    // push: when the min stack is empty or pushed num < minstack first element, push the num into stack and minstack
    // pop: when poped the number is also the first element of the minstack, pop the number from both stacks
    // min: return minstack.peek()
    public Solution() {
        stack1 = new Stack<Integer>();
        minstack = new Stack<Integer>();
    }

    public void push(int number) {
        stack1.push(number);
        if(minstack.isEmpty() || number <= minstack.peek()){
            minstack.push(number);
        }
    }

    public int pop() {
       int result =  stack1.peek();
       if(minstack.peek() == result){
           minstack.pop();
       }
       return stack1.pop();
    }

    public int min() {
        return minstack.peek();
    }
}