t = int(input())
k = []
n = []
for _ in range(t):
    k.append(int(input()))
    n.append(int(input()))
apart = [[] for _ in range(max(k)+1)]
for i in range(max(n)):
    apart[0].append(i+1)
for i in range(1, len(apart)):
    apart[i].append(1)
    for j in range(1, max(n)):
        apart[i].append(apart[i][j-1] + apart[i-1][j])
for i in range(t):
    print(apart[k[i]][n[i]-1])
