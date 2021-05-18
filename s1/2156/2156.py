import sys
n = int(sys.stdin.readline())
cup = []
for _ in range(n):
    cup.append(int(sys.stdin.readline()))
dp = [[cup[0]], [cup[0]], [0]]
for i in range(1, n):
    dp[0].append(dp[2][i-1]+cup[i])
    dp[1].append(dp[0][i-1]+cup[i])
    dp[2].append(max(dp[0][i-1], dp[1][i-1], dp[2][i-1]))
print(max(dp[0][n-1], dp[1][n-1], dp[2][n-1]))
