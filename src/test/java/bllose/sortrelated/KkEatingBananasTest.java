package bllose.sortrelated;

import org.junit.Assert;
import org.junit.Test;

public class KkEatingBananasTest {

    @Test
    public void case1(){
        Integer[] piles = new Integer[]{3,6,7,11};
        int k = 8;
        Assert.assertEquals(4, KakaEatingBananas.KekelovesBanana(piles, k));
    }

    @Test
    public void case2(){
        Integer[] piles = new Integer[]{30,11,23,4,20};
        int k = 5;
        Assert.assertEquals(30, KakaEatingBananas.KekelovesBanana(piles, k));
    }

    @Test
    public void case3(){
        Integer[] piles = new Integer[]{30,11,23,4,20};
        int k = 6;
        Assert.assertEquals(23, KakaEatingBananas.KekelovesBanana(piles, k));
    }


}
