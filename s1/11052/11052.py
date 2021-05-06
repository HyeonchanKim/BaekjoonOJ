import sys
n = int(sys.stdin.readline())
p = list(map(int, sys.stdin.readline().split()))
for i in range(n):
    for j in range(i):
        p[i] = max(p[i-j-1] + p[j], p[i])
print(p[n-1])
