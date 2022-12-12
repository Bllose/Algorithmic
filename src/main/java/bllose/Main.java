package bllose;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    /**
     * 一串字符串， 里面包含一些坐标。 解析最远的那个
     * 
     * jifoao(3,5)fja0jf0ejfajfj(6,7)fjaioufj90a
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(getTheLongestWay(input));
    }

    private static String getTheLongestWay(String record){
        String regex = "(\\([^\\)]+\\))";
        StringBuffer ans = new StringBuffer();

        List<String> distances = new ArrayList<>();
        Matcher m = Pattern.compile(regex).matcher(record);
        while(m.find()){
            distances.add(m.group(1));
        }

        regex = "^0+[1-9]";
        Pattern pat = Pattern.compile(regex);
        for(int i = 0 ; i < distances.size(); i ++){
            String numString = distances.get(i);
            numString = numString.substring(1, numString.length() - 1);
            String[] nums = numString.split(",");
            Matcher m1 = pat.matcher(nums[0]);
            Matcher m2 = pat.matcher(nums[1]);
            if(m1.find() || m2.find()){
                distances.set(i, "");
            }else{
                distances.set(i, numString);
            }
        }

        double longest = 0;
        int[] zuobiao = new int[2];
        for(int i = 0 ; i < distances.size(); i ++){
            if("".equals(distances.get(i))){
                continue;
            }
            Integer[] nums = Stream.of(distances.get(i).split(",")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
            if(nums[0] < 1 || nums[0] > 999 || nums[1] < 1 || nums[1] > 999) {
                continue;
            }

            double distance =  Math.pow(nums[0], 2) + Math.pow(nums[1], 2);
            if(longest < distance){
                longest = distance;
                zuobiao[0] = nums[0];
                zuobiao[1] = nums[1];
            }
      
        }

        ans.append("(").append(zuobiao[0]).append(",").append(zuobiao[1]).append(")");
        return ans.toString();
    }
}
