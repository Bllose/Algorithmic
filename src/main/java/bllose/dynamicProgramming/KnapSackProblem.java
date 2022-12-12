package bllose.dynamicProgramming;

import java.util.List;
import java.lang.Math;

public class KnapSackProblem {

    /**
     * 01 背包问题
     *
     * @param totalWeight 背包可容纳总重量
     * @param items 待被装物品 [重量][价值]
     * @return 可被装最大价值
     */
    public int knapSackProblem01(int totalWeight, List<int[]> items){
        /*
        第一列为背包容量为0， 那么可以装的最大价值全部都是0
        第一行为装的物品数量为0， 那么最大价值自然也全部是0
         */
        int[][] board = new int[items.size() + 1][totalWeight + 1];
        for(int currectItem = 1; currectItem <= items.size(); currectItem ++){

            int itemWeight = items.get(currectItem-1)[0]; // 当前判断物品的重量
            int itemValue = items.get(currectItem-1)[1];  // 当前判断物品的价值

            // 针对当前判断的物品， 将所有容量情况下全部比较一次
            for(int currectWeight = 1 ; currectWeight <= totalWeight; currectWeight ++){
                if(currectWeight < itemWeight){
                    // 如果背包容量小于当前物品的重量
                    // 那么当前物品肯定是没法装进去的
                    // 那么我们就寻找上一个物品在当前容量下的最佳价值
                    board[currectItem][currectWeight] = board[currectItem-1][currectWeight];
                }else {
                    // 当背包容量已经可以容纳当前物品了，就要开始判断是放入该物品比较划算，还是不放入价值比较高
                    int currectMaxValue =
                            Math.max(board[currectItem - 1][currectWeight - itemWeight] + itemValue,
                                     board[currectItem - 1][currectWeight] );
                    board[currectItem][currectWeight] = currectMaxValue;
                }
            }
        }

        return board[items.size()][totalWeight];
    }
}
