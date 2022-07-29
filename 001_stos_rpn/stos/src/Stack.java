import java.util.Arrays;

public class Stack {

    private String[] stack;

    public Stack() {
        this.stack = new String[0];
    }

    public void push(String newElement) {
        this.stack = Arrays.copyOf(this.stack, this.stack.length + 1);
        this.stack[this.stack.length - 1] = newElement;
    }

    public String pop() {
        if (this.stack.length == 0) {
            return null;
        } else {
            String elementToReturn = this.stack[this.stack.length - 1];
            this.stack = Arrays.copyOf(this.stack, this.stack.length - 1);
            return elementToReturn;
        }
    }

    public String peek() {
        if (this.stack.length == 0) {
            return null;
        } else {
            return this.stack[this.stack.length - 1];
        }
    }

    public String[] get() {
        return this.stack;
    }
}