package bllose.recursion;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class ChessTest {
    Chess c = new Chess();

    @Test
    public void test(){
        System.out.println(JSONObject.toJSONString(c.horse(3, 4)));
    }
}
