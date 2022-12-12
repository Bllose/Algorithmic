package bllose.backtracking;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromeTest{
    LongestPalindrome lp = new LongestPalindrome();

    @Test
    public void bruteForce1(){
        Assert.assertEquals("bab", lp.bruteForce("babad"));    
    }

    @Test
    public void bruteForce2(){
        Assert.assertEquals("a", lp.bruteForce("a"));    
    }

    @Test
    public void bruteForce3(){
        Assert.assertEquals("bb", lp.bruteForce("cbbd"));    
    }

    @Test
    public void dynamicProgramming1(){
        Assert.assertEquals("bab", lp.dynamicProgramming("babad"));    
    }

    @Test
    public void dynamicProgramming2(){
        Assert.assertEquals("a", lp.dynamicProgramming("a"));    
    }

    @Test
    public void dynamicProgramming3(){
        Assert.assertEquals("bb", lp.dynamicProgramming("cbbd"));    
    }

    @Test
    public void dynamicProgramming4(){
        Assert.assertEquals("a", lp.dynamicProgramming("ac"));    
    }

    @Test
    public void dynamicProgramming5(){
        Assert.assertEquals("aca", lp.dynamicProgramming("aacabdkacaa"));    
    }

    @Test
    public void dynamicProgramming6(){
        Assert.assertEquals("aaaa", lp.dynamicProgramming("aaaa"));    
    }

    @Test
    public void centralExtension1(){
        Assert.assertEquals("bab", lp.centralExtension("babad"));    
    }

    @Test
    public void centralExtension2(){
        Assert.assertEquals("a", lp.centralExtension("a"));    
    }

    @Test
    public void centralExtension3(){
        Assert.assertEquals("bb", lp.centralExtension("cbbd"));    
    }

    @Test
    public void centralExtension4(){
        Assert.assertTrue("ac".contains(lp.centralExtension("ac")));
    }

    @Test
    public void centralExtension5(){
        Assert.assertEquals("aca", lp.centralExtension("aacabdkacaa"));    
    }

    @Test
    public void centralExtension6(){
        Assert.assertEquals("aaaa", lp.centralExtension("aaaa"));    
    }



    @Test
    public void dynamicProgrammingRepeat1(){
        Assert.assertEquals("bab", lp.dynamicProgrammingRepeat("babad"));    
    }

    @Test
    public void dynamicProgrammingRepeat2(){
        Assert.assertEquals("a", lp.dynamicProgrammingRepeat("a"));    
    }

    @Test
    public void dynamicProgrammingRepeat3(){
        Assert.assertEquals("bb", lp.dynamicProgrammingRepeat("cbbd"));    
    }

    @Test
    public void dynamicProgrammingRepeat4(){
        Assert.assertEquals("a", lp.dynamicProgrammingRepeat("ac"));    
    }

    @Test
    public void dynamicProgrammingRepeat5(){
        Assert.assertEquals("aca", lp.dynamicProgrammingRepeat("aacabdkacaa"));    
    }

    @Test
    public void dynamicProgrammingRepeat6(){
        Assert.assertEquals("aaaa", lp.dynamicProgrammingRepeat("aaaa"));    
    }

    @Test
    public void dynamicProgrammingRepeat7(){
        Assert.assertEquals("cccc", lp.dynamicProgrammingRepeat("abccccdd"));    
    }
}
