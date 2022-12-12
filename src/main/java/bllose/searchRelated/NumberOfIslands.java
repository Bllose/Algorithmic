package bllose.searchRelated;

import java.util.Queue;
import java.util.ArrayDeque;

public class NumberOfIslands {
    /**
     * Leetcode 200
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     * @param map
     * @return
     */
    public int findIslands(char[][] map){
        int num = 0;
        if(null == map || map.length == 0) return num;

        int horizental = map.length;
        int vertical = map[0].length;
        for(int h = 0 ; h < horizental; h ++){
            for(int v = 0; v < vertical; v ++){
                if(map[h][v] == '1') {
                    dfs(map, h, v, horizental, vertical);
                    num ++;
                }
            }
        }

        return num;
    }
    private void dfs(char[][] map, int h, int v, int horizental, int vertical) {
        if(h >= horizental || v >= vertical 
            || h < 0 || v < 0 || map[h][v] == '0') return;
        map[h][v] = '0';
        dfs(map, h + 1, v, horizental, vertical);
        dfs(map, h, v + 1, horizental, vertical);
        dfs(map, h - 1, v, horizental, vertical);
        dfs(map, h, v - 1, horizental, vertical);
    }

    /**
     * 牛客 NC109 岛屿数量
     * 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
        岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
        例如：
        输入
        [
        [1,1,0,0,0],
        [0,1,0,1,1],
        [0,0,0,1,1],
        [0,0,0,0,0],
        [0,0,1,1,1]
        ]
        对应的输出为3
        (注：存储的01数据其实是字符'0','1')
     * @param map
     * @return
     */
    public int findIslandsBFS(char[][] map){
        int num = 0;
        if(null == map || map.length == 0) return num;

        Queue<int[]> queue = new ArrayDeque<>();
        int horizental = map.length;
        int vertical = map[0].length;
        for(int h = 0 ; h < horizental; h ++){
            for(int v = 0; v < vertical; v ++){
                if(map[h][v] == '1') {
                    queue.offer(new int[]{h, v});
                    bfs(map, queue, horizental, vertical);
                    num ++;
                }
            }
        }
        return num;
    }
    private void bfs(char[][] map, Queue<int[]> queue, int horizental, int vertical) {
        while(!queue.isEmpty()){
            int[] curCoordinate = queue.poll();
            int h = curCoordinate[0];
            int v = curCoordinate[1];
            if(h >= horizental || v >= vertical 
                || h < 0 || v < 0 || map[h][v] == '0') continue;
            
            map[h][v] = '0';
            queue.offer(new int[]{h-1, v});
            queue.offer(new int[]{h+1, v});
            queue.offer(new int[]{h, v-1});
            queue.offer(new int[]{h, v+1});
        }
        
    }    
}
