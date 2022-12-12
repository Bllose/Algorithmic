"""
在学校中，N个小朋友站成一队， 第i个小朋友的身高为height[i]，
第i个小朋友可以看到的第一个比自己身高更高的小朋友j，那么j是i的好朋友(要求j > i)。
请重新生成一个列表，对应位置的输出是每个小朋友的好朋友位置，如果没有看到好朋友，请在该位置用0代替。
小朋友人数范围是 [0, 40000]。
输入描述：
第一行输入N，N表示有N个小朋友
第二行输入N个小朋友的身高height[i]，都是整数
输出描述：
输出N个小朋友的好朋友的位置
示例1：
输入
2
100 95
输出
0 0
"""


def findfriends(child:[]):
    recorder = {}
    ans = [0] * len(child)
    for i in range(len(child)):
        height = child[i]
        position = 0
        for h in recorder:
            if h > height and recorder[h] > position:
                position = recorder[h]
        ans[i] = position
        recorder[height] = i
    print(ans)


if __name__ == '__main__':
    findfriends('100 95 77 88 66 11 22 33 12'.split(' '))

