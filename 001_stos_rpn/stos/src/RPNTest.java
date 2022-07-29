import org.junit.*;

import static org.junit.Assert.assertEquals;

public class RPNTest {
    @Test
    public void testCalculateEmptyExpression() {
        RPN rpn = new RPN.Builder().rpn("").operator(new Addition()).build();
        assertEquals("expression.calculate(), empty expression", java.util.Optional.of(0).get(), rpn.calculate());
    }

    @Test
    public void testCalculateExpressionWithOneNumber() {
        RPN rpn = new RPN.Builder().rpn("1").operator(new Addition()).build();
        assertEquals("expression.calculate(), expression with one number", java.util.Optional.of(1).get(), rpn.calculate());
    }

    @Test
    public void testCalculateExpressionWithAdding() {
        RPN rpn = new RPN.Builder().rpn("2 3 +").operator(new Addition()).build();
        assertEquals("expression.calculate(), expression with adding", java.util.Optional.of(5).get(), rpn.calculate());
    }

    @Test
    public void testCalculateExpressionWithMultiplying() {
        RPN rpn = new RPN.Builder().rpn("2 3 *").operator(new Multiplication()).build();
        assertEquals("expression.calculate(), expression with multiplying", java.util.Optional.of(6).get(), rpn.calculate());
    }

    @Test
    public void testCalculateExpressionWithDividing() {
        RPN rpn = new RPN.Builder().rpn("6 3 /").operator(new Division()).build();
        assertEquals("expression.calculate(), expression with dividing", java.util.Optional.of(2).get(), rpn.calculate());
    }

    @Test
    public void testCalculateExpressionWithSubtraction() {
        RPN rpn = new RPN.Builder().rpn("2 3 -").operator(new Substraction()).build();
        assertEquals("expression.calculate(), expression with subtraction", java.util.Optional.of(-1).get(), rpn.calculate());
    }

    @Test
    public void testCalculateExpressionWithAllOperations() {
        RPN rpn = new RPN.Builder().rpn("12 2 3 4 * 10 5 / + * +").operator(new Addition()).operator(new Multiplication()).operator(new Substraction()).operator(new Division()).build();
        assertEquals("expression.calculate(), expression with all operations", java.util.Optional.of(40).get(), rpn.calculate());
    }
}
