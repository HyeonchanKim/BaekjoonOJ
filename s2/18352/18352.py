import sys
import collections
n, m , k, x = map(int, sys.stdin.readline().split())
adj_list = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    adj_list[a].append(b)
dq = collections.deque()
visit = [False for _ in range(n+1)]
visit[x] = True
dq.append([x, 0])
answer = []
while dq:
    node = dq.popleft()
    if node[1] == k:
        answer.append(node[0])
    elif node[1] > k:
        break
    for i in adj_list[node[0]]:
        if not visit[i]:
            visit[i] = True
            dq.append([i, node[1] + 1])
if len(answer)==0:
    print(-1)
else:
    for i in sorted(answer):
        print(i)
