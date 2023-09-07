from collections import deque
import sys

queue = deque()

n, k = map(int, sys.stdin.readline().split())

for i in range(1, n+1):
    queue.append(i)

index = 0
l = []

while queue:
    index += 1
    a = queue.popleft()
    if index == k:
        l.append(a)
        index = 0
        continue
    queue.append(a)

print('<', end='')
for i in range(len(l)-1):
    print(l[i], end=', ')
print(f"{l[-1]}>")