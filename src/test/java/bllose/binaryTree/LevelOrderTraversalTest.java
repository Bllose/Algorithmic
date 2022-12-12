package bllose.binaryTree;


import com.alibaba.fastjson.JSONObject;

import org.junit.Assert;
import org.junit.Test;

import bllose.helpers.TreeHelper;
import bllose.helpers.TreeHelper.TreeNode;

public class LevelOrderTraversalTest {
    BinaryTrees bt = new BinaryTrees();

    @Test
    public void test1(){
        TreeNode root = TreeHelper.establishBinaryTree(new Integer[]{3,9,20,null,null,15,7});
        Assert.assertEquals("[[3],[9,20],[15,7]]", JSONObject.toJSONString(bt.levelOrder(root)));
    }

    @Test
    public void test2(){
        TreeNode root = TreeHelper.establishBinaryTree(new Integer[]{1,2,3,4,5});
        Assert.assertEquals("[[1],[2,3],[4,5]]", JSONObject.toJSONString(bt.levelOrder(root)));
    }

    @Test
    public void test3(){
        TreeNode root = TreeHelper.establishBinaryTree(new Integer[]{});
        Assert.assertEquals("[]", JSONObject.toJSONString(bt.levelOrder(root)));
    }
    
}
