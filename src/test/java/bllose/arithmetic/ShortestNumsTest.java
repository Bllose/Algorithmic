package bllose.arithmetic;

import org.junit.Assert;
import org.junit.Test;


public class ShortestNumsTest {
    ShortestNums sn = new ShortestNums();

    @Test
    public void main(){
        Assert.assertEquals(3, 
        sn.minSubarray(new int[]{1,2,4,4,1,1,1}, 9));
    }

    @Test
    public void test1(){
        Assert.assertEquals(1, 
        sn.minSubarray(new int[]{1289,2148,1,1,1,4,5}, 13));
    }

    @Test
    public void test2(){
        Assert.assertEquals(1, 
        sn.minSubarray(new int[]{1,1,1,2,3,4,5,4}, 5));
    }


    @Test
    public void binarySearchTest1(){
        Assert.assertEquals(3, 
        sn.binarySearch(new int[]{1,2,4,4,1,1,1}, 9));
    }

    @Test
    public void binarySearchTest2(){
        Assert.assertEquals(1, 
        sn.binarySearch(new int[]{1289,2148,1,1,1,4,5}, 13));
    }

    @Test
    public void binarySearchTest3(){
        Assert.assertEquals(1, 
        sn.binarySearch(new int[]{1,1,1,2,3,4,5,4}, 5));
    }
}
