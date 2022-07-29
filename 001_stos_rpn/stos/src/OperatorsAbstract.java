public abstract class OperatorsAbstract {
    OperatorsAbstract nextOperator;

    public void operatorHandler (OperatorsAbstract nextOperator) {
        this.nextOperator = nextOperator;
    }

    public abstract int calculate(Integer firstNumber, Integer secondNumber, String operator);
}
