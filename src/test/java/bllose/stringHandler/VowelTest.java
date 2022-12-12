package bllose.stringHandler;

import org.junit.Assert;
import org.junit.Test;

public class VowelTest {
    Vowel vowel = new Vowel();

    @Test
    public void test(){
        Assert.assertEquals("whO lOvE sOlO", vowel.solo("Who Love Solo"));
    }

    @Test
    public void testOrigin(){
        Assert.assertEquals("whO lOvE sOlO", vowel.soloOrigin("Who Love Solo"));
    }
}
