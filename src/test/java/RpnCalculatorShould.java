import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RpnCalculatorShould {

    private static final String INPUT_1 = "0";
    private static final String INPUT_2 = "2 3 4 5";
    private static final String INPUT_3 = "2 3 +";
    private static final String INPUT_4 = "20 5 /";
    private static final String INPUT_5 = "4 2 + 3 -";
    private static final String INPUT_6 = "3 5 8 * 7 + *";

    private static final int RESULT_1 = 0;
    private static final int RESULT_2 = 2345;
    private static final int RESULT_3 = 5;
    private static final int RESULT_4 = 4;
    private static final int RESULT_5 = 3;
    private static final int RESULT_6 = 141;

    private RpnCalculator rpnCalculator;

    @Before
    public void setUp() throws Exception {
        rpnCalculator = new RpnCalculator();
    }

    @Test
    public void return_same_number_if_no_operation() throws Exception {
        int result = rpnCalculator.calculate(INPUT_1);

        assertEquals(RESULT_1, result);
    }

    @Test
    public void return_the_number_when_sequence_is_sent() throws Exception {
        int result = rpnCalculator.calculate(INPUT_2);

        assertEquals(RESULT_2, result);
    }

    @Test
    public void return_the_result_of_the_operation_when_the_input_is_two_numbers_and_operation() throws Exception {
        int result = rpnCalculator.calculate(INPUT_4);

        assertEquals(RESULT_4, result);
    }

    @Test
    public void return_the_result_when_the_input_has_three_numbers_and_two_operations() throws Exception {
        int result = rpnCalculator.calculate(INPUT_5);

        assertEquals(RESULT_5, result);

    }

    @Test
    public void return_the_result_when_the_input_is_la_hostia() throws Exception {
        int result = rpnCalculator.calculate(INPUT_6);

        assertEquals(RESULT_6, result);

    }
}
