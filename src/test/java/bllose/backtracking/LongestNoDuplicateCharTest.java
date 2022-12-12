package bllose.backtracking;

import org.junit.Assert;
import org.junit.Test;

public class LongestNoDuplicateCharTest {
    LongestNoDuplicateChar lndc = new LongestNoDuplicateChar();

    @Test
    public void test(){
        Assert.assertEquals(3, lndc.longestLengthSubString("abcabcbb"));
    }

    @Test
    public void test1(){
        Assert.assertEquals(1, lndc.longestLengthSubString("bbbbbb"));
    }

    @Test
    public void test2(){
        Assert.assertEquals(3, lndc.longestLengthSubString("pwwkew"));
    }
}
