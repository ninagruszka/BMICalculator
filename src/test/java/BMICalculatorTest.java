import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class BMICalculatorTest {

    private Object[] illegalValues(){
        return new Object[]{
                new Object[]{"80", "-180"},
                new Object[]{"0", "1.80"},
                new Object[]{"180", "190"},
        };
    }
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "illegalValues")
    public void constructTest(double weight, double height){
        new BMICalculator(weight, height);
    }



    private Object[] valuesBMI(){
        return new Object[]{
                new Object[]{"80", "1.80", "25"},
                new Object[]{"50", "1.80", "15"},
                new Object[]{"180", "1.90", "50"},
        };
    }
    @Test
    @Parameters(method = "valuesBMI")
    public void aDataGiven(double weight, double height, String expectedBMI){
        BMICalculator bmi = new BMICalculator(weight, height);
        assertEquals(expectedBMI, bmi.calculate());
    }

}
