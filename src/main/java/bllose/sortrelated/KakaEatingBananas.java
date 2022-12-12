package bllose.sortrelated;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Math.ceil;

public class KakaEatingBananas {

    public static int KekelovesBanana(Integer[] piles, int k){
        if(piles.length > k){
            return -1;
        }
        Comparator<Integer> comparator = Comparator.comparing(Integer::intValue);
        Integer max = Arrays.stream(piles).max(comparator).get();
        if(piles.length == k){
            return max;
        }

        Integer min = 1;

        while(max != min){
            Integer middle = min + (max - min)/2;
            if(couldEatAllOfBananas(piles, k, middle)){
                if(max==middle) {
                    max --; middle--;
                }else {
                    max = middle;
                }
            }else{
                if(min == middle){
                    min ++;
                    middle ++;
                }else{
                    min = middle;
                }
            }
        }
        return min;
    }

    private static boolean couldEatAllOfBananas(Integer[] piles, int k, Integer middle) {
        int times = 0;
        for(int i = 0 ; i < piles.length; i ++){
            times += ceil((double)piles[i]/middle);
            if(times > k){
                return false;
            }
        }
        return true;
    }
}
