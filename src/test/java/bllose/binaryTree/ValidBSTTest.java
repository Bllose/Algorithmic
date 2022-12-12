package bllose.binaryTree;

import org.junit.Test;

import bllose.helpers.TreeHelper;
import bllose.helpers.TreeHelper.TreeNode;
import org.junit.Assert;

public class ValidBSTTest {

    BinaryTrees bt = new BinaryTrees();

    @Test
    public void testCase1(){
        TreeNode newRoot = TreeHelper.establishBinaryTree(new Integer[]{2,1,3});

        Assert.assertEquals(true, bt.isValidBST(newRoot));
    }

    @Test
    public void testCase2(){
        TreeNode root = TreeHelper.establishBinaryTree(new Integer[]{2,2,2});
        Assert.assertEquals(false, bt.isValidBST(root));
    }

    @Test
    public void testCase3(){
        TreeNode root = TreeHelper.establishBinaryTree(new Integer[]{1,null,1});
        Assert.assertEquals(false, bt.isValidBST(root));
    }

    @Test
    public void testCase4(){
        TreeNode root = TreeHelper.establishBinaryTree(new Integer[]{5,4,6,null,null,3,7});
        Assert.assertEquals(false, bt.isValidBST(root));
    }

    @Test
    public void testCase5(){
        TreeNode root = TreeHelper.establishBinaryTree(new Integer[]{32,26,47,19,null,null,56,null,27});
        Assert.assertEquals(false, bt.isValidBST(root));
    }
    
}
