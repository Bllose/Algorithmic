package bllose.arithmetic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Stream;

public class DoPlusTest {
    DoPlus dp = new DoPlus();
    int[] nums = new int[]{};

    @Before
    public void init() throws FileNotFoundException {
        String values = establishLongString();
        String[] valueArray = values.split(" ");
        nums = Stream.of(valueArray).mapToInt(Integer::parseInt).toArray();
    }

    @Test
    public void bruteForceTest(){
        int result = dp.bruteForce(nums, 100000);
        Assert.assertEquals(8177758, result);
    }

    @Test
    public void dynamicProgrammingTest(){
        Assert.assertEquals(8177758, dp.dynamicProgram(nums, 100000));
    }

    @Test
    public void solutionTest(){
        Assert.assertEquals(8177758, dp.solution(nums, 100000));
    }

    @Test
    public void dynamicProgrammingTest1(){
        Assert.assertEquals(1, dp.dynamicProgram(new int[]{1,99}, 2));
    }

    @Test
    public void dynamicProgrammingTest2(){
        Assert.assertEquals(2, dp.dynamicProgram(new int[]{1,1,99}, 3));
    }

    @Test
    public void dynamicProgrammingTest3(){
        Assert.assertEquals(4, dp.dynamicProgram(new int[]{1,1,99, 99}, 4));
    }

    @Test
    public void dynamicProgrammingTest4(){
        Assert.assertEquals(3, dp.dynamicProgram(new int[]{1,1, 2,98, 99}, 5));
    }

    @Test
    public void dynamicProgrammingTest5(){
        Assert.assertEquals(6, dp.dynamicProgram(new int[]{1,1, 2,50, 50, 50, 98, 99}, 8));
    }

    @Test
    public void dynamicProgrammingTest6(){
        Assert.assertEquals(3, dp.dynamicProgram(new int[]{-1, 1, 1, 98, 99}, 5));
    }


    private String establishLongString() throws FileNotFoundException {
        File f = new File("src/test/resources/lotOfNumbers.txt");
        Scanner myReader = new Scanner(f);
        String data = myReader.nextLine();
        myReader.close();
        return data;
    }
}
