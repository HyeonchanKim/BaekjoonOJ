from collections import deque
f, s, g, u, d = map(int, input().split())
visit = [False for _ in range(f+1)]
visit[s] = True
check_arrive = False
answer = 0
dq = deque()
dq.append([s, 0])
while dq:
    now_floor, count = dq.popleft()
    if now_floor == g:
        check_arrive = True
        answer = count
        break
    floor_u = now_floor + u
    floor_d = now_floor - d
    
    if floor_u <= f and not visit[floor_u]:
        visit[floor_u] = True
        dq.append([floor_u, count+1])
    if floor_d > 0 and not visit[floor_d]:
        visit[floor_d] = True
        dq.append([floor_d, count+1])
print(answer if check_arrive else "use the stairs")
