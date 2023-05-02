# 처음에 a를 list로 하고 돌리면 시간초과 나지만 set로 하니까 됐음;;

import sys

n = int(sys.stdin.readline())
a = set(map(int, sys.stdin.readline().split()))

m = int(sys.stdin.readline())
b = list(map(int, sys.stdin.readline().split()))


for i in range(len(b)):
    if b[i] in a:
        b[i] = 1
    else:
        b[i] = 0

for j in b:
    print(j, end=" ")
