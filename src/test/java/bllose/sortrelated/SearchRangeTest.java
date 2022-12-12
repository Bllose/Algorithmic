package bllose.sortrelated;

import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class SearchRangeTest {
    SearchRange sr = new SearchRange();

    @Test
    public void binarySearchTest1(){
        Assert.assertEquals(JSONObject.toJSONString(new int[]{4,9}),
                JSONObject.toJSONString(sr.searchRange(new int[]{1,2,2,4,6,6,6,6,6,6,7,8,8,9}, 6)));
    }

    @Test
    public void binarySearchTest2(){
        Assert.assertEquals(JSONObject.toJSONString(new int[]{0,0}),
                JSONObject.toJSONString(sr.searchRange(new int[]{1}, 1)));
    }

    @Test
    public void binarySearchTest3(){
        Assert.assertEquals(JSONObject.toJSONString(new int[]{-1,-1}),
                JSONObject.toJSONString(sr.searchRange(new int[]{}, 1)));
    }

    @Test
    public void binarySearchTest4(){
        Assert.assertEquals(JSONObject.toJSONString(new int[]{0,1}),
                JSONObject.toJSONString(sr.searchRange(new int[]{1,1,2}, 1)));
    }

    @Test
    public void binarySearchTest5(){
        Assert.assertEquals(JSONObject.toJSONString(new int[]{3,4}),
                JSONObject.toJSONString(sr.searchRange(new int[]{0,0,1,2,2}, 2)));
    }
}
