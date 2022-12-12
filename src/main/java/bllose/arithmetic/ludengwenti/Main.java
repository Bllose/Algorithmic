package bllose.arithmetic.ludengwenti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    static {
        try {
            System.setIn(new FileInputStream("src\\main\\java\\bllose\\arithmetic\\ludengwenti\\source.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 未被点亮问题，路灯之间固定100米距离
     * 灯照亮范围 0 ~ 10^6
     * 路灯数量 2 ~ 100000
     * 求第一个路灯到最后一个路灯之间有多少米是未被照亮的
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        in.nextLine();
        String lights = in.nextLine();
        System.out.println(noLightArea(lights, total));
    }

    public static int noLightArea(String areas, int total){
        int totalLength = (total - 1) * 100;
        Integer[] eachArea = Stream.of(areas.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        Integer[][] lightedArea = new Integer[eachArea.length][2];

        // 记录第一盏灯的照亮范围
        lightedArea[0][0] = 0;
        lightedArea[0][1] = eachArea[0];

        for(int i = 1 ; i < eachArea.length; i ++){
            if(eachArea[i] >= totalLength) {
                // 只要有一盏灯的半角已经超过了总长度， 那么未被照亮的距离就是0
                return 0;
            }
            int position = i * 100;
            int left = position - eachArea[i];
            int right = position + eachArea[i];

            for(int j = i - 1 ; j > -1 ; j --){
                // 向左边拓展，检查是否存在跨灯的照亮覆盖
                // 若前一盏灯已经被覆盖就继续往前找
                if(lightedArea[j][0] == null){
                    continue;
                }
                // 如果之前有一盏灯已经完全覆盖了当前灯， 那么这盏灯就没必要统计了
                if(lightedArea[j][1] > right){
                    break;
                }
                // 如果之前有灯的照明范围与当前灯有叠加， 那么就可以连成一片
                if(lightedArea[j][0] < left && lightedArea[j][1] > left){
                    lightedArea[j][1] = right;
                    break;
                }
                // 如果当前灯，将前面灯覆盖了， 那么前面灯清空， 并保存当前灯
                if(left < lightedArea[j][0]){
                    lightedArea[i][0] = left;
                    lightedArea[i][1] = right;
                    lightedArea[j][0] = null;
                    break;
                }
                // 若前面照亮范围与当前灯没有交集， 那么当前灯就单独记录下来
                if(lightedArea[j][1] < left){
                    lightedArea[i][0] = left;
                    lightedArea[i][1] = right;
                    break;
                }
            }
        }


        int len = 0;
        int left = 0;
        int right = 0;
        for(int i = 0 ; i < lightedArea.length; i ++){
            if(lightedArea[i][0] == null){
                continue;
            }
            // 第一次记录
            if(right == 0){
                left = lightedArea[i][0];
                right = lightedArea[i][1];
                // 可能存在首部的未被照亮的部分
                if( left > 0){
                    len += left;
                }
                continue;
            }

            // 右侧等的左边边缘 减去 左侧灯的右边边缘 等于 未照明长度
            len += lightedArea[i][0] - right;

            right = lightedArea[i][1];
        }

        // 尾端如果还存在未被照明部分，则需要统计进去
        if(totalLength - right > 0){
            len += totalLength - right;
        }

        return len;
    }

    private static int noLightLength(String areas, int total){
        int lenWithNoLight = 0;
        int totalLength = (total - 1) * 100;

        Integer[] each = Stream.of(areas.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        List<Integer[]> recorder = new ArrayList();
        for(int i = 0; i < total; i ++){
            int left = i * 100 - each[i];
            int right = i * 100 + each[i];
            if(recorder.size() == 0){
                recorder.add(new Integer[]{left, right});
                continue;
            }
            for(int j = 0; j < recorder.size(); j ++){
                Integer[] light = recorder.get(j);
                if(light[0] < left && light[1] > right){
                    break;
                }else if(light[1] > left && light[1] < right){
                    recorder.set(j, new Integer[]{light[0], right});
                }else{
                    recorder.add(new Integer[]{left, right});
                    break;
                }
            }
        }

        for(int right = 1; right < recorder.size(); right ++){
            int left = right - 1;
            lenWithNoLight += recorder.get(right)[0] - recorder.get(left)[1];
        }

        if(recorder != null && recorder.size() > 0){
            int end = totalLength - recorder.get(recorder.size() - 1)[1];
            if(end > 0){
                lenWithNoLight += end;
            }
        }

        return lenWithNoLight;
    }
}
