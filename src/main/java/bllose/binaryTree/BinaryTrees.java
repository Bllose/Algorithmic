package bllose.binaryTree;

import java.util.ArrayList;
import java.util.List;


import bllose.helpers.TreeHelper.TreeNode;

public class BinaryTrees{

    /**
     * 平衡化搜索二叉树
     *
     * @param root
     * @return
     */
    List<Integer> inOrderList = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root){
        inOrderTraversal(root);
        return balancingBST(0, inOrderList.size()-1);
    }
    
    private TreeNode balancingBST(int left, int right){
        int middle = (left + right) >> 1;
        TreeNode curNode = new TreeNode(inOrderList.get(middle));
        if(middle > left) curNode.left = balancingBST(left, middle - 1);
        if(middle < right) curNode.right = balancingBST(middle + 1, right);
        return curNode;
    }

    private void inOrderTraversal(TreeNode root) {
        if(root.left != null) inOrderTraversal(root.left);
        inOrderList.add(root.val);
        if(root.right != null) inOrderTraversal(root.right);
    }



    /**
     * 验证是否为搜索二叉树
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root){
        if(null == root) return true;

        if(root.left != null){
            if(!valid(root.left, null, root.val)) return false;
        } 
        if(root.right != null){
            if(!valid(root.right, root.val, null)) return false;
        }

        return true;
    }
    private boolean valid(TreeNode root, Integer min, Integer max){
        if(max != null && root.val >= max) return false;
        if(min != null && root.val <= min) return false;

        if(root.left != null){
            if(!valid(root.left, min, root.val)) return false;
        }
        if(root.right != null){
            if(!valid(root.right, root.val, max)) return false;
        }
        return true;
    }

    /**
     * 层级遍历二叉树
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        if(null == root) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rootLevel = new ArrayList<>();
        rootLevel.add(root.val);
        result.add(rootLevel);

        if(root.left != null) levelOrderTraversal(root.left, 2, result);
        if(root.right != null) levelOrderTraversal(root.right, 2, result);

        return result;
    }
    private void levelOrderTraversal(TreeNode root, int high, List<List<Integer>> result) {
        List<Integer> curLevel;
        if(result.size() >= high){
            curLevel = result.get(high - 1);
        }else{
            curLevel = new ArrayList<>();
            result.add(curLevel);
        }

        curLevel.add(root.val);

        if(root.left != null) levelOrderTraversal(root.left, high + 1, result);
        if(root.right != null) levelOrderTraversal(root.right, high + 1, result);
    }
}
