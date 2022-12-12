package bllose.recursion;

public class Chess {

    /**
     * Y 最近爱上了下象棋，但是和别人不同，他喜欢瞎下。
     *
     * 众所周知，马走日，象走田。但是 Y 的马与众不同，它可以一直走日，直到所有的位置都被恰好经过一次。
     *
     * 更神奇的是，他的马在走的时候还有优先级之分。马会优先向大约 1 点钟方向走，然后沿着顺时针各个方向的优先度依次降低。
     * 即他的马会先考虑向 1 点钟方向走，再考虑向 2 点钟方向走，之后是 4 点钟，5 点钟，以此类推。
     *
     * 给定一个 n × m 的棋盘，Y 的马最开始在 (1,1) 格子上（最左下角）。问存不存在一条走马路径，使得所有的位置都恰好被马经过一次。
     *
     * 如果存在多条，输出一条优先度最高的；如果没有这样的路径，输出“QAQ”。
     *
     * 注意，本题中棋盘最左下角编号为 (1, 1)， 最右上角编号为 (n, m)
     *
     * 想一想，能否用非递归的方式实现？
     *
     * @return
     */
    public int[][] horse(int n, int m){
        int[][] steps = new int[n][m];
        steps[n - 1][0] = 1;
        go(steps, n - 1, 0, n, m);

        boolean finished = true;
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0; j < m ; j ++){
                if(steps[i][j] == 0){
                    finished = false;
                    break;
                }
            }
            if(!finished) break;
        }

        if(finished) return steps;
        return null;
    }

    private void go(int[][] steps, int lastY, int lastX, int y, int x){
        try {
            if (lastX + 2 < x && lastY + 1 < y && steps[lastY + 1][lastX + 2] == 0) {
                steps[lastY + 1][lastX + 2] = steps[lastY][lastX] + 1;
                go(steps, lastY + 1, lastX + 2, x, y);
            } else if (lastX + 2 < x && lastY - 1 >= 0 && steps[lastY - 1][lastX + 2] == 0) {
                steps[lastY - 1][lastX + 2] = steps[lastY][lastX] + 1;
                go(steps, lastY - 1, lastX + 2, x, y);
            } else if (lastX + 1 < x && lastY - 2 >= 0 && steps[lastY - 2][lastX + 1] == 0) {
                steps[lastY - 2][lastX + 1] = steps[lastY][lastX] + 1;
                go(steps, lastY - 2, lastX + 1, x, y);
            } else if (lastX - 1 >= 0 && lastY - 2 >= 0 && steps[lastY - 2][lastX - 1] == 0) {
                steps[lastY - 2][lastX - 1] = steps[lastY][lastX] + 1;
                go(steps, lastY - 2, lastX - 1, x, y);
            } else if (lastX - 2 >= 0 && lastY - 1 >= 0 && steps[lastY - 1][lastX - 2] == 0) {
                steps[lastY - 1][lastX - 2] = steps[lastY][lastX] + 1;
                go(steps, lastY - 1, lastX - 2, x, y);
            } else if (lastX - 2 >= 0 && lastY + 1 < y && steps[lastY + 1][lastX - 2] == 0) {
                steps[lastY + 1][lastX - 2] = steps[lastY][lastX] + 1;
                go(steps, lastY + 1, lastX - 2, x, y);
            } else if (lastX - 1 >= 0 && lastY + 2 < y && steps[lastY + 2][lastX - 1] == 0) {
                steps[lastY + 2][lastX - 1] = steps[lastY][lastX] + 1;
                go(steps, lastY + 2, lastX - 1, x, y);
            } else if (lastX + 1 < x && lastY + 2 < y && steps[lastY + 2][lastX + 1] == 0) {
                steps[lastY + 2][lastX + 1] = steps[lastY][lastX] + 1;
                go(steps, lastY + 2, lastX + 1, x, y);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            for(int[] row : steps){
                for(int val : row){
                    System.out.print(String.format("%4d", val));
                }
                System.out.println("");
            }
        }
    }
}
