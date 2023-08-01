# TODO: Understand carefully
def combinations(n: int, k: int):
    res = []
    
    def backtrack(start, comb):
        if len(comb) == k:
            res.append(comb.copy())
            return 
        
        for i in range(start, n+1):
            comb.append(i)
            backtrack(i+1, comb)
            comb.pop()
    backtrack(1,[])
    return res

print(combinations(4,2))
            