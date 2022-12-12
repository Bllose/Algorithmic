package bllose.leetcode;

import bllose.helpers.TreeHelper;

import java.util.ArrayList;
import java.util.List;

public class MonitorBT {
    public static int minCameraCover(TreeHelper.TreeNode root) {
        List<Integer> recorder = new ArrayList<Integer>(){{
            add(0);
        }};
        int fina = DFSWithMonitor(root, recorder);
        int ans = recorder.get(0);
        return (ans == 0 || fina == 0) ? ans + 1 : ans;
    }

    private static int DFSWithMonitor(TreeHelper.TreeNode root, List<Integer> recorder){
        if(root.left == null && root.right == null){
            return 0;
        }
        // 假如某个孩子为空树，则处于被覆盖的状态
        int left = 2;
        int right = 2;
        if(root.left != null){
            left = DFSWithMonitor(root.left, recorder);
        }
        if(root.right != null){
            right = DFSWithMonitor(root.right, recorder);
        }

        // 左、右只要有一个没有被覆盖，则本节点一定需要安装摄像头
        if(left == 0 || right == 0){
            recorder.set(0, recorder.get(0) + 1);
            return 1;
        // 左右孩子均是覆盖状态，那么当前节点就直接返回未覆盖状态， 等待父节点安装摄像头
        }else if(left == 2 && right == 2){
            return 0;
        // 在左右孩子都不是未覆盖的情况下，只要有一个孩子安装了摄像头， 该节点直接返回被覆盖
        }else if(left == 1 || right == 1){
            return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeHelper.TreeNode root = TreeHelper.convertArray2Node(new Integer[]{0,0,null,0,0});
        System.out.println("预期为1, 实际为:" + MonitorBT.minCameraCover(root));

        root = TreeHelper.convertArray2Node(new Integer[]{0,0,null,0,null,null,null,null,0});
        System.out.println("预期为2, 实际为:" + MonitorBT.minCameraCover(root));

        root = TreeHelper.convertArray2Node(new Integer[]{0,0,0,null,null,null,0});
        System.out.println("预期为2, 实际为:" + MonitorBT.minCameraCover(root));
    }
}
