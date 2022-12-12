package bllose.arithmetic.bfs;

import java.util.Scanner;
import java.util.stream.Stream;


public class Main {


    /**
     * 3 3
     * 1 2 11
     * 2 3 14
     * 1 3 50
     * 1 3
     * 
     * 3个节点， 3个时间
     * 起始点 终点 耗时
     * ...
     * 求
     * 起始点 终点 的最短耗时
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nots = in.nextInt();
        int times = in.nextInt();
        in.nextLine();

        int[][] map = new int[nots+1][nots+1];
        for(int i = 0 ; i < times ; i ++){
            String curString = in.nextLine();
            Integer[] curArray = Stream.of(curString.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
            map[curArray[0]][curArray[1]] = curArray[2];
        }

        String luxian = in.nextLine();
        Integer[] task = Stream.of(luxian.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        int start = task[0];
        int end = task[1];
        
        int time = -1;
        for(int i = 1 ; i < times + 1 ; i ++){
            if(map[start][i] != 0){
                int temp = timespend(map, start, end);
                if(time > temp || time == -1){
                    time = temp;
                }
            }
        }
        System.out.println(time);
    }


        

    private static int timespend(int[][] map, int start, int end){
        int time = 0;
        for(int i = 1 ; i < map.length ; i ++){
            if(map[start][i] != 0 && i != end ){
                time += map[start][i];
                time += timespend(map, i, end);
            }
            if(i == end){
                return map[start][i];
            }
        }
        return -1;
    }

}
