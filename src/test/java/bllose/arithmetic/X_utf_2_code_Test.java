package bllose.arithmetic;

import org.junit.Assert;
import org.junit.Test;

public class X_utf_2_code_Test {

    @Test
    public void test(){
        Assert.assertEquals(21326,
                X_utf_2_code.encodingVerify("E58D8E"));
    }

    @Test
    public void test1(){
        Assert.assertEquals(36901,
                X_utf_2_code.encodingVerify("E980A5"));
    }
}
