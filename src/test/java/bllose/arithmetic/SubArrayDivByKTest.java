package bllose.arithmetic;

import org.junit.Assert;
import org.junit.Test;

public class SubArrayDivByKTest {

    @Test
    public void test(){
        Assert.assertEquals(7,
                SubArrayDivByK.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
    }

}
