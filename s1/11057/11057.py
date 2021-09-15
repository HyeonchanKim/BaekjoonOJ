n = int(input())
dp = [[0 for _ in range(10)] for _ in range(n+1)]
for i in range(10):
    dp[1][i] = 1

for i in range(2, n+1):
    for j in range(10):
        for k in range(j, 10):
            dp[i][k] += dp[i-1][j]
            dp[i][k] %= 10007
print(sum(dp[n])%10007)
