package bllose.greedy;

public class Lift {

    /**
     * 华为公司,每天早上都有很多人去坐电梯,每个人都可能到不同的楼层.同时电梯还有一个容量限制.电梯最多只能带K个人.电梯从第a层到第b层,会花费|a-b|的时间.
     * 现在有N个人,以及知道每个人想要去的地方,请问如何坐电梯,才能使每个人到达到他们对应的楼层,且所话费时间最少.电梯最后要会到第1层.
     *
     * 对于每个输入文件,先输入两个整数N,K.表示有N个人,以及电梯的容量K.
     * 接下来一行,有N个整数,f1, f2, … , fn. 表示每个人要到达的地方.
     * (1 <= N, K <= 2000, 1 <= fi <= 2000)
     *
     * 输入：
     * 3 2
     * 2 3 4
     * 输出：
     * 8
     * @param wantToGo
     * @param n
     * @return
     */
    public int liftProblem(int[] wantToGo, int n){
        int ans = 0;
        int[] floors = new int[2000];

        for(int floor : wantToGo){
            floors[floor - 1] ++;
        }

        for(int i = 1999; i > 0; i --){
            int people = floors[i];
            if(people == 0) continue;
            int container = n;

            if (people >= container) {
                floors[i] = floors[i] - container;
            } else if ( people < container ){
                while(container > 0) {
                    if(floors[i] == 0) break; // 假如当前i楼人数为0， 说明上一趟电梯已经将所有人都带走了， 循环结束
                    container -= floors[i];
                    floors[i] = 0;
                    for(int j = 1; container > 0 && i - j >= 0; j ++){
                        if(floors[i-j] >= container){
                            floors[i-j] -= container;
                            container = 0;
                        }else{
                            container -= floors[i-j];
                            floors[i-j] = 0;
                        }
                    }
                }
            }

            ans += 2 * i;
        }

        return ans;
    }
}
