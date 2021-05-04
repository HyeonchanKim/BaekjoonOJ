n = int(input())
pan = []
for _ in range(n):
    pan.append(list(map(int, input().split())))
count_visit = [[0 for _ in range(n)] for _ in range(n)]
count_visit[0][0] = 1
for i in range(n):
    for j in range(n):
        val = pan[i][j]
        if val == 0:
            continue
        if i + val < n:
            count_visit[i+val][j] += count_visit[i][j]
        if j + val < n:
            count_visit[i][j+val] += count_visit[i][j]
print(count_visit[n-1][n-1])
