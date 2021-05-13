s, k = map(int, input().split())
mod = s%k
answer = 1
for i in range(mod):
    answer *= s//k+1
for i in range(k-mod):
    answer *= s//k
print(answer)
