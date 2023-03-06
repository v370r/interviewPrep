def minCoins(coins, target):
    m = len(coins)
    dp =  [[0]*(m+1) for i in range(0,target+1)];

    for x in range(0,m+1):
        dp[0][x] = 0;
    
    for x in range(1,target+1):
        dp[x][0] = float('inf') # no issue use buffer over flow max_Value +1 is negatrive :()

    for i in range(1,target+1):
        for j in range(1,m+1):
            if (i >= coins[j - 1]):
                dp[i][j] = min(1 + dp[i - coins[j - 1]][j], dp[i][j - 1]);
            else:
                dp[i][j] = dp[i][j - 1];

    return dp[target][m];

coins = [ 9, 6, 5, 1];
target = 11
print("Min coins needed", minCoins(coins,target))
