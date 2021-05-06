import sys
n = int(sys.stdin.readline())
seq = list(map(int, sys.stdin.readline().split()))
_sum = 0
dp = [seq[0]]
for i in range(1, n):
    if dp[i-1] > 0:
        dp.append(dp[i-1] + seq[i])
    else:
        dp.append(seq[i])
print(max(dp))
