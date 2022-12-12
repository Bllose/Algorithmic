package bllose.arithmetic.ludengwenti;

import org.junit.Assert;
import org.junit.Test;

public class LuDengTest {

    @Test
    public void test1(){
        Assert.assertEquals(1,
                bllose.arithmetic.ludengwenti.Main.noLightArea("1 150 1 49", 4));
    }

    @Test
    public void test2(){
        Assert.assertEquals(0,
                bllose.arithmetic.ludengwenti.Main.noLightArea("1 300 1 49", 4));
    }

    @Test
    public void test3(){
        Assert.assertEquals(4,
                bllose.arithmetic.ludengwenti.Main.noLightArea("49 50 49 49", 4));
    }

    @Test
    public void test4(){
        Assert.assertEquals(300,
                bllose.arithmetic.ludengwenti.Main.noLightArea("0 0 0 0", 4));
    }

    @Test
    public void test(){
        String lights = "150 25 84 19 72 144 105 87 78 60 133 58 142 57 8 85 141 35 14 94 36 78 19 29 124 16 84 102 17 87 66 43 133 13 94 91 58 100 140 1 83 26 78 71 36 77 93 105 61 82 114 134 96 24 104 142 65 86 76 130 31 31 64 136 17 10 65 101 57 56 145 59 42 69 6 29 18 143 132 4 127 56 82 138 142 112 16 106 83 84 101 99 14 25 83 82 104 66 19 134";
        System.out.println(bllose.arithmetic.ludengwenti.Main.noLightArea(lights, 100));
    }
}
