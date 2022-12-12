package bllose.dynamicProgramming;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KnapSackProblemTest {
    KnapSackProblem ksp = new KnapSackProblem();

    @Test
    public void test(){
        List<int[]> items = new ArrayList<>();
        items.add(new int[]{2,6});
        items.add(new int[]{2,3});
        items.add(new int[]{6,5});
        items.add(new int[]{5,4});
        items.add(new int[]{4,6});
        Assert.assertEquals(15, ksp.knapSackProblem01(10, items));
    }

}
