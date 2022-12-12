"""
A、B两个人把苹果分为两堆，A希望按照他的计算规则等分苹果，他的计算规则是按照二进制加法计算，并且不计算进位 12+5=9(1100 + 0101=9)，B的计算规则
是十进制加法，包括正常进位，B希望在满足A的情况下获取苹果重量最多。输入苹果的数量和每个苹果重量，输出满足A的情况下B获取的苹果总重量。如果无法满
足A的要求，输出-1。
数据范围
1<= 总苹果数量 <= 20000
1 <= 每个苹果重量 <= 10000
输入描述：
输入第一行是苹果数量： 3
输入第二行是每个苹果重量： 3 5 6
输出描述：
输出第一行是B获取的苹果总重量：11
备注：
按照A的计算方法 5+6=3（101+110不算进位的话值为3）
示例1：
输入
3
3 5 6
输出
11
"""

def split_apples(apples:str) -> int:
    appList = apples.split(' ')
    appList = [int(x) for x in appList]
    appList.sort()
    count = 0
    length = len(appList)

    while length > 0:
        weighest = appList[length - 1]
        isMatch = False  # 判断本轮是否有最终匹配的结果
        for second in range(length - 2, 0 , -1):
            third = weighest ^ appList[second]
            if third not in appList:
                continue
            for i in range(length - 2):
                if i == second:
                    continue
                if appList[i] == third:
                    print(length-1, ':', weighest, '^', second, ':', appList[second], '=', i, ':', third)
                    count += weighest
                    count += appList[second]
                    appList.pop(second)
                    appList.remove(weighest)
                    appList.remove(third)
                    length = len(appList)
                    isMatch = True
                    break
            # 如果是因为匹配上结果而结束， 那么结束子循环， 准备重新定位最重苹果
            if isMatch:
                break
        # 存在无法匹配的苹果，直接退出最外侧循环。 即A的要求无法达到
        if not isMatch:
            break

    if length != 0:
        return -1
    return count


if __name__ == '__main__':
    # print('B 将获取苹果重量: ' ,split_apples('3 5 6'))
    print('B 将获取苹果重量: ', split_apples('1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18'))
