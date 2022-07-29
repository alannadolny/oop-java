import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StackTest {
    @Test
    public void testAddElementToEmptyStos(){
        Stack stack = new Stack();
        stack.push("new");
        String[] result = { "new" };
        assertEquals("stos.push(new)", result, stack.get());
    }
    @Test
    public void testAddElementToNotEmptyStos(){
        Stack stack = new Stack();
        stack.push("new");
        stack.push("new2");
        String[] result = { "new", "new2" };
        assertEquals("stos.push(new, new2)", result, stack.get());
    }
    @Test
    public void testPopElementFromEmptyStos(){
        Stack stack = new Stack();
        assertNull("stos.pop() from empty stack", stack.pop());
    }
    @Test
    public void testPopElementFromNotEmptyStos(){
        Stack stack = new Stack();
        stack.push("new");
        assertEquals("stos.pop() from not empty stack", "new", stack.pop());
    }
    @Test
    public void testPeekElementFromEmptyStos() {
        Stack stack = new Stack();
        assertNull("stos.peek() from empty stack", stack.peek());
    }
    @Test
    public void testPeekFromElementFromNotEmptyStos() {
        Stack stack = new Stack();
        stack.push("new");
        assertEquals("stos.peek() from not empty stack", "new", stack.peek());
    }
    @Test
    public void testArrayLengthAfterPushes() {
        Stack stack = new Stack();
        stack.push("new");
        stack.push("new2");
        assertEquals("stos.get().length after pushes", 2, stack.get().length);
    }
    @Test
    public void testArrayLengthAfterPop() {
        Stack stack = new Stack();
        stack.push("new");
        stack.push("new2");
        stack.pop();
        assertEquals("stos.get().length after pop", 1, stack.get().length);
    }
    @Test
    public void testArrayLengthAfterPeek() {
        Stack stack = new Stack();
        stack.push("new");
        stack.push("new2");
        stack.peek();
        assertEquals("stos.get().length after peek", 2, stack.get().length);
    }
}
