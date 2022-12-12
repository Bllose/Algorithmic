package bllose.searchRelated;

import org.junit.Assert;
import org.junit.Test;


public class NumberOfIslandsTest {

    NumberOfIslands nof = new NumberOfIslands();

    @Test
    public void test(){
        char[][] map = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Assert.assertEquals(1, nof.findIslands(map));   
    }
    
    @Test
    public void testBFS(){
        char[][] map = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Assert.assertEquals(1, nof.findIslandsBFS(map));   
    }
}
