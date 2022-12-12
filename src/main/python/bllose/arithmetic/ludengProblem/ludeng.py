
'''
未被照亮的路长度
@:param areas 每盏灯照明半径
@:param total 灯总数
@:return 未被照亮路段长度
'''
def ludengProblem(areas:str, total:int) -> int:
    areas = [int(x) for x in areas.split(' ')]

    # recorder = [[-1] * 2] * total 浅拷贝，只有第一行有效， 后续全部都是索引，改值会一列一列进行修改
    recorder = [[-1] * 2 for _ in range(total)]
    recorder[0][0] = 0
    recorder[0][1] = areas[0]

    total = (total - 1) * 100

    # 记录灯光照明范围， 动态融合灯之间的照明关系，以减少判断次数
    for index in range(1, len(areas)):
        if areas[index] >= total:
            return 0
        position = index * 100
        left = position - areas[index]
        right = position + areas[index]


        needRecord = True
        # 回头查找前面的灯照明情况，然后进行相关记录
        for searcher in range(index -1, -1, -1):
            if recorder[searcher] == None or recorder[searcher][0] == -1:
                continue
            # 如果前面的灯已经完全覆盖当前灯，那么当前灯便没有必要记录了
            if recorder[searcher][1] >= right:
                needRecord = False
                break
            # 如果前面的灯覆盖区域与当前灯有重叠的部分，则连成一片
            if recorder[searcher][0] <= left and recorder[searcher][1] >= right:
                recorder[searcher][1] = right
                needRecord = False
                break
            # 如果当前灯照明区域已经完全覆盖前面的灯，那么将前面的灯剔除出去
            if recorder[searcher][0] >= left:
                recorder[searcher] = None
                continue
            if recorder[searcher][1] > left:
                recorder[index][0] = left
                recorder[index][1] = right
                needRecord = False
                break
        if needRecord:
            recorder[index][0] = left
            recorder[index][1] = right

    #遍历前面统计好的照明范围， 统计未被照明的长度
    darkArea = 0
    right = 0
    for area in recorder:
        if area is None or area[0] == -1:
            continue
        if area[0] > 0 and right == 0:
            darkArea += area[0]
            right = area[1]
        elif area[0] - right > 0:
            darkArea += area[0] - right
            right = area[1]
        else:
            right = area[1]

    if total > right:
        darkArea += total - right

    return darkArea


if __name__ == '__main__':
    print(ludengProblem('1 150 1 49', 4))
