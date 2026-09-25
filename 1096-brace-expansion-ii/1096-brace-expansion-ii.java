import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Stack<Set<String>> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Insert implicit concatenation operator '*' if needed
            if (i > 0) {
                char prev = expression.charAt(i - 1);
                if ((Character.isLetter(prev) || prev == '}') && (Character.isLetter(c) || c == '{')) {
                    while (!operatorStack.isEmpty() && operatorStack.peek() == '*') {
                        evaluate(operandStack, operatorStack);
                    }
                    operatorStack.push('*');
                }
            }

            if (Character.isLetter(c)) {
                Set<String> set = new HashSet<>();
                set.add(String.valueOf(c));
                operandStack.push(set);
            } else if (c == '{') {
                operatorStack.push('{');
            } else if (c == ',') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '{') {
                    evaluate(operandStack, operatorStack);
                }
                operatorStack.push(',');
            } else if (c == '}') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '{') {
                    evaluate(operandStack, operatorStack);
                }
                operatorStack.pop(); // Pop '{'
            }
        }

        while (!operatorStack.isEmpty()) {
            evaluate(operandStack, operatorStack);
        }

        // Collect and sort the final result set
        List<String> result = new ArrayList<>(operandStack.pop());
        Collections.sort(result);
        return result;
    }

    private void evaluate(Stack<Set<String>> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        Set<String> set2 = operandStack.pop();
        Set<String> set1 = operandStack.pop();
        Set<String> resultSet = new HashSet<>();

        if (op == '*') { // Cartesian Product
            for (String s1 : set1) {
                for (String s2 : set2) {
                    resultSet.add(s1 + s2);
                }
            }
        } else if (op == ',') { // Union
            resultSet.addAll(set1);
            resultSet.addAll(set2);
        }

        operandStack.push(resultSet);
    }
}