package bllose.greedy;

import org.junit.Assert;
import org.junit.Test;

public class LiftTest {
    Lift l = new Lift();

    @Test
    public void test(){
        Assert.assertEquals(8, l.liftProblem(new int[]{2,3,4}, 2));
    }

    @Test
    public void test1(){
        Assert.assertEquals(6, l.liftProblem(new int[]{4,2,3, 1, 4}, 5));
    }
}
