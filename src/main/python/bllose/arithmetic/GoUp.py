def L(nums, i) -> int:

    if i == len(nums) - 1:
        return 1

    max_len = 1
    for j in range(i+1, len(nums)):
        if nums[j] > nums[i]:
            max_len = max(max_len, L(nums, j) + 1)
    return max_len


def length_of_LIS(nums) -> int:
    return max(L(nums, i) for i in range(len(nums)))


def iterative(nums) -> int:
    length = len(nums)
    recorder = [1] * length 

    for i in reversed(range(length)):
        for j in range(i+1, length):
            if nums[j] > nums[i]:
                recorder[i] = max(recorder[i], recorder[j] + 1)
    
    return max(recorder)

if __name__ == '__main__':
    nums = [614,812,508,165,266,945,202,444,587,708,459,541,183,359,699,274,318,576,744,289,478,102,895,8,158,894,481,271,107,993,567,455,875,815,838,598,819,795,446,707,379,747,339,233,58,149,884,448,893,225,863,984,520,916,340,600,399,88,85,908,572,896,396,56,681,801,936,362,978,334,208,314,186,609,390,404,488,25,938,524,751,468,680,874,995,923,935,429,180,817,689,753,501,72,357,94,977,432,545,70]
    import datetime
    
    start = datetime.datetime.now()
    print(length_of_LIS(nums))
    print("耗时: {}秒".format({datetime.datetime.now() - start}))

    start = datetime.datetime.now()
    print(iterative(nums))
    print("耗时: {}秒".format({datetime.datetime.now() - start}))