public class RpnCalculator {

    private static final String BLANK_SPACE = "\\s";

    public int calculate(String input) {

        int result;

        if (!isOperator(input)) {

            input = input.replaceAll(BLANK_SPACE, "");

            result = Integer.parseInt(input);

        } else {

            String[] inputs = input.split(BLANK_SPACE);

            result = getFirstNumberToOperate(inputs);

            for (int i = 0; i < inputs.length; i++) {

                if (i == 0 && isOperator(inputs[i])) {
                    result = operate(result, inputs[i], Integer.parseInt(inputs[i - 1]));
                } else {
                    if (isOperator(inputs[i]) && !isOperator(inputs[i - 1])) {
                        result = operate(result, inputs[i], Integer.parseInt(inputs[i - 1]));
                    } else if (isOperator(inputs[i])) {
                        result = operate(result, inputs[i], Integer.parseInt(inputs[0]));
                    }
                }
            }
        }

        return result;
    }

    private int getIndexFirstOperation(String[] input) {
        for (int i = 0; i < input.length; i++) {
            if (isOperator(input[i])) {
                return i;
            }
        }
        return 0;
    }

    private int getFirstNumberToOperate(String[] inputs) {

        int opIndex = getIndexFirstOperation(inputs);
        return Integer.parseInt(inputs[opIndex - 2]);
    }

    private boolean isOperator(String input) {
        return input.contains("+") || input.contains("-")
                || input.contains("*") || input.contains("/");
    }

    private int operate(int number1, String operator, int number2) {
        int result;
        switch (operator.charAt(0)) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
            default:
                result = 0;
                break;

        }
        return result;
    }

}
