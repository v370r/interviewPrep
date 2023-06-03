import math


def kokoEatingBananaes(piles, h):
    def check(piles, rate):
        return sum([math.ceil(x/rate) for x in piles])
    left =1; right = max(piles); #first used sum(piles)*h
    while(left<=right):
        mid = (left+right)//2;
        if (check(piles,mid)>h):
            left = mid+1
        else:
            right = mid-1
    return left;

piles=[30,11,23,4,20]; hours = 5;
print(kokoEatingBananaes(piles,hours))
