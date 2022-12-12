package bllose.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Math;

public class Top3Nums {

    public static int[] getTop3Num(String str) {
        Pattern p = Pattern.compile("((-)?[0-9]+)");
        Matcher m = p.matcher(str);
        int[] ans = new int[]{(int) Math.pow(-2, 31), (int) Math.pow(-2, 31), (int) Math.pow(-2, 31)};

        int counter = 0;
        while(m.find()){
            int curNum = Integer.valueOf(m.group(1));
            if(curNum > ans[0]){
                ans[2] = ans[1];
                ans[1] = ans[0];
                ans[0] = curNum;
                counter ++;
                continue;
            }
            if(curNum > ans[1]){
                ans[2] = ans[1];
                ans[1] = curNum;
                counter ++;
                continue;
            }
            if(curNum > ans[2]){
                ans[2] = curNum;
                counter ++;
                continue;
            }
        }

        if(counter < 3){
            int[] really = new int[counter];
            for(int i = 0 ; i < counter ; i ++){
                really[i] = ans[i];
            }
            return really;
        }
        return ans;
    }


    /**
     * 部分通过?
     *
     * @param str
     * @return
     */
    public static int[] getTop3Num1(String str) {
        Pattern p = Pattern.compile("((-)?[0-9]+)");
        Matcher m = p.matcher(str);
        Integer[] ans = new Integer[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        int counter = 0;
        while(m.find()){
            int curNum = Integer.valueOf(m.group(1));
            setAns(ans, curNum, counter);
            counter ++;
        }

        if(counter == 0) return new int[]{};
        if(counter > 2) {
            int[] result = new int[3];
            result[0] = ans[0];
            result[1] = ans[1];
            result[2] = ans[2];
            return result;
        }

        int result[] = new int[counter];
        if(counter == 2){
            result[0] = ans[0];
            result[1] = ans[1];
        }else{
            result[0] = ans[0];
        }
        return result;
    }

    private static void setAns(Integer[] ans, int curNum, int counter) {
        if(counter < 3){
            ans[counter] = curNum;
            Arrays.sort(ans, (o1, o2)-> o2 - o1);
            return;
        }
        if(ans[0] < curNum){
            ans[2] = ans[1];
            ans[1] = ans[0];
            ans[0] = curNum;
            return;
        }
        if(ans[1] < curNum){
            ans[2] = ans[1];
            ans[1] = curNum;
            return;
        }
        if(ans[2] < curNum){
            ans[2] = curNum;
        }
    }


    /**
     * 232ms 通过
     *
     * @param str
     * @return
     */
    public static int[] getTop3Num2(String str) {
        Pattern p = Pattern.compile("((-)?[0-9]+)");
        Matcher m = p.matcher(str);
        List<Integer> ansList = new ArrayList<>();

        while(m.find()){
            ansList.add(Integer.valueOf(m.group(1)));
        }

        Collections.sort(ansList, (o1, o2) -> o2 - o1);

        if(ansList.size() > 2){
            int[] ans = new int[3];
            ans[0] = ansList.get(0);
            ans[1] = ansList.get(1);
            ans[2] = ansList.get(2);
            return ans;
        }else{
            int[] ans = new int[ansList.size()];
            for(int i=0; i < ansList.size(); i ++ ){
                ans[i] = ansList.get(i);
            }
            return ans;
        }

    }
}
