package bllose.arithmetic.switchsubstring;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 【VLAN资源池】VLAN是一种对局域网设备进行逻辑划分的技术，为了标识不同的VLAN，引入VLAN ID(1-4094之间的整数)的概念。定义一个VLAN ID的资源池
 * (下称VLAN资源池)，资源池中连续的VLAN用开始VLAN-结束VLAN表示，不连续的用单个整数表示，所有的VLAN用英文逗号连接起来。现在有一个VLAN资源
 * 池，业务需要从资源池中申请一个VLAN，需要你输出从VLAN资源池中移除申请的VLAN后的资源池。
 * 输入描述：
 * 第一行为字符串格式的VLAN资源池，第二行为业务要申请的VLAN，VLAN的取值范围为[1,4094]之间的整数。
 * 输出描述：
 * 从输入VLAN资源池中移除申请的VLAN后字符串格式的VLAN资源池，输出要求满足题目描述中的格式，并且按照VLAN从小到大升序输出。
 * 如果申请的VLAN不在原VLAN资源池内，输出原VLAN资源池升序排序后的字符串即可。
 * 备注：
 * 输入VLAN资源池中VLAN的数量取值范围为[2-4094]间的整数，资源池中VLAN不重复且合法([1,4094]之间的整数)，输入是乱序的。
 * 示例1：
 * 输入
 * 1-5
 * 2
 * 输出
 * 1,3-5
 */
public class VlanResourcePool {
    static {
        try {
            System.setIn(new FileInputStream("src\\main\\java\\bllose\\arithmetic\\switchsubstring\\Vlan.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String resourceString = in.nextLine();
        String replyResources = in.nextLine();

        int[] recorder = new int[4094];
        String[] resourcesArray = resourceString.split(" ");
        int maxport = 0;
        for(int i = 0 ; i < resourcesArray.length; i ++){
            String port = resourcesArray[i];
            if(port.contains("-")){
                String[] area = port.split("-");
                int min = Integer.valueOf(area[0]);
                int max = Integer.valueOf(area[1]);
                for(;min <= max; min ++){
                    recorder[min] = 1;
                }
                if(max > maxport){
                    maxport = max;
                }
            }else{
                int index = Integer.valueOf(port);
                if(maxport < index){
                    maxport = index;
                }
                recorder[index] = 1;
            }
        }

        String[] replyArray = replyResources.split(" ");
        for(int i = 0; i < replyArray.length; i ++){
            String port = replyArray[i];
            if(port.contains("-")){
                String[] area = port.split("-");
                int min = Integer.valueOf(area[0]);
                int max = Integer.valueOf(area[1]);
                for(; min <= max && min <= maxport; min ++){
                    recorder[min] = 0;
                }
            }else{
                int index = Integer.valueOf(port);
                if(index <= maxport){
                    recorder[index] = 0;
                }
            }
        }

        StringBuffer ans = new StringBuffer();
        int index = 1;
        while(index <= maxport){
            if(recorder[index] == 1){
                ans.append(index);
                int end = index + 1;
                for(; end <= maxport; ++ end){
                    if(recorder[end] == 0){
                        break;
                    }
                }
                if(end == index + 1){
                    ans.append(",");
                }else{
                    int theEnd = end - 1;
                    ans.append("-").append(theEnd).append(",");
                }
                index = end;
                continue;
            }else{
                index ++;
            }
        }

        System.out.println(ans.subSequence(0, ans.length()-1));
    }
}
