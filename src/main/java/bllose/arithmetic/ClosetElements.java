package bllose.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClosetElements {

    /**
     * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
     *
     * 整数 a 比整数 b 更接近 x 需要满足：
     *
     * |a - x| < |b - x| 或者
     * |a - x| == |b - x| 且 a < b
     * 示例 1：
     *
     * 输入：arr = [1,2,3,4,5], k = 4, x = 3
     * 输出：[1,2,3,4]
     * 示例 2：
     *
     * 输入：arr = [1,2,3,4,5], k = 4, x = -1
     * 输出：[1,2,3,4]
     * 提示：
     *
     * 1 <= k <= arr.length
     * 1 <= arr.length <= 104
     * arr 按 升序 排列
     * -104 <= arr[i], x <= 104
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public Integer[] findClosestElements(Integer[] arr, int k, int x) {
        Arrays.sort(arr, (o1, o2) -> {
                        if(Math.abs(o1-x) < Math.abs(o2-x)) return -1;
                        if(Math.abs(o1 - x) == Math.abs(o2 - x) && o1 < o2) return -1;
                        return 1;
        });

        Integer[] ans = new Integer[k];
        for(int i = 0 ; i < k ; i ++){
            ans[i] = arr[i];
        }

        Arrays.sort(ans);

        return ans;
    }

    public List<Integer> findClosestElementsList(Integer[] arr, int k, int x) {
        Arrays.sort(arr, (o1, o2) -> {
            if(Math.abs(o1-x) < Math.abs(o2-x)) return -1;
            if(Math.abs(o1 - x) == Math.abs(o2 - x) && o1 < o2) return -1;
            return 1;
        });

        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < k ; i ++){
            ans.add(arr[i]);
        }

        Collections.sort(ans);

        return ans;
    }

    /**
     * 19:59	info
     * 			解答成功:
     * 			执行耗时:22 ms,击败了16.76% 的Java用户
     * 			内存消耗:44.1 MB,击败了5.04% 的Java用户
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElementsList(int[] arr, int k, int x) {
        Integer[] array = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(array, (o1, o2) -> {
            if(Math.abs(o1-x) < Math.abs(o2-x)) return -1;  // 返回复数，意味着 o1 在前面， o2 在后面
            if(Math.abs(o1 - x) == Math.abs(o2 - x) && o1 < o2) return -1;
            return 1;
        });

        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < k ; i ++){
            ans.add(array[i]);
        }

        Collections.sort(ans);

        return ans;
    }

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8,9,10};

// To boxed array
        Integer[] what = Arrays.stream( data ).boxed().toArray( Integer[]::new );
        Integer[] ever = IntStream.of( data ).boxed().toArray( Integer[]::new );

// To boxed list
        List<Integer> you  = Arrays.stream( data ).boxed().collect( Collectors.toList() );
        List<Integer> like = IntStream.of( data ).boxed().collect( Collectors.toList() );
    }
}
