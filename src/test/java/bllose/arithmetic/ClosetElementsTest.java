package bllose.arithmetic;

import org.junit.Test;

public class ClosetElementsTest {
    ClosetElements ce = new ClosetElements();

    @Test
    public void test(){
        ce.findClosestElements(new Integer[]{1,2,3,4,5}, 4,3);
    }
}
