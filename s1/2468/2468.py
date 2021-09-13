import sys
from collections import deque


n = int(sys.stdin.readline())
height = []
max_num = 0
for _ in range(n):
    height.append(list(map(int, sys.stdin.readline().split())))
    max_num = max(max_num, max(height[-1]))
move_x = [1, -1, 0, 0]
move_y = [0, 0, 1, -1]
answer = 1

for rain in range(max_num):
    visit = [[False for _ in range(n)] for _ in range(n)]
    count_region = 0
    for i in range(n):
        for j in range(n):
            if not visit[i][j]:
                visit[i][j] = True
                if height[i][j] > rain:
                    count_region += 1
                    dq = deque()
                    dq.append([i, j])
                    while dq:
                        now = dq.popleft()
                        for k in range(4):
                            x = now[0] + move_x[k]
                            y = now[1] + move_y[k]
                            if 0 <= x < n and 0 <= y < n and not visit[x][y] and height[x][y] > rain:
                                visit[x][y] = True
                                dq.append([x, y])
    answer = max(answer, count_region)
print(answer)
