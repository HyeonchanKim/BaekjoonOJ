import sys
n = int(sys.stdin.readline())
todo = []
for i in range(n):
    todo.append(list(map(str, sys.stdin.readline().split())))
    todo[i].append(True)
for i in reversed(range(n)):
    job, word, time, check_undo = todo[i]
    if job == "undo" and check_undo:
        undo_time = int(time)-int(word)
        for j in reversed(range(i)):
            if undo_time > int(todo[j][2]):
                break
            todo[j][3] = False
answer = ""
for i in todo:
    if i[0] == "type" and i[3]:
        answer += i[1]
print(answer)
