public class RpnCalculator {

    public static final String BLANK_SPACE = "\\s";

    public int calculate(String input) {

        int result;

        if (!containsOperation(input)) {

            input = input.replaceAll(BLANK_SPACE, "");

            result = Integer.parseInt(input);

        } else {

            String[] split = input.split(BLANK_SPACE);
            int opIndex = getIndexFirstOperation(split);
            result = Integer.parseInt(split[opIndex - 2]);

            for (int i = 0; i < split.length; i++) {
                if (isOperator(split[i])) {
                    result = operate(split[i],  result, Integer.parseInt(split[i - 1]));
                }
            }
        }


        return result;
    }

    private int getIndexFirstOperation(String[] input) {
        for (int i = 0; i < input.length; i++) {
            if(isOperator(input[i])){
                return i;
            }
        }
        return 0;
    }

    private boolean isOperator(String input) {
        return input.contains("+") || input.contains("-")
                || input.contains("*") || input.contains("/");
    }

    private int operate(String operator, int number1, int number2) {
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

    private boolean containsOperation(String input) {
        return input.contains("+") || input.contains("-")
                || input.contains("*") || input.contains("/");
    }
}
