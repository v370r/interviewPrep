from heapq import *
def kthLargestNumber(nums, k):
    nums = [-int(x) for x in nums]
    heapify(nums)
    for x in range(0,k-1):
        heappop(nums)
    return -heappop(nums)

nums = ["3","6","7","10"]
k = 4
print(kthLargestNumber(nums,k))



    
    