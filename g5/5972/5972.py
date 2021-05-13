import sys
import heapq
n, m = map(int, sys.stdin.readline().split())
adj_list = [[] for _ in range(n+1)]
for _ in range(m):
    a, b, c = map(int, sys.stdin.readline().split())
    adj_list[a].append([b, c])
    adj_list[b].append([a, c])
q = [[0, 1]]
cow = [float('inf') for _ in range(n+1)]
cow[1] = 0
while q:
    node = heapq.heappop(q)
    if node[1] == n:
        break
    if node[0] > cow[node[1]]:
        continue
    for i in adj_list[node[1]]:
        alt = node[0] + i[1]
        if alt < cow[i[0]]:
            cow[i[0]] = alt
            heapq.heappush(q, [alt, i[0]])
print(cow[n])
