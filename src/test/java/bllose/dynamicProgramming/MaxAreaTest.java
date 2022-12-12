package bllose.dynamicProgramming;

import org.junit.Assert;
import org.junit.Test;

public class MaxAreaTest {
    MaxArea ma = new MaxArea();

    @Test
    public void test(){
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        Assert.assertEquals(49, ma.maxArea(height));
    }
}
