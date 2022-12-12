package bllose.binaryTree;

import com.alibaba.fastjson.JSONObject;

import org.junit.Assert;
import org.junit.Test;

import bllose.helpers.TreeHelper;
import bllose.helpers.TreeHelper.TreeNode;

public class BalanceBSTTest{

    BinaryTrees bt = new BinaryTrees();

    @Test
    public void test(){
        TreeNode root = TreeHelper.establishBinaryTree(new Integer[]{1, null, 2, null, null, null, 3, null, null, null, null, null, null, null, 4});
        TreeNode balanceRoot = bt.balanceBST(root);
        Integer[] result = TreeHelper.preOrderTraversal(balanceRoot);
        Integer[] rootArray = TreeHelper.preOrderTraversal(root);
        Assert.assertEquals(
            "[1,null,2,null,null,null,3,null,null,null,null,null,null,null,4,null]", 
            JSONObject.toJSONString(rootArray));
        Assert.assertEquals(
            "[2,1,3,null,null,null,4,null]", 
            JSONObject.toJSONString(result));
    }
}