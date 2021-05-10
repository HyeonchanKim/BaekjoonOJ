import sys
n = int(sys.stdin.readline())
box = list(map(int, sys.stdin.readline().split()))
dp = [1]*n
for i in range(n):
    for j in range(i):
        if box[i]>box[j] and dp[i]<dp[j]+1:
            dp[i] = dp[j] + 1
print(max(dp))
