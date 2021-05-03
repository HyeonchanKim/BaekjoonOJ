import sys
n = int(sys.stdin.readline())
budget = list(map(int, sys.stdin.readline().split()))
budget.sort(reverse=True)
total = int(sys.stdin.readline())
answer = 0
while budget:
    avg = total//len(budget)
    answer = budget[-1]
    if avg >= answer:
        total -= answer
        budget.pop()
    else:
        break
print(total//len(budget) if len(budget)>0 else answer)
