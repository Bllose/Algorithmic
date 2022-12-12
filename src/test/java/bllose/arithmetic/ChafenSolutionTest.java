package bllose.arithmetic;

import org.junit.Test;

public class ChafenSolutionTest {
    ChafenSolution cs = new ChafenSolution();

    @Test
    public void test(){
        System.out.println(cs.getMedian(new int[]{2,3,1,6,1,10,2,5,9,8}));
    }

    @Test
    public void test1(){
        System.out.println(cs.getMedian(new int[]{1000}));
    }

    @Test
    public void test2(){
        System.out.println(cs.getMedian(new int[]{1,2,3,4,5,6,7,8,9,10,11,12}));
    }
}
