package bllose.arithmetic;

import org.junit.Assert;
import org.junit.Test;

public class HowManyTriangleTest {
    HowManyTriangle hmt = new HowManyTriangle();

    @Test
    public void bruteForce(){
        Assert.assertEquals(0, hmt.solution(new int[]{1,2,4}));
    }

    @Test
    public void bruteForce1(){
        Assert.assertEquals(2, hmt.solution(new int[]{1,2,4,5,7}));
    }

    @Test
    public void binarySearchSolution(){
        Assert.assertEquals(0, hmt.binarySearchSolution(new int[]{1,2,4}));
    }

    @Test
    public void binarySearchSolution1(){
        Assert.assertEquals(2, hmt.binarySearchSolution(new int[]{1,2,4,5,7}));
    }
}
