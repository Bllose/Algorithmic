package bllose.arithmetic;

import org.junit.Assert;
import org.junit.Test;

public class StacksTest {

    Stacks stacks = new Stacks();

    @Test
    public void test(){
        Assert.assertEquals("ab(c)d", stacks.minRemoveToMakeValid("a)b(c)d"));
    }

    @Test
    public void test1(){
        Assert.assertEquals("", stacks.minRemoveToMakeValid("))(("));
    }
}
