"""
骰子是一个立方体，每个面一个数字，初始为左1，右2，前3（观察者方向），后4，上5，下6，用123456表示这个状态，放置到平面上，可以向左翻转（用L表示
向左翻转1次），可以向右翻转（用R表示向右翻转1次），可以向前翻转（用F表示向前翻转1次），可以向后翻转（用B表示向后翻转1次），可以逆时针旋转（用A
表示逆时针旋转90度），可以顺时针旋转（用C表示顺时针旋转90度），现从123456这个初始状态开始，根据输入的动作序列，计算得到最终的状态。
骰子的初始状态和初始状态转动后的状态如图所示
输入描述：
输入一行，为只包含LRFBAC的字母序列，最大长度50，字母可重复
输出描述：
输出最终状态
示例1：
输入
LR
输出
123456
"""


class Dice:
    def __init__(self):
        self.dice = [0, 1, 2, 3, 4, 5, 6]

    def show(self) -> str:
        list = self.dice[1:]
        return ''.join([str(x) for x in list])

    def left(self):
        temp1 = self.dice[1]
        temp2 = self.dice[2]
        self.dice[1] = self.dice[5]
        self.dice[2] = self.dice[6]
        self.dice[5] = temp2
        self.dice[6] = temp1

    def right(self):
        temp1 = self.dice[1]
        temp2 = self.dice[2]
        self.dice[1] = self.dice[6]
        self.dice[2] = self.dice[5]
        self.dice[5] = temp1
        self.dice[6] = temp2

    def front(self):
        temp3 = self.dice[3]
        temp4 = self.dice[4]
        self.dice[3] = self.dice[5]
        self.dice[4] = self.dice[6]
        self.dice[5] = temp4
        self.dice[6] = temp3

    def back(self):
        temp3 = self.dice[3]
        temp4 = self.dice[4]
        self.dice[3] = self.dice[6]
        self.dice[4] = self.dice[5]
        self.dice[5] = temp3
        self.dice[6] = temp4

    def clockwise(self):
        temp1 = self.dice[1]
        temp2 = self.dice[2]
        self.dice[1] = self.dice[3]
        self.dice[2] = self.dice[4]
        self.dice[3] = temp2
        self.dice[4] = temp1

    def anticlockwise(self):
        temp1 = self.dice[1]
        temp2 = self.dice[2]
        self.dice[1] = self.dice[4]
        self.dice[2] = self.dice[3]
        self.dice[3] = temp1
        self.dice[4] = temp2

    def process(self, cur: str):
        if cur == 'L':
            self.left()
        elif cur == 'R':
            self.right()
        elif cur == 'F':
            self.front()
        elif cur == 'B':
            self.back()
        elif cur == 'C':
            self.clockwise()
        elif cur == 'A':
            self.anticlockwise()


def process(p: str) -> None:
    d = Dice()
    print(d.show())
    for cur in p:
        d.process(cur)
    print(d.show())


if __name__ == '__main__':
    process('R')
    process('B')
    # processAdvance('C')
