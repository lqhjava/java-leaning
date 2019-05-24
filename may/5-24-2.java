import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        //只从stack1入
        if(!stack2.empty()){
            while(!stack2.empty()){
                stack1.push(stack2.pop());
            }
        }
        stack1.push(node);
    }
    
    public int pop() {
        //只从stack2出
        if (stack2.empty()){
            while(!stack1.empty()){
            stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
