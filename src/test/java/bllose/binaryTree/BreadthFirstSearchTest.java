package bllose.binaryTree;

import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import bllose.helpers.TreeHelper;
import bllose.helpers.TreeHelper.TreeNode;

public class BreadthFirstSearchTest {

    @Test
    public void bfsTest(){
        TreeNode root = TreeHelper.establishBinaryTree(new Integer[]{5, 6, 4,null, null, 1, 8});
        Assert.assertEquals("[5,6,4,1,8]",
                JSONObject.toJSONString(TreeHelper.breadthFirstSearch(root)));
    }

    @Test
    public void covertTest(){
        TreeNode root = TreeHelper.establishBinaryTree(new Integer[]{5, 6, 4,null, null, 1, 8});
        Assert.assertEquals("[5,6,4,null,null,1,8]",
                JSONObject.toJSONString(TreeHelper.covertNode2Array(root)));
    }
    
    @Test
    public void covertTest1(){
        TreeNode root = TreeHelper.establishBinaryTree(new Integer[]{1,null,2,null, null, null, 3, null,null,null,null,null,null,null,4});
        Assert.assertEquals("[1,null,2,null,null,null,3,null,null,null,null,null,null,null,4]",
                JSONObject.toJSONString(TreeHelper.covertNode2Array(root)));
    }

    @Test
    public void covertTest2(){
        TreeNode root = TreeHelper.establishBinaryTree(new Integer[]{1,2,null,3,null,null,null,4});
        Assert.assertEquals("[1,2,null,3,null,null,null,4]",
                JSONObject.toJSONString(TreeHelper.covertNode2Array(root)));
    }
}
