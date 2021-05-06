n = int(input())
dp = [1, 3]
for i in range(2, n+1):
    temp = (dp[1]*2+dp[0])%9901
    dp[0] = dp[1]
    dp[1] = temp
print(dp[1])
