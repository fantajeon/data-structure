dataSet = [8, 4, 7, 3, 1, 5]

def sort(dataSet):
    loop = 0
    for count in range(len(dataSet) - 1, 0, -1):
        for idx in range(0, count, 1):
            print("count[%d] idx[%d] : %d , %d" % (count, idx, dataSet[idx], dataSet[idx + 1]))
            loop += 1
            if dataSet[idx] > dataSet[idx + 1]:
                dataSet[idx], dataSet[idx +1] = dataSet[idx + 1], dataSet[idx]
        print("=======================");
    print(dataSet)
    print("total loop : %d" % loop)

sort(dataSet)
