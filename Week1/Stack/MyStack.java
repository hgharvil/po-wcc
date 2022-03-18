import java.util.IllegalFormatFlagsException;

/*
Implement a stack that has the following methods:
• push ( val ) : push val onto the stack
• pop: pop off and return the topmost element of the stack. If there are no elements in the stack, throw an error.
• max: return the maximum value in the stack currently. If there are no elements in the stack, throw an error. 
*/
public class MyStack {
    private int[] stackArray;
    private int top;
    private int capacity;

    public MyStack(int size){
        stackArray = new int[size];
        this.capacity = size;
        top = -1;
    }

    public void push(int value){
        if(!isFull()){
            stackArray[++top] = value;
        }else{
            throw new NullPointerException();
        }
    }

    public int pop(){
        if(!isEmpty()){
            return stackArray[top--];
        }else{
            throw new NullPointerException();
        }
    }

    public int max(){
        if(!isEmpty()){
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < stackArray.length; i++){
                if(stackArray[i] > max) max = stackArray[i];
            }
            return max;
            
        }else{
            throw new NullPointerException();
        }
    }

    public int size(){
        return top + 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == capacity -1;
    }


    public static void main(String[] args) {
        MyStack sta = new MyStack(5);
        sta.push(1);
        sta.push(999999);
        sta.push(3);
        sta.push(4);
        sta.push(sta.pop());
        sta.pop();
        sta.push(8888);
        System.out.println(sta.max());
        
    }
}
