package data_structures.Stack;


/**
 *
 */
public class ArrayStackDemo {

}


class ArrayStack{
    int top=-1;
    int maxsize;
    int[] stack;

    public ArrayStack(int n){
        this.top = -1;
        this.maxsize = n;
        this.stack = new int[this.maxsize];
    }

    public boolean isFull(){
        return this.top==this.maxsize-1;
    }

    public boolean isEmpty(){
        return this.top==-1;
    }
}