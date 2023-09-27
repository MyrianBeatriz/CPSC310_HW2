package edu.trinity;

import java.util.EmptyStackException;
import java.util.Stack;

public class RPNCalculator {
    public static double evaluate(String expr) {
        Stack<Double> operandStack = new Stack<>();
        String[] arrayOfTokens = expr.split(" ");
        for (int i = 0; i < arrayOfTokens.length; i++) {
            String token = arrayOfTokens[i];
            if (isOperator(token)) {
                if (operandStack.size() < 2) {
                    throw new EmptyStackException();
                }
                double operand2 = operandStack.pop();
                double operand1 = operandStack.pop();
                if(token.equals("/") && operand2==0) {
                        throw new IllegalArgumentException("Cannot be divided by zero");
                }
                double result = performOperation(token, operand1, operand2);
                operandStack.push(result);
            } else {
                try {
                    double operand = Double.parseDouble(token);
                    operandStack.push(operand);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid operand");
                }
            }
        }

        while(operandStack.size()>1){
            operandStack.pop();
        }
        if (operandStack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }
        return operandStack.pop();
    }

    /**
     * The isOperator method checks whether a token is an operator and returns a boolean value
     *
     * @param String token
     * @return boolean
     */
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    /**
     * performOperation method identifies the correct operation to be executed.
     *
     * @param String       opr
     * @param operandStack
     * @return Double result
     */

    private static Double performOperation(String operator, double operand1, double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Cannot be divided by zero");
                }
                return operand1 / operand2;
            default:
                 throw new IllegalArgumentException("Invalid operator");
        }
    }
}
