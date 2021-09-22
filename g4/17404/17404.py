import sys


n = int(sys.stdin.readline())
cost = []
for _ in range(n):
    cost.append(list(map(int, sys.stdin.readline().split())))
dp = [[0 for _ in range(3)] for _ in range(n)]
answer = float('inf')
for color in range(3):
    for i in range(3):
        dp[0][i] = float('inf') if i != color else cost[0][i]
    for i in range(1, n):
        dp[i][0] = cost[i][0] + min(dp[i-1][1], dp[i-1][2])
        dp[i][1] = cost[i][1] + min(dp[i-1][0], dp[i-1][2])
        dp[i][2] = cost[i][2] + min(dp[i-1][0], dp[i-1][1])
    for i in range(3):
        if i != color:
            answer = min(answer, dp[n-1][i])
print(answer)
