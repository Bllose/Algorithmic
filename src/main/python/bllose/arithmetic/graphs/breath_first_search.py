"""
9、【可以组成网络的服务器】在一个机房中，服务器的位置标识在 n*m 的整数矩阵网格中，1 表示单元格上有服务器，0 表示没有。如果两台服务器位于同一行或者
同一列中紧邻的位置，则认为它们之间可以组成一个局域网。
请你统计机房中最大的局域网包含的服务器个数。

输入描述：
第一行输入两个正整数，n和m，0<n,m<=100
之后为n*m的二维数组，代表服务器信息

输出描述：
最大局域网包含的服务器个数。

示例1：
输入
2 2
1 0
1 1
输出
3
"""

def MaxLocalAreaNetwork(rows:int, columns:int, nets:[]) -> int:
    from queue import Queue
    queue = Queue()

    ans = 0
    for row in range(rows):
        for column in range(columns):
            if nets[row][column] == 0:
                continue
            else:
                queue.put(row)
                queue.put(column)
                nets[row][column] = 0
            recorder = 1
            while not queue.empty():
                r = queue.get()
                c = queue.get()
                if c - 1 > -1:
                    if nets[r][c - 1] == 1:
                        queue.put(r)
                        queue.put(c-1)
                        recorder += 1
                        nets[r][c - 1] = 0
                if r - 1 > -1:
                    if nets[r - 1][c] == 1:
                        queue.put(r - 1)
                        queue.put(c)
                        recorder += 1
                        nets[r - 1][c] = 0
                if c + 1 < columns:
                    if nets[r][c + 1] == 1:
                        queue.put(r)
                        queue.put(c + 1)
                        recorder += 1
                        nets[r][c + 1] = 0
                if r + 1 < rows:
                    if nets[r + 1][c] == 1:
                        queue.put(r + 1)
                        queue.put(c)
                        recorder += 1
                        nets[r + 1][c] = 0
            if ans < recorder:
                ans = recorder
    return ans


if __name__ == '__main__':
    print(MaxLocalAreaNetwork(2, 2, [[1, 0],[1, 1]]))
