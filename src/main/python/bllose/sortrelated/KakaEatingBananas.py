from typing import List
from math import ceil

def KakaEatingBananas(pilts:List, times:int) -> int:
    if pilts is None or len(pilts) > times:
        return -1

    right, left = max(pilts), 1

    while left != right:
        middle = int((left + right)/2)
        if eating(pilts, times, middle):
            if right == middle:
                right -= 1
                middle -= 1
            else:
                right = middle
        else:
            if left == middle:
                left += 1
                middle += 1
            else:
                left = middle
    return int(left)


def eating(pilts:List, times:int, eachTime:int) -> bool:
    timeUsed = 0
    for pilt in pilts:
        timeUsed += ceil(pilt/eachTime)
        if timeUsed > times:
            return False
    
    return True




if __name__ == '__main__':
    numEachTime = KakaEatingBananas([1,2,3], 3)
    print(numEachTime)