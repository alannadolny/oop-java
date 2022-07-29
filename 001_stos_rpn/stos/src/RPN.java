import java.util.Arrays;

public class RPN {
    private String RPN;
    private Stack stack = new Stack();
    private OperatorsAbstract[] operators;


    private int calculateExpression(Integer firstNumber, Integer secondNumber, String operator) {
        for (int i = 0; i < this.operators.length - 1; i++) {
            this.operators[i].operatorHandler(this.operators[i + 1]);
        }
        return this.operators[0].calculate(firstNumber, secondNumber, operator);
    }

    public Integer calculate() {
        if (this.RPN.equals("")) return 0;
        for (String el : this.RPN.split(" ")) {
            try {
                Integer.parseInt(el);
                this.stack.push(el);
            } catch (Exception err) {
                Integer first = Integer.parseInt(this.stack.pop());
                Integer second = Integer.parseInt(this.stack.pop());
                this.stack.push(String.valueOf(calculateExpression(first, second, el)));
            }
        }
        return Integer.parseInt(this.stack.peek());
    }

    public static final class Builder {
        private String RPN;
        private final Stack stack = new Stack();
        private OperatorsAbstract[] operators = new OperatorsAbstract[0];

        public Builder rpn(String RPN) {
            this.RPN = RPN;
            return this;
        }

        public Builder operator(OperatorsAbstract op) {
            this.operators = Arrays.copyOf(this.operators, this.operators.length + 1);
            this.operators[this.operators.length - 1] = op;

            return this;
        }

        public RPN build() {
            RPN rpn = new RPN();
            rpn.RPN = this.RPN;
            rpn.operators = this.operators;

            return rpn;
        }
    }
}
