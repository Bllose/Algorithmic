package bllose.mathematical;

import org.junit.Assert;
import org.junit.Test;

public class CalculationTest {
    Calculations calculations = new Calculations();

    @Test
    public void test(){
        Assert.assertEquals("0.2101101122", calculations.decimalToOther(0.795, 3));
    }
}
