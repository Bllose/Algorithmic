package bllose.arithmetic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DoPlus {

    /**
     * 给定N个整数，找出有多少"对"数的和为100。对数统计根据下标来，
     * 比如说有3个数的数组，2 98 2，
     * 下标1和2（1，2）即2 + 98 ＝ 100 符合要求，
     * 下标（2，3）即 98 ＋ 2 ＝ 100 也符合要求，
     * （1，3）即2 ＋ 2 != 100 不符合要求，
     * 总共有2对，答案为2。
     * 显然，（1，2）和（2，1）只算一次。
     *
     * @param nums
     * @param len
     * @return
     */
    public int bruteForce(int[] nums, int len){
        int counter = 0;
        for(int left = 0 ; left < len; left ++){
            for(int right = left + 1; right < len; right ++){
                if(nums[left] + nums[right] == 100){
                    counter ++;
                }
            }
        }
        return counter;
    }


    /**
     * 这道题的关键是：所有的pair 可以是重复pair，比如 98，2，2 ，这里存在两个（98，2）的组合，但是不能是相同的元素的更换排列的pair，比如对于pair（98，2）改变排列顺序（2，98）就只能算一个pair
     * 第二点：负数我们是不在乎的，因为我们只寻找pair，而且我们可以拥有的数字最大只能到100，所以一旦存在负数的组合必然不会被选择
     * 第三点: 对于所以的合法pair，我们不需要关注顺序，可以直接greedy ，比如 2，2，2，98，98 ， 我们获取答案的累计是 0，0，0，3，6
     * 如果改变顺序， 2，98，2，98，2 我们答案的累计是 0，1，2，4，6，最终结果是相同的。
     * 基于以上三点， 我们只需要维护一个简单的hashmap 即可。
     *
     * map 记录着已经走过的数值，和它已经出现的次数。
     * 当遍历到新的数值时，从map中寻找可以与其相加等于100的数值， 将记录的“次数”加到最终结果中。
     *
     * @param nums
     * @param total
     * @return
     */
    public int solution(int[] nums, int total){
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for(int i =0; i < total; i++){
            if(nums[i]>=0) q.offer(nums[i]);
        }
        int cur = 0;
        while(q.size()!=0){
            cur = q.poll();
            if(map.containsKey(100 - cur)){
                ans += map.get(100 - cur);
            }
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        return ans;
    }
}
