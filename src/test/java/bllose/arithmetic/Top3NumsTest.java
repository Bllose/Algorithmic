package bllose.arithmetic;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class Top3NumsTest {

    @Test
    public void test(){
        System.out.println(
                JSONObject.toJSONString(Top3Nums.getTop3Num("a56b-6-8()_56!@$-a")));
    }

    @Test
    public void test1(){
        System.out.println(
                JSONObject.toJSONString(Top3Nums.getTop3Num("--028.300003")));
    }

    @Test
    public void testT(){
        System.out.println(
                JSONObject.toJSONString(Top3Nums.getTop3Num1("a56b-6-8()_56!@$-a")));
    }

    @Test
    public void testT1(){
        System.out.println(
                JSONObject.toJSONString(Top3Nums.getTop3Num1("--028.300003")));
    }

    @Test
    public void testT2(){
        System.out.println(
                JSONObject.toJSONString(Top3Nums.getTop3Num1(null)));
    }


    @Test
    public void testM(){
        System.out.println(
                JSONObject.toJSONString(Top3Nums.getTop3Num2("a56b-6-8()_56!@$-a")));
    }

    @Test
    public void testM1(){
        System.out.println(
                JSONObject.toJSONString(Top3Nums.getTop3Num2("--028.300003")));
    }

    @Test
    public void testM2(){
        System.out.println(
                JSONObject.toJSONString(Top3Nums.getTop3Num2(null)));
    }
}
