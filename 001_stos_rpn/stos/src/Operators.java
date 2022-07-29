class Addition extends OperatorsAbstract {
    @Override
    public int calculate(Integer firstNumber, Integer secondNumber, String operator) {
        if (operator.equals("+")) {
            return secondNumber + firstNumber;
        } else {
            return this.nextOperator.calculate(firstNumber, secondNumber, operator);
        }
    }
}

class Substraction extends OperatorsAbstract {
    @Override
    public int calculate(Integer firstNumber, Integer secondNumber, String operator) {
        if (operator.equals("-")) {
            return secondNumber - firstNumber;
        } else {
            return this.nextOperator.calculate(firstNumber, secondNumber, operator);
        }
    }
}

class Multiplication extends OperatorsAbstract {
    @Override
    public int calculate(Integer firstNumber, Integer secondNumber, String operator) {
        if (operator.equals("*")) {
            return secondNumber * firstNumber;
        } else {
            return this.nextOperator.calculate(firstNumber, secondNumber, operator);
        }
    }
}

class Division extends OperatorsAbstract {
    @Override
    public int calculate(Integer firstNumber, Integer secondNumber, String operator) {
        if (operator.equals("/")) {
            return secondNumber / firstNumber;
        } else {
            return this.nextOperator.calculate(firstNumber, secondNumber, operator);
        }
    }
}