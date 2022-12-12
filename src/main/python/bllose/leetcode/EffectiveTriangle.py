
def triangleNumber(nums:[]) -> int:
    if len(nums) < 3:
        return 0
    nums.sort()
    counter = 0
    for edge1 in range(len(nums) - 2):
        for edge2 in range(edge1 + 1, len(nums) - 1):
            twoEdge = nums[edge1] + nums[edge2]
            for edge3 in range(edge2 + 1, len(nums)):
                if twoEdge > nums[edge3]:
                    counter += 1
    return counter


def triangleNumberDichotomy(nums:[]) -> int:
    if len(nums) < 3:
        return 0
    nums.sort()
    counter = 0
    lenAmount = len(nums)
    for edge1 in range(lenAmount - 2):
        for edge2 in range(edge1 + 1, lenAmount - 1):
            twoEdgeLen = nums[edge1] + nums[edge2]
            # 二分查找开始
            # 基本原理是找到小于另两边和的临界点， 那么从第二边开始数，一直到临界点都是符合情况
            searchIndex = int(edge2 + int((lenAmount - edge2)/2))
            while nums[searchIndex] < twoEdgeLen and searchIndex < lenAmount:
                searchIndex += int((lenAmount - searchIndex)/2)
                if searchIndex == lenAmount - 1:
                    break
            while nums[searchIndex] >= twoEdgeLen and searchIndex > edge2:
                searchIndex -= 1
            if nums[searchIndex] < twoEdgeLen:
                counter += searchIndex - edge2
    return counter

if __name__ == '__main__':
    print(str(triangleNumberDichotomy([4,2,3,4])))
